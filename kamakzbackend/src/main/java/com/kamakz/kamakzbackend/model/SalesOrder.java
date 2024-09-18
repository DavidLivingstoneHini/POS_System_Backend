package com.kamakz.kamakzbackend.model;

import com.kamakz.kamakzbackend.model.constants.PartnerAddress;
import com.kamakz.kamakzbackend.model.constants.Partner;
import com.kamakz.kamakzbackend.model.User;
import com.kamakz.kamakzbackend.model.Model;
import com.kamakz.kamakzbackend.model.constants.Company;
import java.util.Date;

import com.kamakz.kamakzbackend.model.constants.Shop;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;

/**
 *
 * @author jboss
 */
@Entity
@Table(name = "sales_order")
public class SalesOrder extends Model {

    private static final long serialVersionUID = 4962334209166665474L;

    @ManyToOne(optional=true)
    private Partner partner;
    @ManyToOne(optional=true)
    private PartnerAddress billingAddress;
    @ManyToOne(optional=true)
    private PartnerAddress shipToAddress;
    @ManyToOne(optional=true)
    private Shop shop;
    @ManyToOne
    private Company company;
    @ManyToOne(optional = true)
    private Partner agent;

    private String shippingPolicy;
    private String quotationNumber;
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date quotationDate = new Date();
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date requestedDate = new Date();
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date shipToDate;
    @ManyToOne(optional=true)
    private User salesPerson;
    @ManyToOne(optional=true)
    private User creator;
    private String forCustomerOrTable = "Customer Name";
    private String shipVia;
    private String inncoTerm;
    private String deliveryPort;
    private Double subTotal=0.0;
    private Double discount = 0.0;
    private Double salesTax=0.0;
    private Double shippingHandling = 0.0;
    private Double grandTotal = 0.0;
    private Double payments = 0.0;
    private Double cashPaid = 0.0;
    private String buyerOrderReference;
    private String salesChannels = "Sales"; //it can be Sales/POS/eCommerce/Rentals/Subscription
    private String customerReference;
    private String salesReference;
    private String status = "New";
    private String retrieveCode;
    private String headerNote = "SALES ORDER";
    @Column(columnDefinition = "TEXT")
    private String termsAndCondition;
    @Column(columnDefinition = "TEXT")
    private String paymentTerms;
    @Column(columnDefinition = "TEXT")
    private String specialInstructions;
    private boolean completed = false;
    private String activities = "";
    private String prepearedBy;
    private String approvedBy;
    private String mainContact;
    private Double totalPayment = 0.0;
    private Boolean confirmed = false;
    private Integer invoiceId = 0;
    private Integer subscriptionId = 0;
    private Double unreturnItemsCost = 0.0;
    private Boolean inProgressforPOS = false;

    private Double customerExtraDiscount = 0.0;
    private Double customerDiscountRate = 0.0;

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Double getUnreturnItemsCost() {
        return unreturnItemsCost;
    }

    public void setUnreturnItemsCost(Double unreturnItemsCost) {
        this.unreturnItemsCost = unreturnItemsCost;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public PartnerAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(PartnerAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public PartnerAddress getShipToAddress() {
        return shipToAddress;
    }

    public void setShipToAddress(PartnerAddress shipToAddress) {
        this.shipToAddress = shipToAddress;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }


    public String getQuotationNumber() {
        return quotationNumber;
    }

    public void setQuotationNumber(String quotationNumber) {
        this.quotationNumber = quotationNumber;
    }

    public Date getQuotationDate() {
        return quotationDate;
    }

    public void setQuotationDate(Date quotationDate) {
        this.quotationDate = quotationDate;
    }

    public String getShippingPolicy() {
        return shippingPolicy;
    }

    public void setShippingPolicy(String shippingPolicy) {
        this.shippingPolicy = shippingPolicy;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public Date getShipToDate() {
        return shipToDate;
    }

    public void setShipToDate(Date shipToDate) {
        this.shipToDate = shipToDate;
    }

    public User getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(User salesPerson) {
        this.salesPerson = salesPerson;
    }

    public String getSalesReference() {
        return salesReference;
    }

    public void setSalesReference(String salesReference) {
        this.salesReference = salesReference;
    }

    public String getRetrieveCode() {
        return retrieveCode;
    }

    public void setRetrieveCode(String retrieveCode) {
        this.retrieveCode = retrieveCode;
    }


    public String getShipVia() {
        return shipVia;
    }

    public void setShipVia(String shipVia) {
        this.shipVia = shipVia;
    }

    public String getInncoTerm() {
        return inncoTerm;
    }

    public void setInncoTerm(String inncoTerm) {
        this.inncoTerm = inncoTerm;
    }


    public String getDeliveryPort() {
        return deliveryPort;
    }

    public void setDeliveryPort(String deliveryPort) {
        this.deliveryPort = deliveryPort;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(Double salesTax) {
        this.salesTax = salesTax;
    }

    public Double getShippingHandling() {
        return shippingHandling;
    }

    public void setShippingHandling(Double shippingHandling) {
        this.shippingHandling = shippingHandling;
    }

    public Double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(Double grandTotal) {
        this.grandTotal = grandTotal;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getPayments() {
        return payments;
    }

    public void setPayments(Double payments) {
        this.payments = payments;
    }

    public Double getCashPaid() {
        return cashPaid;
    }

    public void setCashPaid(Double cashPaid) {
        this.cashPaid = cashPaid;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getForCustomerOrTable() {
        return forCustomerOrTable;
    }

    public void setForCustomerOrTable(String forCustomerOrTable) {
        this.forCustomerOrTable = forCustomerOrTable;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Partner getAgent() {
        return agent;
    }

    public void setAgent(Partner agent) {
        this.agent = agent;
    }

    public String getHeaderNote() {
        return headerNote;
    }

    public void setHeaderNote(String headerNote) {
        this.headerNote = headerNote;
    }

    public String getTermsAndCondition() {
        return termsAndCondition;
    }

    public void setTermsAndCondition(String termsAndCondition) {
        this.termsAndCondition = termsAndCondition;
    }

    public String getSpecialInstructions() {
        return specialInstructions;
    }

    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getPrepearedBy() {
        return prepearedBy;
    }

    public void setPrepearedBy(String prepearedBy) {
        this.prepearedBy = prepearedBy;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getMainContact() {
        return mainContact;
    }

    public void setMainContact(String mainContact) {
        this.mainContact = mainContact;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public String getBuyerOrderReference() {
        return buyerOrderReference;
    }

    public void setBuyerOrderReference(String buyerOrderReference) {
        this.buyerOrderReference = buyerOrderReference;
    }

    public Integer getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Integer subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Boolean getInProgressforPOS() {
        return inProgressforPOS;
    }

    public void setInProgressforPOS(Boolean inProgressforPOS) {
        this.inProgressforPOS = inProgressforPOS;
    }

    public Double getCustomerExtraDiscount() {
        return customerExtraDiscount;
    }

    public void setCustomerExtraDiscount(Double customerExtraDiscount) {
        this.customerExtraDiscount = customerExtraDiscount;
    }

    public Double getCustomerDiscountRate() {
        return customerDiscountRate;
    }

    public void setCustomerDiscountRate(Double customerDiscountRate) {
        this.customerDiscountRate = customerDiscountRate;
    }


    public String getOrderNumber() {
        return orderNumber();
    }

    private String orderNumber() {
        return "";
    }
}

