package com.kamakz.kamakzbackend.model.constants;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "accountsubgroup")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Accountsubgroup.findAll", query = "SELECT a FROM Accountsubgroup a"),
        @NamedQuery(name = "Accountsubgroup.findByAccountSubGroupID", query = "SELECT a FROM Accountsubgroup a WHERE a.accountSubGroupID = :accountSubGroupID"),
        @NamedQuery(name = "Accountsubgroup.findByAccountSubGroupName", query = "SELECT a FROM Accountsubgroup a WHERE a.accountSubGroupName = :accountSubGroupName"),
        @NamedQuery(name = Accountsubgroup.FIND_SUB_GROUP_BY_GROUP, query = "SELECT a FROM Accountsubgroup a WHERE a.accountGroupID = :group ORDER BY a.subGroupSequence ASC"),
        @NamedQuery(name = "Accountsubgroup.findBySubGroupSequence", query = "SELECT a FROM Accountsubgroup a WHERE a.subGroupSequence = :subGroupSequence")})
public class Accountsubgroup implements Serializable {

    public static final String FIND_SUB_GROUP_BY_GROUP = "Accountsubgroup.FIND_SUB_GROUP_BY_GROUP";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accountSubGroupID")
    private Integer accountSubGroupID;
    private Integer version = 0;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "accountSubGroupName")
    private String accountSubGroupName;
    @Column(name = "subGroupSequence")
    private Integer subGroupSequence;
    @JoinColumn(name = "accountGroupID", referencedColumnName = "accountGroupID")
    @ManyToOne(optional = false)
    private Accountgroup accountGroupID;
    @OneToMany(mappedBy = "accountSubGroupID")
    private List<Account> accountList;
    @ManyToOne
    private Company company;

    public Accountsubgroup() {
    }

    public Accountsubgroup(Integer accountSubGroupID) {
        this.accountSubGroupID = accountSubGroupID;
    }

    public Accountsubgroup(Integer accountSubGroupID, String accountSubGroupName) {
        this.accountSubGroupID = accountSubGroupID;
        this.accountSubGroupName = accountSubGroupName;
    }

    public Integer getAccountSubGroupID() {
        return accountSubGroupID;
    }

    public void setAccountSubGroupID(Integer accountSubGroupID) {
        this.accountSubGroupID = accountSubGroupID;
    }

    public String getAccountSubGroupName() {
        return accountSubGroupName;
    }

    public void setAccountSubGroupName(String accountSubGroupName) {
        this.accountSubGroupName = accountSubGroupName;
    }

    public Integer getSubGroupSequence() {
        return subGroupSequence;
    }

    public void setSubGroupSequence(Integer subGroupSequence) {
        this.subGroupSequence = subGroupSequence;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Accountgroup getAccountGroupID() {
        return accountGroupID;
    }

    public void setAccountGroupID(Accountgroup accountGroupID) {
        this.accountGroupID = accountGroupID;
    }

    @XmlTransient
    @JsonIgnore
    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountSubGroupID != null ? accountSubGroupID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accountsubgroup)) {
            return false;
        }
        Accountsubgroup other = (Accountsubgroup) object;
        if ((this.accountSubGroupID == null && other.accountSubGroupID != null) || (this.accountSubGroupID != null && !this.accountSubGroupID.equals(other.accountSubGroupID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kamak.ezpensions.entities.Accountsubgroup[ accountSubGroupID=" + accountSubGroupID + " ]";
    }

}

