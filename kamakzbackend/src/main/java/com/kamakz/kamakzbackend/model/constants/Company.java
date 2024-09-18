package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.constants.Country;
import com.kamakz.kamakzbackend.model.constants.EcommerceCategory;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
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
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Evans
 */
@Entity
@Table(name = "company")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
        @NamedQuery(name = "Company.findByCompanyID", query = "SELECT c FROM Company c WHERE c.companyID = :companyID"),
        @NamedQuery(name = "Company.findByCompanyName", query = "SELECT c FROM Company c WHERE c.companyName = :companyName"),
        @NamedQuery(name = "Company.findByCompanyAddress", query = "SELECT c FROM Company c WHERE c.companyAddress = :companyAddress"),
        @NamedQuery(name = "Company.findByCompanyTelephone", query = "SELECT c FROM Company c WHERE c.companyTelephone = :companyTelephone"),
        @NamedQuery(name = "Company.findByCompanyEmail", query = "SELECT c FROM Company c WHERE c.companyEmail = :companyEmail"),
        @NamedQuery(name = "Company.findByCompanyPurpose", query = "SELECT c FROM Company c WHERE c.companyPurpose = :companyPurpose"),
        @NamedQuery(name = "Company.findByDateCreated", query = "SELECT c FROM Company c WHERE c.dateCreated = :dateCreated")})
public class Company implements Serializable {

    @Size(max = 30)
    @Column(name = "user")
    private String user;
    @Size(max = 30)
    @Column(name = "approved_by")
    private String approvedBy;

    private String country;

    @OneToMany(mappedBy = "companyID")
    private List<Businesssegment> businesssegmentList;

