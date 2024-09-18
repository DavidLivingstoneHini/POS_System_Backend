package com.kamakz.kamakzbackend.model.constants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.kamakz.kamakzbackend.model.Model;
import com.kamakz.kamakzbackend.model.constants.ShippingCost;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author jboss
 */
@Entity
@Table(name = "partner_address")
public class PartnerAddress extends Model{

    private static final long serialVersionUID = 6017596366195105057L;

    @ManyToOne
    private Partner partner;
    private String address1;
    private String address2;
    private String city;
    private String country;
    private String contactPerson;
    private String telephone;
    @ManyToOne(optional=true)
    private ShippingCost shippingCost;
    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public ShippingCost getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(ShippingCost shippingCost) {
        this.shippingCost = shippingCost;
    }


}

