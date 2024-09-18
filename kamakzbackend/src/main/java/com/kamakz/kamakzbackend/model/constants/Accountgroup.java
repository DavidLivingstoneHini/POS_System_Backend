package com.kamakz.kamakzbackend.model.constants;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "accountgroup")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Accountgroup.findAll", query = "SELECT a FROM Accountgroup a"),
        @NamedQuery(name = "Accountgroup.findByAccountGroupID", query = "SELECT a FROM Accountgroup a WHERE a.accountGroupID = :accountGroupID"),
        @NamedQuery(name = "Accountgroup.findByGroupName", query = "SELECT a FROM Accountgroup a WHERE a.groupName = :groupName"),
        @NamedQuery(name = "Accountgroup.findByReportSequence", query = "SELECT a FROM Accountgroup a WHERE a.reportSequence = :reportSequence")})
public class Accountgroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accountGroupID")
    private Integer accountGroupID;
    private Integer version = 0;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "groupName")
    private String groupName;
    @Column(name = "reportSequence")
    private Integer reportSequence;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accountGroupID")
    private List<Accountsubgroup> accountsubgroupList;
    @OneToMany(mappedBy = "accountGroupID")
    private List<Account> accountList;
    @ManyToOne
    private Company company;

    public Accountgroup() {
    }

    public Accountgroup(Integer accountGroupID) {
        this.accountGroupID = accountGroupID;
    }

    public Accountgroup(Integer accountGroupID, String groupName) {
        this.accountGroupID = accountGroupID;
        this.groupName = groupName;
    }

    public Integer getAccountGroupID() {
        return accountGroupID;
    }

    public void setAccountGroupID(Integer accountGroupID) {
        this.accountGroupID = accountGroupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getReportSequence() {
        return reportSequence;
    }

    public void setReportSequence(Integer reportSequence) {
        this.reportSequence = reportSequence;
    }

    @XmlTransient
    @JsonIgnore
    public List<Accountsubgroup> getAccountsubgroupList() {
        return accountsubgroupList;
    }

    public void setAccountsubgroupList(List<Accountsubgroup> accountsubgroupList) {
        this.accountsubgroupList = accountsubgroupList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountGroupID != null ? accountGroupID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accountgroup)) {
            return false;
        }
        Accountgroup other = (Accountgroup) object;
        if ((this.accountGroupID == null && other.accountGroupID != null) || (this.accountGroupID != null && !this.accountGroupID.equals(other.accountGroupID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kamak.ezpensions.entities.Accountgroup[ accountGroupID=" + accountGroupID + " ]";
    }

}

