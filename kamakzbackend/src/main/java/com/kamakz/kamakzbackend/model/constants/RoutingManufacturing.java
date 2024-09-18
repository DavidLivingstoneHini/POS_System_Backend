package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.Model;
import com.kamakz.kamakzbackend.model.constants.Company;
import com.kamakz.kamakzbackend.model.Inventory;
import com.kamakz.kamakzbackend.model.constants.Variant;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author jboss
 */
@Entity
@Table(name = "routingmanufacturing")
public class RoutingManufacturing extends Model {

    private static final long serialVersionUID = -8872145485898818187L;

    private String routingName;
    private String description;
    @ManyToOne
    private Inventory product;
    @ManyToOne(optional=true)
    private Variant variant;
    @ManyToOne(optional=true)
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }



    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public Inventory getProduct() {
        return product;
    }

    public void setProduct(Inventory product) {
        this.product = product;
    }


    public String getRoutingName() {
        return routingName;
    }

    public void setRoutingName(String routingName) {
        this.routingName = routingName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}

