package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author evansoppong
 */
@Entity
@Table(name = "ecommerce_category")
public class EcommerceCategory  extends Model{

    private static final long serialVersionUID = 1L;

    private String category;
    private String narration;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }



}

