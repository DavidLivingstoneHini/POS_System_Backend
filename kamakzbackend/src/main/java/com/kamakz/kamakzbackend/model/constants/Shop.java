package com.kamakz.kamakzbackend.model.constants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.kamakz.kamakzbackend.model.Model;
import com.kamakz.kamakzbackend.model.constants.CompanyEmployee;
import com.kamakz.kamakzbackend.model.constants.Warehouse;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author jboss
 */
@Entity
@Table(name = "shop")
public class Shop extends Model {

    private static final long serialVersionUID = -7997047056901607497L;

    @ManyToOne
    private Warehouse warehouse;
    private String shopName;
    private String location;

    @ManyToOne(optional = true)
    private CompanyEmployee manager;
    private String Telephone;
    private String retrievalCode;
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public CompanyEmployee getManager() {
        return manager;
    }

    public void setManager(CompanyEmployee manager) {
        this.manager = manager;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public String getRetrievalCode() {
        return retrievalCode;
    }

    public void setRetrievalCode(String retrievalCode) {
        this.retrievalCode = retrievalCode;
    }


}

