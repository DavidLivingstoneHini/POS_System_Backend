package com.kamakz.kamakzbackend.model.constants;

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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "branch")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
        @NamedQuery(name = "Branch.findByBranchId", query = "SELECT b FROM Branch b WHERE b.branchID = :branchId"),
        @NamedQuery(name = "Branch.findByBranchName", query = "SELECT b FROM Branch b WHERE b.branchName = :branchName"),
        @NamedQuery(name = "Branch.findByBranchLocation", query = "SELECT b FROM Branch b WHERE b.branchLocation = :branchLocation"),
        @NamedQuery(name = "Branch.findByBranchAddress", query = "SELECT b FROM Branch b WHERE b.branchAddress = :branchAddress"),
        @NamedQuery(name = "Branch.findByBranchTelephone", query = "SELECT b FROM Branch b WHERE b.branchTelephone = :branchTelephone"),
        @NamedQuery(name = "Branch.findByContactPerson", query = "SELECT b FROM Branch b WHERE b.contactPerson = :contactPerson"),
        @NamedQuery(name = "Branch.findByDateCreated", query = "SELECT b FROM Branch b WHERE b.dateCreated = :dateCreated"),
        @NamedQuery(name = Branch.FIND_BRANCH_BY_COMPANY, query = "Select b from Branch b where b.companyID = :company"),
        @NamedQuery(name = "Branch.findByUser", query = "SELECT b FROM Branch b WHERE b.user = :user"),
        @NamedQuery(name = "Branch.findByApprovedBy", query = "SELECT b FROM Branch b WHERE b.approvedBy = :approvedBy")})
public class Branch implements Serializable {

    public static final String FIND_BRANCH_BY_COMPANY = "Branch.FIND_BRANCH_BY_COMPANY";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "branchID")
    private Integer branchID;
    private Integer version = 0;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "branchName")
    private String branchName;
    @Size(max = 45)
    @Column(name = "branchLocation")
    private String branchLocation;
    @Size(max = 250)
    @Column(name = "branchAddress")
    private String branchAddress;
    @Size(max = 50)
    @Column(name = "branchTelephone")
    private String branchTelephone;
    @Size(max = 50)
    @Column(name = "contactPerson")
    private String contactPerson;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated = new Date();
    @Size(max = 30)
    @Column(name = "user")
    private String user;
    @Size(max = 30)
    @Column(name = "approved_by")
    private String approvedBy;
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne(optional = false)
    private Company companyID;

    private String retrievalCode;

    public Branch() {
    }

    public Integer getBranchID() {
        return branchID;
    }

    public void setBranchID(Integer branchID) {
        this.branchID = branchID;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchLocation() {
        return branchLocation;
    }

    public void setBranchLocation(String branchLocation) {
        this.branchLocation = branchLocation;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getBranchTelephone() {
        return branchTelephone;
    }

    public void setBranchTelephone(String branchTelephone) {
        this.branchTelephone = branchTelephone;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Company getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Company companyID) {
        this.companyID = companyID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchID != null ? branchID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.branchID == null && other.branchID != null) || (this.branchID != null && !this.branchID.equals(other.branchID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kamak.ezpensions.entities.Branch[ branchID=" + branchID + " ]";
    }

    public String getRetrievalCode() {
        return retrievalCode;
    }

    public void setRetrievalCode(String retrievalCode) {
        this.retrievalCode = retrievalCode;
    }

}

