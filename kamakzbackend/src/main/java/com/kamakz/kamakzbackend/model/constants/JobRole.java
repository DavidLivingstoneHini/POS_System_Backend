package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.Model;
import com.kamakz.kamakzbackend.model.constants.Businesssegment;
import com.kamakz.kamakzbackend.model.constants.Company;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

/**
 *
 * @author Jboss
 */
@Entity
@Table(name = "job_role")
@NamedQueries({
        @NamedQuery(name = JobRole.FIND_BY_SEGMENT, query = "Select j from JobRole j where j.businesssegment=:segment")
})
public class JobRole extends Model {

    public static final String FIND_BY_SEGMENT = "JobRole.FIND_BY_SEGMENT";

    @ManyToOne
    private Businesssegment businesssegment;

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String department;
    @ManyToOne(optional=true)
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public JobRole() {
    }

    public Businesssegment getBusinesssegment() {
        return businesssegment;
    }

    public void setBusinesssegment(Businesssegment businesssegment) {
        this.businesssegment = businesssegment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}

