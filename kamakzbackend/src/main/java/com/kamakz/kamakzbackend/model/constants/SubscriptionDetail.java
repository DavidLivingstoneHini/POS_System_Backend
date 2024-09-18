package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author jboss
 */
@Entity
@Table(name = "subscription_detail")
public class SubscriptionDetail extends Model {

    private static final long serialVersionUID = 6185803871601775873L;
    private String subscriptionDescription;
    private String invoicePeriodFrequency; //Daily, Weekily, Monthly, Quaerly, Semi-Annually,Annually
    private String invoiceCreationOption; //Manual, Auto
    private String duration; //Forever , Fixed
    private Integer fixedPeriods; //if duration is fixed how many period does the fixed duration cover? e.g 3 weeks or 12 Months
    @Column(columnDefinition = "TEXT")
    private String termsAndConditions;

    public String getSubscriptionDescription() {
        return subscriptionDescription;
    }

    public void setSubscriptionDescription(String subscriptionDescription) {
        this.subscriptionDescription = subscriptionDescription;
    }

    public String getInvoicePeriodFrequency() {
        return invoicePeriodFrequency;
    }

    public void setInvoicePeriodFrequency(String invoicePeriodFrequency) {
        this.invoicePeriodFrequency = invoicePeriodFrequency;
    }

    public String getInvoiceCreationOption() {
        return invoiceCreationOption;
    }

    public void setInvoiceCreationOption(String invoiceCreationOption) {
        this.invoiceCreationOption = invoiceCreationOption;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Integer getFixedPeriods() {
        return fixedPeriods;
    }

    public void setFixedPeriods(Integer fixedPeriods) {
        this.fixedPeriods = fixedPeriods;
    }

    public String getTermsAndConditions() {
        return termsAndConditions;
    }

    public void setTermsAndConditions(String termsAndConditions) {
        this.termsAndConditions = termsAndConditions;
    }


}
