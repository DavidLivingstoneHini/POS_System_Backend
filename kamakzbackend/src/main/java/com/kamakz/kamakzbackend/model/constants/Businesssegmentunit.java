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
 * @author Evans
 */
@Entity
@Table(name = "businesssegmentunit")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Businesssegmentunit.findAll", query = "SELECT b FROM Businesssegmentunit b"),
        @NamedQuery(name = "Businesssegmentunit.findByUnitID", query = "SELECT b FROM Businesssegmentunit b WHERE b.unitID = :unitID"),
        @NamedQuery(name = "Businesssegmentunit.findByUnitName", query = "SELECT b FROM Businesssegmentunit b WHERE b.unitName = :unitName"),
        @NamedQuery(name = Businesssegmentunit.FIND_UNIT_BY_SEGMENT, query = "SELECT b FROM Businesssegmentunit b WHERE b.segmentID = :segment"),
        @NamedQuery(name = "Businesssegmentunit.findByDateCreated", query = "SELECT b FROM Businesssegmentunit b WHERE b.dateCreated = :dateCreated")})
public class Businesssegmentunit implements Serializable {

    public static final String FIND_UNIT_BY_SEGMENT = "Businesssegmentunit.FIND_UNIT_BY_SEGMENT";

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
    @Column(name = "unitID")
    private Integer unitID;
    private Integer version = 0;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "unitName")
    private String unitName;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated = new Date();
    @JoinColumn(name = "segmentID", referencedColumnName = "segmentID")
    @ManyToOne(optional = false)
    private Businesssegment segmentID;
    private String retrievalCode;

    public Businesssegmentunit() {
    }

    public Businesssegmentunit(Integer unitID) {
        this.unitID = unitID;
    }

    public Businesssegmentunit(Integer unitID, String unitName) {
        this.unitID = unitID;
        this.unitName = unitName;
    }

    public Integer getUnitID() {
        return unitID;
    }

    public void setUnitID(Integer unitID) {
        this.unitID = unitID;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Businesssegment getSegmentID() {
        return segmentID;
    }

    public void setSegmentID(Businesssegment segmentID) {
        this.segmentID = segmentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (unitID != null ? unitID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Businesssegmentunit)) {
            return false;
        }
        Businesssegmentunit other = (Businesssegmentunit) object;
        if ((this.unitID == null && other.unitID != null) || (this.unitID != null && !this.unitID.equals(other.unitID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kamak.ezpensions.entities.Businesssegmentunit[ unitID=" + unitID + " ]";
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

