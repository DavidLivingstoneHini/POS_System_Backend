package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.constants.UnitOfTime;
import com.kamakz.kamakzbackend.model.Model;
import com.kamakz.kamakzbackend.model.constants.Company;
import com.kamakz.kamakzbackend.model.constants.Partner;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author jboss
 */
@Entity
@Table(name = "work_centre")
public class WorkCentre extends Model{

    private static final long serialVersionUID = 7263438836445916813L;

    private String description;
    private String location;
    private String note1;
    private String note2;
    private UnitOfTime unitOfTime = UnitOfTime.NONE;
    private Double costPerTimeUnit = 0.0;

    @ManyToOne(optional=true)
    private Partner supplier;// this will apply if the centre is for a third party
    private String servicePartner;
    private String servicePartnerTelephone;

    @ManyToOne(optional = true)
    Company company;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNote1() {
        return note1;
    }

    public void setNote1(String note1) {
        this.note1 = note1;
    }

    public String getNote2() {
        return note2;
    }

    public void setNote2(String note2) {
        this.note2 = note2;
    }

    public UnitOfTime getUnitOfTime() {
        return unitOfTime;
    }

    public void setUnitOfTime(UnitOfTime unitOfTime) {
        this.unitOfTime = unitOfTime;
    }

    public Double getCostPerTimeUnit() {
        return costPerTimeUnit;
    }

    public void setCostPerTimeUnit(Double costPerTimeUnit) {
        this.costPerTimeUnit = costPerTimeUnit;
    }

    public Partner getSupplier() {
        return supplier;
    }

    public void setSupplier(Partner supplier) {
        this.supplier = supplier;
    }

    public String getServicePartner() {
        return servicePartner;
    }

    public void setServicePartner(String servicePartner) {
        this.servicePartner = servicePartner;
    }

    public String getServicePartnerTelephone() {
        return servicePartnerTelephone;
    }

    public void setServicePartnerTelephone(String servicePartnerTelephone) {
        this.servicePartnerTelephone = servicePartnerTelephone;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


}

