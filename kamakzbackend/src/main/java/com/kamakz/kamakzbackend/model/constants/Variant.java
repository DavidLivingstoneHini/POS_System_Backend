package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.Inventory;
import com.kamakz.kamakzbackend.model.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author jboss
 */
@Entity
@Table(name = "variant")
public class Variant extends Model {

    private static final long serialVersionUID = -6944722704559751738L;
    @ManyToOne
    private Inventory inventory;
    private String variantName;
    private Boolean affectCost = false; // if this is true the user must enter variantPrice.
    private Double variantPrice=0.0;

    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public Boolean getAffectCost() {
        return affectCost;
    }

    public void setAffectCost(Boolean affectCost) {
        this.affectCost = affectCost;
    }

    public Double getVariantPrice() {
        return variantPrice;
    }

    public void setVariantPrice(Double variantPrice) {
        this.variantPrice = variantPrice;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


}

