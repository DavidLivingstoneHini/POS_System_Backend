package com.kamakz.kamakzbackend.model;

import com.kamakz.kamakzbackend.model.Model;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;

@Entity
@Table(name = "sales_order_payment")
public class SalesOrderPayment extends Model {

    private static final long serialVersionUID = 2531676248899323431L;

    @ManyToOne
    private SalesOrder salesOrder;
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date paymentDate = new Date();
    private Double totalBill = 0.0;
    private Double totalPayment = 0.0;
    private Double balance = 0.0;
    private Double cashPayment = 0.0;
    private Double mobileMoneyPayment = 0.0;
    private Double cardPayment = 0.0;
    private Double chequePayment = 0.0;
    private Double cashChange = 0.0;
    private Double amountReceived = 0.0;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(Double totalBill) {
        this.totalBill = totalBill;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(Double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public Double getCashPayment() {
        return cashPayment;
    }

    public void setCashPayment(Double cashPayment) {
        this.cashPayment = cashPayment;
    }

    public Double getMobileMoneyPayment() {
        return mobileMoneyPayment;
    }

    public void setMobileMoneyPayment(Double mobileMoneyPayment) {
        this.mobileMoneyPayment = mobileMoneyPayment;
    }

    public Double getCardPayment() {
        return cardPayment;
    }

    public void setCardPayment(Double cardPayment) {
        this.cardPayment = cardPayment;
    }

    public Double getChequePayment() {
        return chequePayment;
    }

    public void setChequePayment(Double chequePayment) {
        this.chequePayment = chequePayment;
    }

    public Double getCashChange() {
        return cashChange;
    }

    public void setCashChange(Double cashChange) {
        this.cashChange = cashChange;
    }



    public Double getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(Double amountReceived) {
        this.amountReceived = amountReceived;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }


}

