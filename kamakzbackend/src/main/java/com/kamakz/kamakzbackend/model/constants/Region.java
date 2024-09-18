package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Jboss
 */
@Entity
@Table(name = "region")
@NamedQueries({
        @NamedQuery(name = Region.FIND_BY_NAME, query = "Select r from Region r where r.name=:name")
})
public class Region extends Model {

    public static final String FIND_BY_NAME = "Region.FIND_BY_NAME";

    @NotNull(message = "Region Name cannot be null")
    @Column(unique = true)
    private String name;

    public Region() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

