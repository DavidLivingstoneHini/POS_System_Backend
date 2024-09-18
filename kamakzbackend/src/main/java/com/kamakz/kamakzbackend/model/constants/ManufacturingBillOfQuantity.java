package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.Model;
import com.kamakz.kamakzbackend.model.constants.Company;
import com.kamakz.kamakzbackend.model.Inventory;
import jakarta.faces.context.FacesContext;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author jboss
 */
@Entity
@Table(name = "manufacturing_bill_of_quantity")
public class ManufacturingBillOfQuantity extends Model{

    private static final long serialVersionUID = -5560478160562268007L;


    private String productName;

    private String description;

    @ManyToOne(optional=true)
    private RoutingManufacturing RoutingManufacturing;

    @ManyToOne(optional=true)
    private RoutingOperation routingOperation;
    @ManyToOne(optional = true)
    Company company;
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }





    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoutingManufacturing getRoutingManufacturing() {
        return RoutingManufacturing;
    }

    public void setRoutingManufacturing(RoutingManufacturing RoutingManufacturing) {
        this.RoutingManufacturing = RoutingManufacturing;
    }

    public RoutingOperation getRoutingOperation() {
        return routingOperation;
    }

    public void setRoutingOperation(RoutingOperation routingOperation) {
        this.routingOperation = routingOperation;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }



}

