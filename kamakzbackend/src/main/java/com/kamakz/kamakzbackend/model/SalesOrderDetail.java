package com.kamakz.kamakzbackend.model;

import com.kamakz.kamakzbackend.model.Model;
import com.kamakz.kamakzbackend.model.Inventory;
import com.kamakz.kamakzbackend.model.constants.UnitOfMeasure;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;


@Entity
@Table(name = "sales_order_detail")
public class SalesOrderDetail extends Model {

    private static final long serialVersionUID = 8351696882888231838L;


    @ManyToOne
    private SalesOrder salesOrder;
    @ManyToOne
    private Inventory inventory;
    private String description;
    private Integer quantity = 0;
    private Integer quantityBilled = 0;
    private Integer quantityReceived = 0;
    private Double discount = 0.0;
    private Double unitPrice = 0.0;
    private Double taxes = 0.0;
    @ManyToOne(optional = true)
    private UnitOfMeasure unitOfMeasure;
    private Double total = 0.0;
    private boolean stockAffected = false;
    private String username;

    //these additional fields are needed for Rental Business
    private Integer quantityPicked = 0;
    private Integer quantityReturned = 0;
    private Double unreturnItemsPrice = 0.0;
    private Integer duration = 0;
    private String durationUnits = "";

    @Temporal(jakarta.persistence.TemporalType.TIMESTAMP)
    private Date fromDate= new Date();

    @Temporal(jakarta.persistence.TemporalType.TIMESTAMP)
    private Date toDate=new Date();

    @Temporal(jakarta.persistence.TemporalType.TIMESTAMP)
    private Date returnedDate;

    private Double lateReturnCost = 0.0;

    public Double getLateReturnCost() {
        return lateReturnCost;
    }

    public void setLateReturnCost(Double lateReturnCost) {
        this.lateReturnCost = lateReturnCost;
    }

    public Date getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(Date returnedDate) {
        this.returnedDate = returnedDate;
    }


    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantityBilled() {
        return quantityBilled;
    }

    public void setQuantityBilled(Integer quantityBilled) {
        this.quantityBilled = quantityBilled;
    }

    public Integer getQuantityReceived() {
        return quantityReceived;
    }

    public void setQuantityReceived(Integer quantityReceived) {
        this.quantityReceived = quantityReceived;
    }



    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getTaxes() {
        return taxes;
    }

    public void setTaxes(Double taxes) {
        this.taxes = taxes;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public boolean isStockAffected() {
        return stockAffected;
    }

    public void setStockAffected(boolean stockAffected) {
        this.stockAffected = stockAffected;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getQuantityPicked() {
        return quantityPicked;
    }

    public void setQuantityPicked(Integer quantityPicked) {
        this.quantityPicked = quantityPicked;
    }

    public Integer getQuantityReturned() {
        return quantityReturned;
    }

    public void setQuantityReturned(Integer quantityReturned) {
        this.quantityReturned = quantityReturned;
    }

    public Double getUnreturnItemsPrice() {
        return unreturnItemsPrice;
    }

    public void setUnreturnItemsPrice(Double unreturnItemsPrice) {
        this.unreturnItemsPrice = unreturnItemsPrice;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDurationUnits() {
        return durationUnits;
    }

    public void setDurationUnits(String durationUnits) {
        this.durationUnits = durationUnits;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }



}

