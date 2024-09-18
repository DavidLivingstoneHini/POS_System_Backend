package com.kamakz.kamakzbackend.model.constants;

import com.kamakz.kamakzbackend.model.Model;
import com.kamakz.kamakzbackend.model.constants.Account;
import com.kamakz.kamakzbackend.model.constants.Company;
import com.kamakz.kamakzbackend.model.constants.EducationLevel;
import com.kamakz.kamakzbackend.model.constants.CompanyEmployee;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 *
 * @author jboss
 */
@Entity
@Table(name = "partner")
public class Partner extends Model {

    private static final long serialVersionUID = -5825922287427558688L;

    private String fullName;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    private String email;
    private String partnerTelephone;
    private String barCode="";
    @NotNull
    private String partnerType;
    private Double salesDiscount = 0.0;
    private Double discount = 0.0;
    private Double accountBalance = 0.0;

    private String password;
    private String resetPasswordCode;
    private Boolean loggedIn = false;
    private Boolean firstTimeLogin = false;
    private Boolean disabled = false;

    private Integer referrals = 0;
    private String interest1 = "";
    private String interest2 = "";
    private String interest3 = "";
    private String interest4 = "";

    private Boolean flatSaleCommision = false;
    private Double flatSaleCommisionAmount = 0.0;
    private Double saleCommisionRate = 0.0;

    private Boolean flatPurchaseCommision = false;
    private Double flatPurchaseCommisionAmount = 0.0;
    private Double purchaseCommisionRate = 0.0;
    private String flatOn = "Sales Value";
    private String flatOnPurchase = "Purchase Value";

    private String retrivalCode;


    @ManyToOne(optional = true)
    Partner referrer;

    @ManyToOne (optional = true)
    private Account partnerGl;

    @ManyToOne
    Company company;
    private Double creditLimit = 0.0;



    //Newly added fields

    private String baseNumber;
    private String nationalId;

    @Temporal(TemporalType.DATE)
    private Date dateOfIncorporation;
    private String registrationNumber;
    private String juridictionOfIncorporation;
    private String businessNature;
    private String industry;
    private String registeredOffice;
    private String website;
    private String taxID;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private String placeOfBirth;
    private String countryOfBirth;
    private String countryOfResidence;
    private String telephone1;
    private String telephone2;

    private String typeOfOtherID;
    private String idNumber;
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    private String occupation;
    private String sourceOfIncome;
    private Double annualIncome;


    //Next Of Kin (NOK) information
    private String nokName;
    private String nokAddress;
    private String nokTelephones;

    //Banking Details
    private String bankName;
    private String bankBranch;
    private String bankAccountNumber;

    private boolean listedOnStockExchange = false;
    private boolean usCitizen = false;
    private boolean usPassportHolder = false;
    private boolean usGreenCardHolder = false;
    private boolean kycCompliant = false;
    private String kycConfirmedBy;

    private String userName;
    private String approver;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateApproved;
    private String fullData = "Yes";
    private String mothersName;
    private String fathersName;
    @ManyToOne(optional=true)
    private EducationLevel educationalLevel;
    @ManyToOne(optional=true)
    private CompanyEmployee originator;
    @ManyToOne(optional=true)
    private CompanyEmployee relationshipManager;
    @ManyToOne(optional=true)
    private PartnerClassification classification;





    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPartnerTelephone() {
        return partnerTelephone;
    }

