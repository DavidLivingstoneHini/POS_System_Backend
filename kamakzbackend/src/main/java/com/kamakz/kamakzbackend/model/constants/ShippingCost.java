package com.kamakz.kamakzbackend.model.constants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.kamakz.kamakzbackend.model.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author jboss
 */
@Entity
@Table(name = "shipping_cost")
public class ShippingCost extends Model{

    private static final long serialVersionUID = -1742913691733428595L;

    private String deliveryPoint = "";
    private Double deliveryCost = 0.0;

    public String getDeliveryPoint() {
        return deliveryPoint;
    }

    public void setDeliveryPoint(String deliveryPoint) {
        this.deliveryPoint = deliveryPoint;
    }

    public Double getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(Double deliveryCost) {
        this.deliveryCost = deliveryCost;
    }


}

