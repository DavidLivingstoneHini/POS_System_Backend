package com.kamakz.kamakzbackend.model.constants;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "currency")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c"),
        @NamedQuery(name = "Currency.findByCurrencyId", query = "SELECT c FROM Currency c WHERE c.currencyID = :currencyID"),
        @NamedQuery(name = "Currency.findByCurrencyNumber", query = "SELECT c FROM Currency c WHERE c.currencyNumber = :currencyNumber"),
        @NamedQuery(name = "Currency.findByCurrencyCode", query = "SELECT c FROM Currency c WHERE c.currencyCode = :currencyCode"),
        @NamedQuery(name = "Currency.findByCurrencyName", query = "SELECT c FROM Currency c WHERE c.currencyName = :currencyName"),
        @NamedQuery(name = "Currency.findByBidRate", query = "SELECT c FROM Currency c WHERE c.bidRate = :bidRate"),
        @NamedQuery(name = "Currency.findByOfferRate", query = "SELECT c FROM Currency c WHERE c.offerRate = :offerRate"),
        @NamedQuery(name = "Currency.findByMidRate", query = "SELECT c FROM Currency c WHERE c.midRate = :midRate"),
        @NamedQuery(name = "Currency.findByDateCreated", query = "SELECT c FROM Currency c WHERE c.dateCreated = :dateCreated"),
        @NamedQuery(name = "Currency.findByBaseCurrency", query = "SELECT c FROM Currency c WHERE c.baseCurrency = :baseCurrency")})
public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "currencyID")
    private Integer currencyID;
    @Version
    @XmlTransient
    @com.fasterxml.jackson.annotation.JsonIgnore
    private long version;

    @Column(name = "currencyNumber")
    private String currencyNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "currencyCode")
    private String currencyCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "currencyName")
    private String currencyName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "bidRate")
    private Float bidRate;
    @Column(name = "offerRate")
    private Float offerRate;
    @Column(name = "midRate")
    private Float midRate;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Size(max = 4)
    @Column(name = "baseCurrency")
    private String baseCurrency;
    @OneToMany(mappedBy = "currencyID")
    private List<Currencyrate> currencyrateList;

    @ManyToOne(optional=true)
    private Company company;

    private String country;
    private String uuid;

    public Currency() {
    }

    public Currency(Integer currencyID, String currencyNumber, String currencyCode, String currencyCame) {
        this.currencyID = currencyID;
        this.currencyNumber = currencyNumber;
        this.currencyCode = currencyCode;
        this.currencyName = currencyCame;
    }

    public Integer getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(Integer currencyID) {
        this.currencyID = currencyID;
    }

    public String getCurrencyNumber() {
        return currencyNumber;
    }

    public void setCurrencyNumber(String currencyNumber) {
        this.currencyNumber = currencyNumber;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
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
        return midRate;
    }

    public void setMidRate(Float midRate) {
        this.midRate = midRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currencyID != null ? currencyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        if ((this.currencyID == null && other.currencyID != null) || (this.currencyID != null && !this.currencyID.equals(other.currencyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kamak.ezpensions.ezpensions.entities.Currency[ currencyID=" + currencyID + " ]";
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public List<Currencyrate> getCurrencyrateList() {
        return currencyrateList;
    }

    public void setCurrencyrateList(List<Currencyrate> currencyrateList) {
        this.currencyrateList = currencyrateList;
    }



}

