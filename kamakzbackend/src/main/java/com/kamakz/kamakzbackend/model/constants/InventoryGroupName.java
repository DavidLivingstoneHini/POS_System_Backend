package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.Model;
import com.kamakz.kamakzbackend.model.constants.Company;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author jboss
 */
@Entity
@Table(name = "inventory_group_name")
public class InventoryGroupName extends Model{

    private static final long serialVersionUID = -3351132415918948956L;

    String firstGroupName = "First Group";
    String secondGroupName = "Second Group";
    String thirdGroupName = "Third Group";
    String forthGroupName = "Fourth Group";
    String fifthGroupName = "Fifth Group";

    Integer company_id = 0;

    private String retrievalCode;

    public Integer getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Integer company_id) {
        this.company_id = company_id;
    }

    public String getFirstGroupName() {
        return firstGroupName;
    }

    public void setFirstGroupName(String firstGroupName) {
        this.firstGroupName = firstGroupName;
    }

    public String getSecondGroupName() {
        return secondGroupName;
    }

    public void setSecondGroupName(String secondGroupName) {
        this.secondGroupName = secondGroupName;
    }

    public String getThirdGroupName() {
        return thirdGroupName;
    }

    public void setThirdGroupName(String thirdGroupName) {
        this.thirdGroupName = thirdGroupName;
    }

    public String getForthGroupName() {
        return forthGroupName;
    }

    public void setForthGroupName(String forthGroupName) {
        this.forthGroupName = forthGroupName;
    }

    public String getFifthGroupName() {
        return fifthGroupName;
    }

    public void setFifthGroupName(String fifthGroupName) {
        this.fifthGroupName = fifthGroupName;
    }

    public String getRetrievalCode() {
        return retrievalCode;
    }

    public void setRetrievalCode(String retrievalCode) {
        this.retrievalCode = retrievalCode;
    }




}
