package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.Model;
import com.kamakz.kamakzbackend.model.constants.Company;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Jboss
 */
@Entity
@Table(name = "job_grade")
public class JobGrade extends Model {

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToOne(optional=true)
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public JobGrade() {
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

}

