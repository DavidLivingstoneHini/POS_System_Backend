package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Jboss
 */
@Entity
@Table(name = "district")
@NamedQueries({
        @NamedQuery(name = District.FIND_BY_REGION, query = "Select d from District d where d.region = :region"),
        @NamedQuery(name = District.FIND_DISTRICT_BY_NAME, query = "Select d from District d where d.name=:name")
})
public class District extends Model {

    public static final String FIND_BY_REGION = "District.FIND_BY_REGION";
    public static final String FIND_DISTRICT_BY_NAME = "District.FIND_DISTRICT_BY_NAME";

    @ManyToOne
    private Region region;

    @NotNull(message = "District Name cannot be null")
    @Column(unique = true)
    private String name;

    public District() {
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

