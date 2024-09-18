package com.kamakz.kamakzbackend.model;

import com.kamakz.kamakzbackend.model.constants.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author jboss
 */
@Entity
@Table(name = "inventory")
public class Inventory extends Model {

    private static final long serialVersionUID = -4723629256243459072L;

    private String productName;
    @ManyToOne
    private Company company;
    private String inventoryType;//Consumable, Nonstorable, Storable
    @ManyToOne
    private InventoryCategory category;//Product, Service, Repair, Project, Subscription, etc
    private Boolean disPlayAsProductPart = false; //if the product is consumable do we want to dispalay on POS and eCommerse as part of the Product?

    private Boolean canBeSold=false;
    private Boolean canBePurchased=false;
    private Boolean canBeExpensed=false;
    private Boolean canBeRented=false;
    private Boolean manufactured=false;
    private Boolean manufactureOnOrder=false;
    private Boolean buy=false;
    private Boolean replinishOnOrder=false;// if true then we dont stock it we order when there is a need for it
    private String internalReference="";
    private String barCode="";
    private Double cost = 0.0;
    private Double sellingPriceOriginal = 0.0;
    private Double discount = 0.0;
    private Double sellingPriceActual = 0.0;
    @Column(columnDefinition = "TEXT")
    private String salesDescription;
    @Column(columnDefinition = "TEXT")
    private String purchaseDescription;
    @Column(columnDefinition = "TEXT")
    private String features;
    @Column(columnDefinition = "TEXT")
    private String manufacturingIngrediens;
    private String deliveryOrderDescription;
    private String receiptDescription;
    private String invoicePolicy; // when to invoice After Order or After Delivery.
    private Boolean isItAnEventTicket = false;
    private Boolean isItSubcription = false;
    private Boolean onSale = false;
    private Boolean availableOnEcommerce=false;
    private String availability; //Sell regardless of Inventory or Sell Quantity on Hand only
    private Boolean availableOnPOS;

    private Integer manufacturingLeadTime=0;
    private Integer consumerLeadTime=0;
    private Double weight = 0.0;
    private Double volume = 0.0;
    @ManyToOne
    private UnitOfMeasure unitOfMeasure;

    private String defaultImagePath = "";
    private Integer quantityOnHand = 0;
    private Integer incomingQuantity = 0;
    private Integer manufacturingAllocatedQuantity = 0;
    private Integer quantityAvailable = 0;
    private Integer commitedQuantity = 0;
    private Integer reoderLevel = 0;
    private Integer minimumLevel = 0;
    private Integer maximumLevel = 0;
    private String inventoryTraceability;// this explains whether the inventory should be identied by serial number for group of inventories.
    private String trackingSerialNo;
    @ManyToOne
    private Account incomeAccount;
    @ManyToOne
    private Account expenseAccount;
    @ManyToOne
    private Account priceDifferenceAccount;
    @Column(columnDefinition = "TEXT")
    private String preparationMethod;
    private String retrievalCode;

    //this for Rental Products
    private Double extraHours = 0.0;
    private Double extraDays = 0.0;
    private Double hoursReadyBeforePickup = 0.0;
    private Double unreturnedItemCost = 0.0;

    private Boolean applyProductLevelDiscount = true;
    private Boolean applyCustomerLevelDiscount = true;

    private boolean temporarySuspended = false;

    public Inventory() {
    }

    public Double getUnreturnedItemCost() {
        return unreturnedItemCost;
    }

    public void setUnreturnedItemCost(Double unreturnedItemCost) {
        this.unreturnedItemCost = unreturnedItemCost;
    }

    public Boolean getApplyProductLevelDiscount() {
        return applyProductLevelDiscount;
    }

    public void setApplyProductLevelDiscount(Boolean applyProductLevelDiscount) {
        this.applyProductLevelDiscount = applyProductLevelDiscount;
    }

    public Boolean getApplyCustomerLevelDiscount() {
        return applyCustomerLevelDiscount;
    }

    public void setApplyCustomerLevelDiscount(Boolean applyCustomerLevelDiscount) {
        this.applyCustomerLevelDiscount = applyCustomerLevelDiscount;
    }



    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRetrievalCode() {
        return retrievalCode;
    }

