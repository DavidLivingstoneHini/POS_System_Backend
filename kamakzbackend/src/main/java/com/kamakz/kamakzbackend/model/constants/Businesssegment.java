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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Evans
 */
@Entity
@Table(name = "businesssegment")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Businesssegment.findAll", query = "SELECT b FROM Businesssegment b"),
        @NamedQuery(name = "Businesssegment.findBySegmentID", query = "SELECT b FROM Businesssegment b WHERE b.segmentID = :segmentID"),
        @NamedQuery(name = "Businesssegment.findBySegmentName", query = "SELECT b FROM Businesssegment b WHERE b.segmentName = :segmentName"),
        @NamedQuery(name = Businesssegment.FIND_SEGMENT_BY_COMPANY, query = "SELECT b FROM Businesssegment b WHERE b.companyID = :company"),
        @NamedQuery(name = "Businesssegment.findByDateCreated", query = "SELECT b FROM Businesssegment b WHERE b.dateCreated = :dateCreated")})
public class Businesssegment implements Serializable {

    public static final String FIND_SEGMENT_BY_COMPANY = "Businesssegment.FIND_SEGMENT_BY_COMPANY";

    @Size(max = 30)
    @Column(name = "user")
    private String user;
    @Size(max = 30)
    @Column(name = "approved_by")
    private String approvedBy;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "segmentID")
    private Integer segmentID;
    private Integer version = 0;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "segmentName")
    private String segmentName;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated = new Date();
    @OneToMany(mappedBy = "segmentID")
    private List<Businesssegmentunit> businesssegmentunitList;
    @JoinColumn(name = "companyID", referencedColumnName = "companyID")
    @ManyToOne(optional = false)
    private Company companyID;

    private String retrievalCode;

    public Businesssegment() {
    }

    public Businesssegment(Integer segmentID) {
        this.segmentID = segmentID;
    }

    public Businesssegment(Integer segmentID, String segmentName) {
        this.segmentID = segmentID;
        this.segmentName = segmentName;
    }

    public Integer getSegmentID() {
        return segmentID;
    }

    public void setSegmentID(Integer segmentID) {
        this.segmentID = segmentID;
    }

    public String getSegmentName() {
        return segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @XmlTransient
    public List<Businesssegmentunit> getBusinesssegmentunitList() {
        return businesssegmentunitList;
    }

    public void setBusinesssegmentunitList(List<Businesssegmentunit> businesssegmentunitList) {
        this.businesssegmentunitList = businesssegmentunitList;
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
        hash += (segmentID != null ? segmentID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Businesssegment)) {
            return false;
        }
        Businesssegment other = (Businesssegment) object;
        if ((this.segmentID == null && other.segmentID != null) || (this.segmentID != null && !this.segmentID.equals(other.segmentID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kamak.ezpensions.entities.Businesssegment[ segmentID=" + segmentID + " ]";
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getRetrievalCode() {
        return retrievalCode;
    }

    public void setRetrievalCode(String retrievalCode) {
        this.retrievalCode = retrievalCode;
    }



}
