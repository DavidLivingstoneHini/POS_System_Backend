package com.kamakz.kamakzbackend.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.kamakz.kamakzbackend.model.*;
import com.kamakz.kamakzbackend.model.constants.Company;
import com.kamakz.kamakzbackend.model.constants.Partner;
import com.kamakz.kamakzbackend.repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kamakz.kamakzbackend.repository.constants.CompanyRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SalesOrderService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Autowired
    private SalesOrderDetailRepository salesOrderDetailRepository;

    @Autowired
    private SalesOrderPaymentRepository salesOrderPaymentRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private PartnerRepository partnerRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public String getOrders(Integer staffId) {
        try {
            User user = userRepository.findById(Math.toIntExact(staffId)).orElse(null);
            if (user != null) {
                Company company = user.getCompany();
                List<SalesOrder> salesOrders;
                if ("Y".equals(user.getCashier())) {
                    salesOrders = salesOrderRepository.findByCompanyAndInProgressforPOS(company, true);
                } else {
                    salesOrders = salesOrderRepository.findByCompanyAndCreatorAndInProgressforPOS(company, user, true);
                }
                List<PosOrder> posOrders = new ArrayList<>();
                if (!salesOrders.isEmpty()) {
                    for (SalesOrder o : salesOrders) {
                        PosOrder posOrder = new PosOrder();
                        posOrder.setOrderId(Long.valueOf(o.getId()));
                        posOrder.setOrderNumber(o.getOrderNumber());
                        posOrder.setCreatedOn(o.getCreatedOn().toString());
                        posOrder.setUserName(user.getUsername());
                        posOrders.add(posOrder);
                    }
                }
                PosOrders orders = new PosOrders();
                orders.setStatus(1);
                orders.setMessage("Success");
                orders.setUserId(Long.valueOf(staffId));
                orders.setUserName(user.getUsername());
                orders.setCompanyName(company.getCompanyName());
                orders.setPosOrders(posOrders);
                return objectMapper.writeValueAsString(orders);
            } else {
                return "The Url did not existing user ID";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "End";
        }
    }

    public String getOrderDetails(Long orderId) {
        try {
            Optional<SalesOrder> optionalSalesOrder = salesOrderRepository.findById(orderId);
            if (optionalSalesOrder.isPresent()) {
                SalesOrder salesOrder = optionalSalesOrder.get();

                OrderDetailsResponse response = new OrderDetailsResponse();
                response.setStatus(1);
                response.setMessage("Successful");
                response.setOrderId(Long.valueOf(String.valueOf(salesOrder.getId())));
                response.setOrderNumber(salesOrder.getSalesReference());
                response.setOrderUser(salesOrder.getSalesPerson().getUsername());
                response.setCustomerName(salesOrder.getForCustomerOrTable());
                response.setCustomerNumber(salesOrder.getCustomerReference());
                response.setCustomerTelephone(salesOrder.getMainContact());
                response.setOrderDate(salesOrder.getRequestedDate().toString());
                response.setPosOrderHeadDetails(convertToOrderDetailDTO(salesOrder));

                return objectMapper.writeValueAsString(response);
            } else {
                return "{\"status\":0,\"message\":\"Order not found\"}";
            }
        } catch (Exception e) {
            e.printStackTrace(); // Replace with a logging framework
            return "{\"status\":0,\"message\":\"Error retrieving order details\"}";
        }
    }

    public static class OrderRequest {
        private SalesOrder salesOrder;
        private List<SalesOrderDetail> details;
        private List<SalesOrderPayment> payments;

        // Getters and Setters
        public SalesOrder getSalesOrder() {
            return salesOrder;
        }

        public void setSalesOrder(SalesOrder salesOrder) {
            this.salesOrder = salesOrder;
        }

        public List<SalesOrderDetail> getDetails() {
            return details;
        }

        public void setDetails(List<SalesOrderDetail> details) {
            this.details = details;
        }

        public List<SalesOrderPayment> getPayments() {
            return payments;
        }

        public void setPayments(List<SalesOrderPayment> payments) {
            this.payments = payments;
        }
    }

    @Transactional
    public String deleteOrderDetail(Long detailid) {
        try {
            salesOrderDetailRepository.deleteById(detailid);
            return "Deleted.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Not Deleted.";
        }
    }

    @Transactional
    public void deleteOrder(Long orderId) throws Exception {
        // Check if the order exists
        SalesOrder salesOrder = salesOrderRepository.findById(orderId)
                .orElseThrow(() -> new Exception("Order not found with ID: " + orderId));

        // Delete associated order details and payments
        salesOrderDetailRepository.deleteAllBySalesOrder(salesOrder);
        salesOrderPaymentRepository.deleteAllBySalesOrder(salesOrder);

        // Delete the order itself
        salesOrderRepository.delete(salesOrder);
    }

    @Transactional
    public ResponseEntity<?> saveOrder(Map<String, Object> orderData) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            JsonNode obj = objectMapper.convertValue(orderData, JsonNode.class);

            // Log the incoming JSON structure
            System.out.println("Incoming Order Data: " + obj.toString());

            // Extract necessary fields using safe access methods
            String affectStock = getValueAsString(obj, "affectStock");
            String orderId = getValueAsString(obj, "orderId");
            String staffId = getValueAsString(obj, "staffid");
            int companyId = getValueAsInt(obj, "companyid");

            String customerName = getValueAsString(obj, "customerName");
            String customerNumber = getValueAsString(obj, "customerNumber");
            String customerTelephone = getValueAsString(obj, "customerTelephone", "None");
            Double subtotal = getValueAsDouble(obj, "subTotal");
            Double discount = getValueAsDouble(obj, "discount");
            Double tax = getValueAsDouble(obj, "tax");
            Double grandTotal = getValueAsDouble(obj, "grandTotal");
            Double payments = getValueAsDouble(obj, "payments");
            Double customerExtraDiscount = getValueAsDouble(obj, "customerExtraDiscount", 0.0);
            Double customerDiscountRate = getValueAsDouble(obj, "customerDiscountRate", 0.0);
            Boolean inProgress = getValueAsBoolean(obj, "inprogress");

            // Retrieve User and Company entities
            User user = userRepository.findById(Integer.parseInt(staffId))
                    .orElseThrow(() -> new Exception("User not found"));
            Company company = companyRepository.findById(companyId)
                    .orElseThrow(() -> new Exception("Company not found"));

            SalesOrder salesOrder;
            long ordId;

            if ("000".equals(orderId)) {
                // New Order
                ordId = generateUniqueOrderId();
                salesOrder = createNewOrder(obj, user, company, customerName, customerNumber, customerTelephone,
                        subtotal, discount, tax, grandTotal, payments,
                        customerDiscountRate, customerExtraDiscount, inProgress);
            } else {
                // Existing Order
                ordId = Long.parseLong(orderId);
                salesOrder = updateExistingOrder(obj, ordId, customerName, customerNumber, customerTelephone,
                        subtotal, discount, tax, grandTotal, payments,
                        customerDiscountRate, customerExtraDiscount, inProgress);
            }

            // Handle Payments
            processPayments(obj.get("paymentList"), salesOrder);

            // Handle Order Details
            processOrderDetails(obj.get("products"), salesOrder);

            return ResponseEntity.ok(Map.of("orderId", ordId, "message", "Order saved successfully!"));
        } catch (Exception e) {
            e.printStackTrace();

            // Return a JSON response with the error message
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("success", "false");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    // Method to generate unique ID
    private long generateUniqueOrderId() {
        // Use the maximum existing ID + 1 to ensure uniqueness
        Long maxId = salesOrderRepository.findMaxOrderId();  // Assuming you have a method to fetch the max ID
        return (maxId != null ? maxId + 1 : 1); // Start with 1 if no orders exist
    }

    private SalesOrder createNewOrder(JsonNode obj, User user, Company company, String customerName,
                                      String customerNumber, String customerTelephone, Double subtotal,
                                      Double discount, Double tax, Double grandTotal, Double payments,
                                      Double customerDiscountRate, Double customerExtraDiscount, Boolean inProgress) {
        SalesOrder salesOrder = new SalesOrder();
        salesOrder.setCompany(company);
        salesOrder.setSalesPerson(user);
        salesOrder.setCreator(user);
        salesOrder.setPrepearedBy(user.getUsername());
        salesOrder.setMainContact(customerTelephone);
        salesOrder.setCustomerReference(customerNumber);
        salesOrder.setForCustomerOrTable(customerName);
        salesOrder.setStatus("New");
        salesOrder.setSalesChannels("POS");
        salesOrder.setSalesReference(UUID.randomUUID().toString());
        salesOrder.setRetrieveCode(UUID.randomUUID().toString());
        salesOrder.setInProgressforPOS(inProgress);
        salesOrder.setSubTotal(subtotal);
        salesOrder.setSalesTax(tax);
        salesOrder.setDiscount(discount);
        salesOrder.setGrandTotal(grandTotal);
        salesOrder.setPayments(payments);
        salesOrder.setCustomerDiscountRate(customerDiscountRate);
        salesOrder.setCustomerExtraDiscount(customerExtraDiscount);

        return salesOrderRepository.save(salesOrder);
    }

    private SalesOrder updateExistingOrder(JsonNode obj, long ordId, String customerName, String customerNumber,
                                           String customerTelephone, Double subtotal, Double discount,
                                           Double tax, Double grandTotal, Double payments,
                                           Double customerDiscountRate, Double customerExtraDiscount, Boolean inProgress) {
        SalesOrder salesOrder = null;
        try {
            salesOrder = salesOrderRepository.findById(ordId)
                    .orElseThrow(() -> new Exception("Sales order not found"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        salesOrder.setMainContact(customerTelephone);
        salesOrder.setCustomerReference(customerNumber);
        salesOrder.setForCustomerOrTable(customerName);
        salesOrder.setInProgressforPOS(inProgress);
        salesOrder.setSubTotal(subtotal);
        salesOrder.setSalesTax(tax);
        salesOrder.setDiscount(discount);
        salesOrder.setGrandTotal(grandTotal);
        salesOrder.setPayments(payments);
        salesOrder.setCustomerDiscountRate(customerDiscountRate);
        salesOrder.setCustomerExtraDiscount(customerExtraDiscount);

        return salesOrderRepository.save(salesOrder);
    }

    private void processPayments(JsonNode paymentList, SalesOrder salesOrder) throws Exception {
        for (JsonNode onePayment : paymentList) {
            int paymentId = onePayment.get("paymentId").asInt();
            String user = onePayment.get("user").asText();
            String paymentDate = onePayment.get("paymentDate").asText();
            Date date = new SimpleDateFormat("dd-MM-yyyy").parse(paymentDate);
            Double amount = onePayment.get("amount").asDouble();

            if (paymentId == 0) {
                SalesOrderPayment payment = new SalesOrderPayment();
                payment.setAmountReceived(amount);
                payment.setTotalPayment(amount);
                payment.setBalance(0.0);
                payment.setPaymentDate(date);
                payment.setUsername(user);
                payment.setSalesOrder(salesOrder);
                payment.setTotalBill(salesOrder.getGrandTotal());

                salesOrderPaymentRepository.save(payment);
            }
        }
    }

    private void processOrderDetails(JsonNode details, SalesOrder salesOrder) throws Exception {
        for (JsonNode oneDetail : details) {
            String productName = oneDetail.get("productName").asText();
            String orderDetailID = oneDetail.get("orderDetailID").asText();
            int productId = oneDetail.get("productId").asInt();
            Double productPrice = oneDetail.get("productPrice").asDouble();
            Double disc = oneDetail.get("discount").asDouble();
            Double tax1 = oneDetail.get("tax").asDouble();
            int quantity = oneDetail.get("quantity").asInt();
            Double total = oneDetail.get("total").asDouble();
            boolean stockAffected = oneDetail.get("stockAffected").asBoolean();

            SalesOrderDetail detail;
            if (orderDetailID.startsWith("id")) {
                // New Item
                detail = new SalesOrderDetail();
                detail.setSalesOrder(salesOrder);
                detail.setInventory(inventoryRepository.findById(Long.valueOf(productId))
                        .orElseThrow(() -> new Exception("Inventory not found")));
                detail.setStockAffected(stockAffected);
                detail.setDescription(productName);
                detail.setUnitPrice(productPrice);
                detail.setQuantity(quantity);
                detail.setTaxes(tax1);
                detail.setDiscount(disc);
                detail.setTotal(total);

                salesOrderDetailRepository.save(detail);
            } else {
                // Existing Item
                long detailId = Long.parseLong(orderDetailID.substring(2)); // Extract ID from "id123"
                detail = salesOrderDetailRepository.findById(detailId)
                        .orElseThrow(() -> new Exception("Sales order detail not found"));
                detail.setUnitPrice(productPrice);
                detail.setDiscount(disc);
                detail.setTaxes(tax1);
                detail.setTotal(total);
                detail.setQuantity(quantity);

                salesOrderDetailRepository.save(detail);
            }
        }
    }

    @Transactional
    public SalesOrderResponse updateSalesOrder(Long orderId, SalesOrder salesOrder) throws Exception {
        // Find the existing order by orderId
        SalesOrder existingOrder = salesOrderRepository
                .findById(orderId)
                .orElseThrow(() -> new Exception("Sales order not found"));

        // Create a response object to hold updated fields
        SalesOrderResponse response = new SalesOrderResponse();

        // Update fields only if they are present in the incoming salesOrder
        if (salesOrder.getPartner() != null) {
            existingOrder.setPartner(salesOrder.getPartner());
            response.setPartner(String.valueOf(salesOrder.getPartner()));
        }
        if (salesOrder.getBillingAddress() != null) {
            existingOrder.setBillingAddress(salesOrder.getBillingAddress());
            response.setBillingAddress(String.valueOf(salesOrder.getBillingAddress()));
        }
        if (salesOrder.getShipToAddress() != null) {
            existingOrder.setShipToAddress(salesOrder.getShipToAddress());
            response.setShipToAddress(String.valueOf(salesOrder.getShipToAddress()));
        }
        if (salesOrder.getAgent() != null) {
            existingOrder.setAgent(salesOrder.getAgent());
            response.setAgent(String.valueOf(salesOrder.getAgent()));
        }
        if (salesOrder.getShippingPolicy() != null) {
            existingOrder.setShippingPolicy(salesOrder.getShippingPolicy());
            response.setShippingPolicy(salesOrder.getShippingPolicy());
        }
        if (salesOrder.getQuotationNumber() != null) {
            existingOrder.setQuotationNumber(salesOrder.getQuotationNumber());
            response.setQuotationNumber(salesOrder.getQuotationNumber());
        }
        if (salesOrder.getQuotationDate() != null) {
            existingOrder.setQuotationDate(salesOrder.getQuotationDate());
            response.setQuotationDate(String.valueOf(salesOrder.getQuotationDate()));
        }
        if (salesOrder.getRequestedDate() != null) {
            existingOrder.setRequestedDate(salesOrder.getRequestedDate());
            response.setRequestedDate(String.valueOf(salesOrder.getRequestedDate()));
        }
        if (salesOrder.getShipToDate() != null) {
            existingOrder.setShipToDate(salesOrder.getShipToDate());
            response.setShipToDate(String.valueOf(salesOrder.getShipToDate()));
        }
        if (salesOrder.getSalesPerson() != null) {
            existingOrder.setSalesPerson(salesOrder.getSalesPerson());
            response.setSalesPerson(String.valueOf(salesOrder.getSalesPerson()));
        }
        if (salesOrder.getCreator() != null) {
            existingOrder.setCreator(salesOrder.getCreator());
            response.setCreator(String.valueOf(salesOrder.getCreator()));
        }
        if (salesOrder.getSalesChannels() != null) {
            existingOrder.setSalesChannels(salesOrder.getSalesChannels());
            response.setSalesChannels(salesOrder.getSalesChannels());
        }
        if (salesOrder.getCustomerReference() != null) {
            existingOrder.setCustomerReference(salesOrder.getCustomerReference());
            response.setCustomerReference(salesOrder.getCustomerReference());
        }
        if (salesOrder.getPayments() != null) {
            existingOrder.setPayments(salesOrder.getPayments());
            response.setPayments(String.valueOf(salesOrder.getPayments()));
        }
        if (salesOrder.getCashPaid() != null) {
            existingOrder.setCashPaid(salesOrder.getCashPaid());
            response.setCashPaid(salesOrder.getCashPaid());
        }
        if (salesOrder.getTotalPayment() != null) {
            existingOrder.setTotalPayment(salesOrder.getTotalPayment());
            response.setTotalPayment(salesOrder.getTotalPayment());
        }
        if (salesOrder.getConfirmed() != null) {
            existingOrder.setConfirmed(salesOrder.getConfirmed());
            response.setConfirmed(salesOrder.getConfirmed());
        }
        if (salesOrder.getDiscount() != null) {
            existingOrder.setDiscount(salesOrder.getDiscount());
            response.setDiscount(salesOrder.getDiscount());
        }
        if (salesOrder.getGrandTotal() != null) {
            existingOrder.setGrandTotal(salesOrder.getGrandTotal());
            response.setGrandTotal(salesOrder.getGrandTotal());
        }

        // Save the updated order
        salesOrderRepository.save(existingOrder);

        // Set the ID of the updated order
        response.setId(existingOrder.getId());

        // Return only the fields that were updated
        return response;
    }


    // Utility methods to handle null checks and type conversions
    private String getValueAsString(JsonNode node, String field) {
        return node.has(field) ? node.get(field).asText() : null;
    }

    private String getValueAsString(JsonNode node, String field, String defaultValue) {
        return node.has(field) ? node.get(field).asText() : defaultValue;
    }

    private int getValueAsInt(JsonNode node, String field) {
        return node.has(field) ? node.get(field).asInt() : 0;
    }

    private double getValueAsDouble(JsonNode node, String field) {
        return node.has(field) ? node.get(field).asDouble() : 0.0;
    }

    private double getValueAsDouble(JsonNode node, String field, double defaultValue) {
        return node.has(field) ? node.get(field).asDouble() : defaultValue;
    }

    private boolean getValueAsBoolean(JsonNode node, String field) {
        return node.has(field) && node.get(field).asBoolean();
    }

    private List<OrderDetailDTO> convertToOrderDetailDTO(SalesOrder salesOrder) {
        List<OrderDetailDTO> orderDetails = new ArrayList<>();
        List<SalesOrderDetail> details = salesOrderDetailRepository.findBySalesOrder(salesOrder);

        for (SalesOrderDetail detail : details) {
            OrderDetailDTO dto = new OrderDetailDTO();
            dto.setId(Long.valueOf(detail.getId()));
            dto.setProductName(detail.getDescription());
            dto.setUnitPrice(detail.getUnitPrice());
            dto.setQuantity((double) detail.getQuantity());
            dto.setTotal(detail.getTotal());

            // Additional fields for new format
            dto.setStockAffected(detail.isStockAffected());
            dto.setApplyProductLevelDiscount(true); // Assuming default value
            dto.setDiscountRate(detail.getDiscount());

            orderDetails.add(dto);
        }
        return orderDetails;
    }

    private List<PaymentDTO> convertToPaymentDTO(SalesOrder salesOrder) {
        return new ArrayList<>();
    }

    // Inner DTO classes
    public static class OrderDTO {
        private String customerName;
        private String customerNumber;
        private String customerTelephone;
        private Double subTotal;
        private Double discount;
        private Double tax;
        private Double grandTotal;
        private Double payments;
        private List<ProductDTO> products;
        private List<PaymentDTO> paymentList;

        // Getters and Setters
        public String getCustomerName() { return customerName; }
        public void setCustomerName(String customerName) { this.customerName = customerName; }

        public String getCustomerNumber() { return customerNumber; }
        public void setCustomerNumber(String customerNumber) { this.customerNumber = customerNumber; }

        public String getCustomerTelephone() { return customerTelephone; }
        public void setCustomerTelephone(String customerTelephone) { this.customerTelephone = customerTelephone; }

        public Double getSubTotal() { return subTotal; }
        public void setSubTotal(Double subTotal) { this.subTotal = subTotal; }

        public Double getDiscount() { return discount; }
        public void setDiscount(Double discount) { this.discount = discount; }

        public Double getTax() { return tax; }
        public void setTax(Double tax) { this.tax = tax; }

        public Double getGrandTotal() { return grandTotal; }
        public void setGrandTotal(Double grandTotal) { this.grandTotal = grandTotal; }

        public Double getPayments() { return payments; }
        public void setPayments(Double payments) { this.payments = payments; }

        public List<ProductDTO> getProducts() { return products; }
        public void setProducts(List<ProductDTO> products) { this.products = products; }

        public List<PaymentDTO> getPaymentList() { return paymentList; }
        public void setPaymentList(List<PaymentDTO> paymentList) { this.paymentList = paymentList; }
    }

    // Customer info response DTO
    public class SalesOrderResponse {
        private Long id;
        private String partner;
        private String billingAddress;
        private String shipToAddress;
        private String agent;
        private String shippingPolicy;
        private String quotationNumber;
        private String quotationDate;
        private String requestedDate;
        private String shipToDate;
        private String salesPerson;
        private String creator;
        private String salesChannels;
        private String customerReference;
        private String payments;
        private Double cashPaid;
        private Double totalPayment;
        private Boolean confirmed;
        private Double discount;
        private Double grandTotal;

        // Getters and Setters

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getPartner() {
            return partner;
        }

        public void setPartner(String partner) {
            this.partner = partner;
        }

        public String getBillingAddress() {
            return billingAddress;
        }

        public void setBillingAddress(String billingAddress) {
            this.billingAddress = billingAddress;
        }

        public String getShipToAddress() {
            return shipToAddress;
        }

        public void setShipToAddress(String shipToAddress) {
            this.shipToAddress = shipToAddress;
        }

        public String getAgent() {
            return agent;
        }

        public void setAgent(String agent) {
            this.agent = agent;
        }

        public String getShippingPolicy() {
            return shippingPolicy;
        }

        public void setShippingPolicy(String shippingPolicy) {
            this.shippingPolicy = shippingPolicy;
        }

        public String getQuotationNumber() {
            return quotationNumber;
        }

        public void setQuotationNumber(String quotationNumber) {
            this.quotationNumber = quotationNumber;
        }

        public String getQuotationDate() {
            return quotationDate;
        }

        public void setQuotationDate(String quotationDate) {
            this.quotationDate = quotationDate;
        }

        public String getRequestedDate() {
            return requestedDate;
        }

        public void setRequestedDate(String requestedDate) {
            this.requestedDate = requestedDate;
        }

        public String getShipToDate() {
            return shipToDate;
        }

        public void setShipToDate(String shipToDate) {
            this.shipToDate = shipToDate;
        }

        public String getSalesPerson() {
            return salesPerson;
        }

        public void setSalesPerson(String salesPerson) {
            this.salesPerson = salesPerson;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public String getSalesChannels() {
            return salesChannels;
        }

        public void setSalesChannels(String salesChannels) {
            this.salesChannels = salesChannels;
        }

        public String getCustomerReference() {
            return customerReference;
        }

        public void setCustomerReference(String customerReference) {
            this.customerReference = customerReference;
        }

        public String getPayments() {
            return payments;
        }

        public void setPayments(String payments) {
            this.payments = payments;
        }

        public Double getCashPaid() {
            return cashPaid;
        }

        public void setCashPaid(Double cashPaid) {
            this.cashPaid = cashPaid;
        }

        public Double getTotalPayment() {
            return totalPayment;
        }

        public void setTotalPayment(Double totalPayment) {
            this.totalPayment = totalPayment;
        }

        public Boolean getConfirmed() {
            return confirmed;
        }

        public void setConfirmed(Boolean confirmed) {
            this.confirmed = confirmed;
        }

        public Double getDiscount() {
            return discount;
        }

        public void setDiscount(Double discount) {
            this.discount = discount;
        }

        public Double getGrandTotal() {
            return grandTotal;
        }

        public void setGrandTotal(Double grandTotal) {
            this.grandTotal = grandTotal;
        }
    }


    public static class ProductDTO {
        private String productName;
        private Integer productId;
        private Double productPrice;
        private Integer quantity;
        private Double discount;
        private Double taxes;

        // Getters and Setters
        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }

        public Integer getProductId() { return productId; }
        public void setProductId(Integer productId) { this.productId = productId; }

        public Double getProductPrice() { return productPrice; }
        public void setProductPrice(Double productPrice) { this.productPrice = productPrice; }

        public Integer getQuantity() { return quantity; }
        public void setQuantity(Integer quantity) { this.quantity = quantity; }

        public Double getDiscount() { return discount; }
        public void setDiscount(Double discount) { this.discount = discount; }

        public Double getTaxes() { return taxes; }
        public void setTaxes(Double taxes) { this.taxes = taxes; }
    }

    public static class PaymentDTO {
        private Double amountPaid;
        private String paymentDate;

        // Getters and Setters
        public Double getAmountPaid() { return amountPaid; }
        public void setAmountPaid(Double amountPaid) { this.amountPaid = amountPaid; }

        public String getPaymentDate() { return paymentDate; }
        public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }
    }

    // Inner static DTO classes
    // Updated OrderDetailsResponse class
    public static class OrderDetailsResponse {
        private int status;
        private String message;
        private Long orderId;
        private String orderNumber;
        private String orderUser;
        private String customerName;
        private String customerNumber;
        private String customerTelephone;
        private String orderDate;
        private List<OrderDetailDTO> posOrderHeadDetails;

        // Getters and Setters
        public int getStatus() { return status; }
        public void setStatus(int status) { this.status = status; }

        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }

        public Long getOrderId() { return orderId; }
        public void setOrderId(Long orderId) { this.orderId = orderId; }

        public String getOrderNumber() { return orderNumber; }
        public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }

        public String getOrderUser() { return orderUser; }
        public void setOrderUser(String orderUser) { this.orderUser = orderUser; }

        public String getCustomerName() { return customerName; }
        public void setCustomerName(String customerName) { this.customerName = customerName; }

        public String getCustomerNumber() { return customerNumber; }
        public void setCustomerNumber(String customerNumber) { this.customerNumber = customerNumber; }

        public String getCustomerTelephone() { return customerTelephone; }
        public void setCustomerTelephone(String customerTelephone) { this.customerTelephone = customerTelephone; }

        public String getOrderDate() { return orderDate; }
        public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

        public List<OrderDetailDTO> getPosOrderHeadDetails() { return posOrderHeadDetails; }
        public void setPosOrderHeadDetails(List<OrderDetailDTO> posOrderHeadDetails) { this.posOrderHeadDetails = posOrderHeadDetails; }
    }

    public static class OrderDetailDTO {
        private Long id;
        private String productName;
        private Double unitPrice;
        private Double quantity;
        private Double total;
        private boolean stockAffected;
        private boolean applyProductLevelDiscount;
        private Double discountRate;
        // Getters and Setters
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }
        public Double getUnitPrice() { return unitPrice; }
        public void setUnitPrice(Double unitPrice) { this.unitPrice = unitPrice; }
        public Double getQuantity() { return quantity; }
        public void setQuantity(Double quantity) { this.quantity = quantity; }
        public Double getTotal() { return total; }
        public void setTotal(Double total) { this.total = total; }
        public boolean isStockAffected() { return stockAffected; }
        public void setStockAffected(boolean stockAffected) { this.stockAffected = stockAffected; }
        public boolean isApplyProductLevelDiscount() { return applyProductLevelDiscount; }
        public void setApplyProductLevelDiscount(boolean applyProductLevelDiscount) { this.applyProductLevelDiscount = applyProductLevelDiscount; }
        public Double getDiscountRate() { return discountRate; }
        public void setDiscountRate(Double discountRate) { this.discountRate = discountRate; }
    }

    // Inner static DTO classes
    public static class PosOrder {
        private Long orderId;
        private  String orderNumber;
        private String createdOn;
        private String userName;

        // Getters and Setters
        public Long getOrderId() { return orderId; }
        public void setOrderId(Long orderId) { this.orderId = orderId; }
        public String getOrderNumber() { return orderNumber; }
        public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
        public String getCreatedOn() { return createdOn; }
        public void setCreatedOn(String createdOn) { this.createdOn = createdOn; }
        public String getUserName() { return userName; }
        public void setUserName(String userName) { this.userName = userName; }
    }

    public static class PosOrders {
        private int status;
        private String message;
        private Long userId;
        private String userName;
        private String companyName;
        private List<PosOrder> posOrders;

        // Getters and Setters
        public int getStatus() { return status; }
        public void setStatus(int status) { this.status = status; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
        public String getUserName() { return userName; }
        public void setUserName(String userName) { this.userName = userName; }
        public String getCompanyName() { return companyName; }
        public void setCompanyName(String companyName) { this.companyName = companyName; }
        public List<PosOrder> getPosOrders() { return posOrders; }
        public void setPosOrders(List<PosOrder> posOrders) { this.posOrders = posOrders; }
    }
}