    public void setRetrievalCode(String retrievalCode) {
        this.retrievalCode = retrievalCode;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getInventoryType() {
        return inventoryType;
    }


    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType;
    }

    public String getTrackingSerialNo() {
        return trackingSerialNo;
    }

    public void setTrackingSerialNo(String trackingSerialNo) {
        this.trackingSerialNo = trackingSerialNo;
    }

    public InventoryCategory getCategory() {
        return category;
    }

    public void setCategory(InventoryCategory category) {
        this.category = category;
    }


    public Boolean getDisPlayAsProductPart() {
        return disPlayAsProductPart;
    }

    public void setDisPlayAsProductPart(Boolean disPlayAsProductPart) {
        this.disPlayAsProductPart = disPlayAsProductPart;
    }

    public Boolean getCanBeSold() {
        return canBeSold;
    }

    public void setCanBeSold(Boolean canBeSold) {
        this.canBeSold = canBeSold;
    }

    public Boolean getCanBePurchased() {
        return canBePurchased;
    }

    public void setCanBePurchased(Boolean canBePurchased) {
        this.canBePurchased = canBePurchased;
    }

    public Boolean getCanBeExpensed() {
        return canBeExpensed;
    }

    public void setCanBeExpensed(Boolean canBeExpensed) {
        this.canBeExpensed = canBeExpensed;
    }

    public Boolean getCanBeRented() {
        return canBeRented;
    }

    public void setCanBeRented(Boolean canBeRented) {
        this.canBeRented = canBeRented;
    }

    public Boolean getManufactured() {
        return manufactured;
    }

    public void setManufactured(Boolean manufactured) {
        this.manufactured = manufactured;
    }

    public Boolean getBuy() {
        return buy;
    }

    public void setBuy(Boolean buy) {
        this.buy = buy;
    }

    public Boolean getReplinishOnOrder() {
        return replinishOnOrder;
    }

    public void setReplinishOnOrder(Boolean replinishOnOrder) {
        this.replinishOnOrder = replinishOnOrder;
    }

    public String getInternalReference() {
        return internalReference;
    }