    @OneToMany(mappedBy = "companyID")
    private List<Branch> branchList;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "companyID")
    private Integer companyID;
    private Integer version = 0;
    @Size(max = 50)
    @Column(name = "companyName")
    private String companyName;
    @Size(max = 250)
    @Column(name = "companyAddress")
    private String companyAddress;
    @Size(max = 50)
    @Column(name = "companyTelephone")
    private String companyTelephone;
    @Size(max = 50)
    @Column(name = "companyEmail")
    private String companyEmail;
    @Size(max = 250)
    @Column(name = "companyPurpose")
    private String companyPurpose;
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated = new Date();

    private String website;
    private String logoPath;
    private String companyCode;

    @Column(name = "minimum_employment_age")
    private Integer minimumEmploymentAge = 0;

    @Column(name = "minimum_salary")
    private Double minimumSalary = 0.0;

    @Column(name = "attendance_database")
    private Integer attandanceDatabase = 0;
    private String retrievalCode;

    @ManyToOne
    private Account sepcialPayamentAccount;
    @ManyToOne
    private Account taxReliefAccount;
    @ManyToOne
    private Account bonusAccount;
    @ManyToOne
    private Account expensesReimbursementAccount;
    @ManyToOne
    private Account overtimePaymentAccount;
    @ManyToOne
    private Account upFrontDeductionsAccount;

    @Column(name = "prefix")
    private String prefix;

    @ManyToOne
    private Account cashAccount;

    private Integer employeeSerial = 0;

    private String logoFileName;

    @ManyToOne(optional=true)
    private EcommerceCategory ecommerceCategory;

    boolean showMyProductsOnEcommerce = false;
    private String status = "New";
    private String selectedPackage="";
    private Integer selectedPackageId=0;

    @Lob
    @Column(name = "logo")
    private byte[] logo;

    private String emailHeaderImage;
    private String emailfooterImage;
    private String advertImage;
    private String shippingAddress;

    public Company() {
    }

    public Company(Integer companyID) {
        this.companyID = companyID;
    }

    public Integer getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Integer companyID) {
        this.companyID = companyID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyTelephone() {
        return companyTelephone;
    }

    public void setCompanyTelephone(String companyTelephone) {
        this.companyTelephone = companyTelephone;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyPurpose() {
        return companyPurpose;
    }

    public void setCompanyPurpose(String companyPurpose) {
        this.companyPurpose = companyPurpose;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (companyID != null ? companyID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Company)) {
            return false;
        }
        Company other = (Company) object;
        if ((this.companyID == null && other.companyID != null) || (this.companyID != null && !this.companyID.equals(other.companyID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kamak.ezpensions.entities.Company[ companyID=" + companyID + " ]";
    }

    @XmlTransient
    public List<Businesssegment> getBusinesssegmentList() {
        return businesssegmentList;
    }

    public void setBusinesssegmentList(List<Businesssegment> businesssegmentList) {
        this.businesssegmentList = businesssegmentList;
    }

    @XmlTransient
    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
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

    public Integer getMinimumEmploymentAge() {
        return minimumEmploymentAge;
    }

    public void setMinimumEmploymentAge(Integer minimumEmploymentAge) {
        this.minimumEmploymentAge = minimumEmploymentAge;
    }

    public Double getMinimumSalary() {
        return minimumSalary;
    }

    public void setMinimumSalary(Double minimumSalary) {
        this.minimumSalary = minimumSalary;
    }

    public Integer getAttandanceDatabase() {
        return attandanceDatabase;
    }

    public void setAttandanceDatabase(Integer attandanceDatabase) {
        this.attandanceDatabase = attandanceDatabase;
    }

    public Account getSepcialPayamentAccount() {
        return sepcialPayamentAccount;
    }

    public void setSepcialPayamentAccount(Account sepcialPayamentAccount) {
        this.sepcialPayamentAccount = sepcialPayamentAccount;
    }

    public Account getTaxReliefAccount() {
        return taxReliefAccount;
    }

    public void setTaxReliefAccount(Account taxReliefAccount) {
        this.taxReliefAccount = taxReliefAccount;
    }

    public Account getBonusAccount() {
        return bonusAccount;
    }

    public void setBonusAccount(Account bonusAccount) {
        this.bonusAccount = bonusAccount;
    }

    public Account getExpensesReimbursementAccount() {
        return expensesReimbursementAccount;
    }

    public void setExpensesReimbursementAccount(Account expensesReimbursementAccount) {
        this.expensesReimbursementAccount = expensesReimbursementAccount;
    }

    public Account getOvertimePaymentAccount() {
        return overtimePaymentAccount;
    }

    public void setOvertimePaymentAccount(Account overtimePaymentAccount) {
        this.overtimePaymentAccount = overtimePaymentAccount;
    }

    public Account getUpFrontDeductionsAccount() {
        return upFrontDeductionsAccount;
    }

    public void setUpFrontDeductionsAccount(Account upFrontDeductionsAccount) {
        this.upFrontDeductionsAccount = upFrontDeductionsAccount;
    }

    public Integer getEmployeeSerial() {
        return employeeSerial;
    }

    public void setEmployeeSerial(Integer employeeSerial) {
        this.employeeSerial = employeeSerial;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Account getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(Account cashAccount) {
        this.cashAccount = cashAccount;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLogoPath() {
        return logoPath;
    }

    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public EcommerceCategory getEcommerceCategory() {
        return ecommerceCategory;
    }

    public void setEcommerceCategory(EcommerceCategory ecommerceCategory) {
        this.ecommerceCategory = ecommerceCategory;
    }

    public boolean isShowMyProductsOnEcommerce() {
        return showMyProductsOnEcommerce;
    }

    public void setShowMyProductsOnEcommerce(boolean showMyProductsOnEcommerce) {
        this.showMyProductsOnEcommerce = showMyProductsOnEcommerce;
    }

    public String getLogoFileName() {
        return logoFileName;
    }

    public void setLogoFileName(String logoFileName) {
        this.logoFileName = logoFileName;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSelectedPackage() {
        return selectedPackage;
    }

    public void setSelectedPackage(String selectedPackage) {
        this.selectedPackage = selectedPackage;
    }

    public String getEmailHeaderImage() {
        return emailHeaderImage;
    }

    public void setEmailHeaderImage(String emailHeaderImage) {
        this.emailHeaderImage = emailHeaderImage;
    }

    public String getEmailfooterImage() {
        return emailfooterImage;
    }

    public void setEmailfooterImage(String emailfooterImage) {
        this.emailfooterImage = emailfooterImage;
    }

    public String getAdvertImage() {
        return advertImage;
    }

    public void setAdvertImage(String advertImage) {
        this.advertImage = advertImage;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Integer getSelectedPackageId() {
        return selectedPackageId;
    }

    public void setSelectedPackageId(Integer selectedPackageId) {
        this.selectedPackageId = selectedPackageId;
    }


}

