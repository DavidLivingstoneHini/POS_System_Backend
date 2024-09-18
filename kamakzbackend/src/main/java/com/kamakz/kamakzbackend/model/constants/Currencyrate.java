package com.kamakz.kamakzbackend.model.constants;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Evans
 */
@Entity
@Table(name = "currencyrate")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Currencyrate.findAll", query = "SELECT c FROM Currencyrate c"),
        @NamedQuery(name = "Currencyrate.findByRateID", query = "SELECT c FROM Currencyrate c WHERE c.rateID = :rateID"),
        @NamedQuery(name = "Currencyrate.findByBidRate", query = "SELECT c FROM Currencyrate c WHERE c.bidRate = :bidRate"),
        @NamedQuery(name = "Currencyrate.findByOfferRate", query = "SELECT c FROM Currencyrate c WHERE c.offerRate = :offerRate"),
        @NamedQuery(name = "Currencyrate.findByMidRate", query = "SELECT c FROM Currencyrate c WHERE c.midRate = :midRate"),
        @NamedQuery(name = "Currencyrate.findByValueDate", query = "SELECT c FROM Currencyrate c WHERE c.valueDate = :valueDate"),
        @NamedQuery(name = "Currencyrate.findByTransactionDate", query = "SELECT c FROM Currencyrate c WHERE c.transactionDate = :transactionDate"),
        @NamedQuery(name = "Currencyrate.findByUser", query = "SELECT c FROM Currencyrate c WHERE c.user = :user"),
        @NamedQuery(name = "Currencyrate.findByAuthorizer", query = "SELECT c FROM Currencyrate c WHERE c.authorizer = :authorizer")})
public class Currencyrate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rateID")
    private Integer rateID;
    @Version
    @XmlTransient
    @JsonIgnore
    private long version;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "bidRate")
    private Float bidRate;
    @Column(name = "offerRate")
    private Float offerRate;
    @Column(name = "midRate")
    private Float midRate;
    @Column(name = "valueDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date valueDate = new Date();
    @Column(name = "transactionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate = new Date();
    @Size(max = 45)
    @Column(name = "user")
    private String user;
    @Size(max = 45)
    @Column(name = "authorizer")
    private String authorizer;
    @JoinColumn(name = "currencyID", referencedColumnName = "currencyID")
    @ManyToOne(optional = false)
    private Currency currencyID;

    public Currencyrate() {
    }

    public Currencyrate(Integer rateID) {
        this.rateID = rateID;
    }

    public Integer getRateID() {
        return rateID;
    }

    public void setRateID(Integer rateID) {
        this.rateID = rateID;
    }

    public Float getBidRate() {
        return bidRate;
    }

    public void setBidRate(Float bidRate) {
        this.bidRate = bidRate;
    }

    public Float getOfferRate() {
        return offerRate;
    }

    public void setOfferRate(Float offerRate) {
        this.offerRate = offerRate;
    }

    public Float getMidRate() {
        midRate = (offerRate + bidRate) / 2;
        return midRate;
    }

    public void setMidRate(Float midRate) {
        this.midRate = midRate;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAuthorizer() {
        return authorizer;
    }

    public void setAuthorizer(String authorizer) {
        this.authorizer = authorizer;
    }

    public Currency getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(Currency currencyID) {
        this.currencyID = currencyID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rateID != null ? rateID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currencyrate)) {
            return false;
        }
        Currencyrate other = (Currencyrate) object;
        if ((this.rateID == null && other.rateID != null) || (this.rateID != null && !this.rateID.equals(other.rateID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kamak.entities.Currencyrate[ rateID=" + rateID + " ]";
    }

}