    public void setInternalReference(String internalReference) {
        this.internalReference = internalReference;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getSellingPriceOriginal() {
        return sellingPriceOriginal;
    }

    public void setSellingPriceOriginal(Double sellingPriceOriginal) {
        this.sellingPriceOriginal = sellingPriceOriginal;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getSellingPriceActual() {
        return sellingPriceActual;
    }

    public void setSellingPriceActual(Double sellingPriceActual) {
        this.sellingPriceActual = sellingPriceActual;
    }

    public String getSalesDescription() {
        return salesDescription;
    }

    public void setSalesDescription(String salesDescription) {
        this.salesDescription = salesDescription;
    }

    public String getPurchaseDescription() {
        return purchaseDescription;
    }

    public void setPurchaseDescription(String purchaseDescription) {
        this.purchaseDescription = purchaseDescription;
    }

    public String getDeliveryOrderDescription() {
        return deliveryOrderDescription;
    }

    public void setDeliveryOrderDescription(String deliveryOrderDescription) {
        this.deliveryOrderDescription = deliveryOrderDescription;
    }

    public String getReceiptDescription() {
        return receiptDescription;
    }

    public void setReceiptDescription(String receiptDescription) {
        this.receiptDescription = receiptDescription;
    }

    public String getInvoicePolicy() {
        return invoicePolicy;
    }

    public void setInvoicePolicy(String invoicePolicy) {
        this.invoicePolicy = invoicePolicy;
    }

    public Boolean getIsItAnEventTicket() {
        return isItAnEventTicket;
    }

    public void setIsItAnEventTicket(Boolean isItAnEventTicket) {
        this.isItAnEventTicket = isItAnEventTicket;
    }

    public Boolean getIsItSubcription() {
        return isItSubcription;
    }

    public void setIsItSubcription(Boolean isItSubcription) {
        this.isItSubcription = isItSubcription;
    }

    public Boolean getAvailableOnEcommerce() {
        return availableOnEcommerce;
    }

    public void setAvailableOnEcommerce(Boolean availableOnEcommerce) {
        this.availableOnEcommerce = availableOnEcommerce;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public Boolean getAvailableOnPOS() {
        return availableOnPOS;
    }

    public void setAvailableOnPOS(Boolean availableOnPOS) {
        this.availableOnPOS = availableOnPOS;
    }

    public Integer getManufacturingLeadTime() {
        return manufacturingLeadTime;
    }

    public void setManufacturingLeadTime(Integer manufacturingLeadTime) {
        this.manufacturingLeadTime = manufacturingLeadTime;
    }

    public Integer getConsumerLeadTime() {
        return consumerLeadTime;
    }

    public void setConsumerLeadTime(Integer consumerLeadTime) {
        this.consumerLeadTime = consumerLeadTime;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }




    public Account getIncomeAccount() {
        return incomeAccount;
    }

    public void setIncomeAccount(Account incomeAccount) {
        this.incomeAccount = incomeAccount;
    }

    public Account getExpenseAccount() {
        return expenseAccount;
    }

    public void setExpenseAccount(Account expenseAccount) {
        this.expenseAccount = expenseAccount;
    }

    public Account getPriceDifferenceAccount() {
        return priceDifferenceAccount;
    }

    public void setPriceDifferenceAccount(Account priceDifferenceAccount) {
        this.priceDifferenceAccount = priceDifferenceAccount;
    }

    public String getManufacturingIngrediens() {
        return manufacturingIngrediens;
    }

    public void setManufacturingIngrediens(String manufacturingIngrediens) {
        this.manufacturingIngrediens = manufacturingIngrediens;
    }


    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }


    public String getInventoryTraceability() {
        return inventoryTraceability;
    }

    public void setInventoryTraceability(String inventoryTraceability) {
        this.inventoryTraceability = inventoryTraceability;
    }

    public Integer getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(Integer quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public Integer getIncomingQuantity() {
        return incomingQuantity;
    }

    public void setIncomingQuantity(Integer incomingQuantity) {
        this.incomingQuantity = incomingQuantity;
    }

    public Integer getManufacturingAllocatedQuantity() {
        return manufacturingAllocatedQuantity;
    }

    public void setManufacturingAllocatedQuantity(Integer manufacturingAllocatedQuantity) {
        this.manufacturingAllocatedQuantity = manufacturingAllocatedQuantity;
    }

    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    public Integer getReoderLevel() {
        return reoderLevel;
    }

    public void setReoderLevel(Integer reoderLevel) {
        this.reoderLevel = reoderLevel;
    }

    public Integer getMinimumLevel() {
        return minimumLevel;
    }

    public void setMinimumLevel(Integer minimumLevel) {
        this.minimumLevel = minimumLevel;
    }

    public Integer getMaximumLevel() {
        return maximumLevel;
    }

    public void setMaximumLevel(Integer maximumLevel) {
        this.maximumLevel = maximumLevel;
    }

    public Boolean getManufactureOnOrder() {
        return manufactureOnOrder;
    }

    public void setManufactureOnOrder(Boolean manufactureOnOrder) {
        this.manufactureOnOrder = manufactureOnOrder;
    }



    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public String getDefaultImagePath() {
        return defaultImagePath;
    }

    public void setDefaultImagePath(String defaultImagePath) {
        this.defaultImagePath = defaultImagePath;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public String getPreparationMethod() {
        return preparationMethod;
    }

    public void setPreparationMethod(String preparationMethod) {
        this.preparationMethod = preparationMethod;
    }

    public boolean isTemporarySuspended() {
        return temporarySuspended;
    }

    public void setTemporarySuspended(boolean temporarySuspended) {
        this.temporarySuspended = temporarySuspended;
    }

    public Integer getCommitedQuantity() {
        return commitedQuantity;
    }

    public void setCommitedQuantity(Integer commitedQuantity) {
        this.commitedQuantity = commitedQuantity;
    }

    public Double getExtraHours() {
        return extraHours;
    }

    public void setExtraHours(Double extraHours) {
        this.extraHours = extraHours;
    }

    public Double getExtraDays() {
        return extraDays;
    }

    public void setExtraDays(Double extraDays) {
        this.extraDays = extraDays;
    }

    public Double getHoursReadyBeforePickup() {
        return hoursReadyBeforePickup;
    }

    public void setHoursReadyBeforePickup(Double hoursReadyBeforePickup) {
        this.hoursReadyBeforePickup = hoursReadyBeforePickup;
    }



}
