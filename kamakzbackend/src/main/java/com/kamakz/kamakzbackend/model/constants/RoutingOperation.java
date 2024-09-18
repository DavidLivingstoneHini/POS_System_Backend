package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.Model;
import com.kamakz.kamakzbackend.model.constants.CompanyEmployee;
import com.kamakz.kamakzbackend.model.constants.UnitOfMeasure;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;

/**
 *
 * @author jboss
 */
@Entity
@Table(name = "routingoperation")
public class RoutingOperation extends Model{

    private static final long serialVersionUID = -8346115797216139808L;

    @ManyToOne
    private RoutingManufacturing routingManufacturing;
    @ManyToOne
    private WorkCentre workCentre;
    private String operationName;

    private Double expectedQuantity = 0.0;
    @ManyToOne
    private UnitOfMeasure UnitOfMeasure;
    @Column(columnDefinition = "TEXT")
    private String note;
    @Column(columnDefinition = "TEXT")
    private String manHourDescription;
    @ManyToOne (optional = true)
    private CompanyEmployee responsibleStaff;
    @ManyToOne(optional = true)
    private ManufacturingBillOfQuantity manufacturingBillOfQuantity;
    public RoutingManufacturing getRoutingManufacturing() {
        return routingManufacturing;
    }

    public void setRoutingManufacturing(RoutingManufacturing routingManufacturing) {
        this.routingManufacturing = routingManufacturing;
    }

    public WorkCentre getWorkCentre() {
        return workCentre;
    }

    public void setWorkCentre(WorkCentre workCentre) {
        this.workCentre = workCentre;
    }

    public Double getExpectedQuantity() {
        return expectedQuantity;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public void setExpectedQuantity(Double expectedQuantity) {
        this.expectedQuantity = expectedQuantity;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return UnitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure UnitOfMeasure) {
        this.UnitOfMeasure = UnitOfMeasure;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getManHourDescription() {
        return manHourDescription;
    }

    public void setManHourDescription(String manHourDescription) {
        this.manHourDescription = manHourDescription;
    }

    public CompanyEmployee getResponsibleStaff() {
        return responsibleStaff;
    }

    public void setResponsibleStaff(CompanyEmployee responsibleStaff) {
        this.responsibleStaff = responsibleStaff;
    }

    public ManufacturingBillOfQuantity getManufacturingBillOfQuantity() {
        return manufacturingBillOfQuantity;
    }

    public void setManufacturingBillOfQuantity(ManufacturingBillOfQuantity manufacturingBillOfQuantity) {
        this.manufacturingBillOfQuantity = manufacturingBillOfQuantity;
    }



}