    public void setPartnerTelephone(String partnerTelephone) {
        this.partnerTelephone = partnerTelephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getResetPasswordCode() {
        return resetPasswordCode;
    }

    public void setResetPasswordCode(String resetPasswordCode) {
        this.resetPasswordCode = resetPasswordCode;
    }

    public String getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(String partnerType) {
        if ("Customer".equals(partnerType) || "Supplier".equals(partnerType) || "Agent".equals(partnerType)) {
            this.partnerType = partnerType;
        } else {
            throw new IllegalArgumentException("Invalid partner type");
        }
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Boolean getFirstTimeLogin() {
        return firstTimeLogin;
    }

    public void setFirstTimeLogin(Boolean firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Integer getReferrals() {
        return referrals;
    }

    public void setReferrals(Integer referrals) {
        this.referrals = referrals;
    }

    public String getInterest1() {
        return interest1;
    }

    public void setInterest1(String interest1) {
        this.interest1 = interest1;
    }

    public String getInterest2() {
        return interest2;
    }

    public void setInterest2(String interest2) {
        this.interest2 = interest2;
    }

    public String getInterest3() {
        return interest3;
    }

    public void setInterest3(String interest3) {
        this.interest3 = interest3;
    }

    public String getInterest4() {
        return interest4;
    }

    public void setInterest4(String interest4) {
        this.interest4 = interest4;
    }


    public Partner getReferrer() {
        return referrer;
    }

    public void setReferrer(Partner referrer) {
        this.referrer = referrer;
    }

    public Account getPartnerGl() {
        return partnerGl;
    }

    public void setPartnerGl(Account partnerGl) {
        this.partnerGl = partnerGl;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Double getSalesDiscount() {
        return salesDiscount;
    }

    public void setSalesDiscount(Double salesDiscount) {
        this.salesDiscount = salesDiscount;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Boolean getFlatSaleCommision() {
        return flatSaleCommision;
    }

    public void setFlatSaleCommision(Boolean flatSaleCommision) {
        this.flatSaleCommision = flatSaleCommision;
    }

    public Double getFlatSaleCommisionAmount() {
        return flatSaleCommisionAmount;
    }

    public void setFlatSaleCommisionAmount(Double flatSaleCommisionAmount) {
        this.flatSaleCommisionAmount = flatSaleCommisionAmount;
    }

    public Double getSaleCommisionRate() {
        return saleCommisionRate;
    }

    public void setSaleCommisionRate(Double saleCommisionRate) {
        this.saleCommisionRate = saleCommisionRate;
    }

    public Boolean getFlatPurchaseCommision() {
        return flatPurchaseCommision;
    }

    public void setFlatPurchaseCommision(Boolean flatPurchaseCommision) {
        this.flatPurchaseCommision = flatPurchaseCommision;
    }

    public Double getFlatPurchaseCommisionAmount() {
        return flatPurchaseCommisionAmount;
    }

    public void setFlatPurchaseCommisionAmount(Double flatPurchaseCommisionAmount) {
        this.flatPurchaseCommisionAmount = flatPurchaseCommisionAmount;
    }

    public Double getPurchaseCommisionRate() {
        return purchaseCommisionRate;
    }

    public void setPurchaseCommisionRate(Double purchaseCommisionRate) {
        this.purchaseCommisionRate = purchaseCommisionRate;
    }

    public String getFlatOn() {
        return flatOn;
    }

    public void setFlatOn(String flatOn) {
        this.flatOn = flatOn;
    }

    public String getFlatOnPurchase() {
        return flatOnPurchase;
    }

    public void setFlatOnPurchase(String flatOnPurchase) {
        this.flatOnPurchase = flatOnPurchase;
    }

    public String getBaseNumber() {
        return baseNumber;
    }

    public void setBaseNumber(String baseNumber) {
        this.baseNumber = baseNumber;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Date getDateOfIncorporation() {
        return dateOfIncorporation;
    }

    public void setDateOfIncorporation(Date dateOfIncorporation) {
        this.dateOfIncorporation = dateOfIncorporation;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getJuridictionOfIncorporation() {
        return juridictionOfIncorporation;
    }

    public void setJuridictionOfIncorporation(String juridictionOfIncorporation) {
        this.juridictionOfIncorporation = juridictionOfIncorporation;
    }

    public String getBusinessNature() {
        return businessNature;
    }

    public void setBusinessNature(String businessNature) {
        this.businessNature = businessNature;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRegisteredOffice() {
        return registeredOffice;
    }

    public void setRegisteredOffice(String registeredOffice) {
        this.registeredOffice = registeredOffice;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public String getTelephone1() {
        return telephone1;
    }

    public void setTelephone1(String telephone1) {
        this.telephone1 = telephone1;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getTypeOfOtherID() {
        return typeOfOtherID;
    }

    public void setTypeOfOtherID(String typeOfOtherID) {
        this.typeOfOtherID = typeOfOtherID;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getSourceOfIncome() {
        return sourceOfIncome;
    }

    public void setSourceOfIncome(String sourceOfIncome) {
        this.sourceOfIncome = sourceOfIncome;
    }

    public Double getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Double annualIncome) {
        this.annualIncome = annualIncome;
    }


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public boolean isListedOnStockExchange() {
        return listedOnStockExchange;
    }

    public void setListedOnStockExchange(boolean listedOnStockExchange) {
        this.listedOnStockExchange = listedOnStockExchange;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public String getFullData() {
        return fullData;
    }

    public void setFullData(String fullData) {
        this.fullData = fullData;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public EducationLevel getEducationalLevel() {
        return educationalLevel;
    }

    public void setEducationalLevel(EducationLevel educationalLevel) {
        this.educationalLevel = educationalLevel;
    }

    public CompanyEmployee getOriginator() {
        return originator;
    }

    public void setOriginator(CompanyEmployee originator) {
        this.originator = originator;
    }

    public CompanyEmployee getRelationshipManager() {
        return relationshipManager;
    }

    public void setRelationshipManager(CompanyEmployee relationshipManager) {
        this.relationshipManager = relationshipManager;
    }

    public PartnerClassification getClassification() {
        return classification;
    }

    public void setClassification(PartnerClassification classification) {
        this.classification = classification;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getNokName() {
        return nokName;
    }

    public void setNokName(String nokName) {
        this.nokName = nokName;
    }

    public String getNokAddress() {
        return nokAddress;
    }

    public void setNokAddress(String nokAddress) {
        this.nokAddress = nokAddress;
    }

    public String getNokTelephones() {
        return nokTelephones;
    }

    public void setNokTelephones(String nokTelephones) {
        this.nokTelephones = nokTelephones;
    }

    public boolean isUsCitizen() {
        return usCitizen;
    }

    public void setUsCitizen(boolean usCitizen) {
        this.usCitizen = usCitizen;
    }

    public boolean isUsPassportHolder() {
        return usPassportHolder;
    }

    public void setUsPassportHolder(boolean usPassportHolder) {
        this.usPassportHolder = usPassportHolder;
    }

    public boolean isUsGreenCardHolder() {
        return usGreenCardHolder;
    }

    public void setUsGreenCardHolder(boolean usGreenCardHolder) {
        this.usGreenCardHolder = usGreenCardHolder;
    }

    public boolean isKycCompliant() {
        return kycCompliant;
    }

    public void setKycCompliant(boolean kycCompliant) {
        this.kycCompliant = kycCompliant;
    }

    public String getKycConfirmedBy() {
        return kycConfirmedBy;
    }

    public void setKycConfirmedBy(String kycConfirmedBy) {
        this.kycConfirmedBy = kycConfirmedBy;
    }

    public String getRetrivalCode() {
        return retrivalCode;
    }

    public void setRetrivalCode(String retrivalCode) {
        this.retrivalCode = retrivalCode;
    }


}

