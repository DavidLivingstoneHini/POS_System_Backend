package com.kamakz.kamakzbackend.model.constants;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
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
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "account")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
        @NamedQuery(name = "Account.findByAccountID", query = "SELECT a FROM Account a WHERE a.accountID = :accountID"),
        @NamedQuery(name = "Account.findByAccountNumber", query = "SELECT a FROM Account a WHERE a.accountNumber = :accountNumber"),
        @NamedQuery(name = "Account.findByAccountName", query = "SELECT a FROM Account a WHERE a.accountName = :accountName"),
        @NamedQuery(name = "Account.findByAccountGroupName", query = "SELECT a FROM Account a WHERE a.accountGroupName = :accountGroupName"),
        @NamedQuery(name = "Account.findByAccountSubGroupName", query = "SELECT a FROM Account a WHERE a.accountSubGroupName = :accountSubGroupName"),
        @NamedQuery(name = "Account.findByCurrencyName", query = "SELECT a FROM Account a WHERE a.currencyName = :currencyName"),
        @NamedQuery(name = "Account.findByEntryType", query = "SELECT a FROM Account a WHERE a.entryType = :entryType"),
        @NamedQuery(name = "Account.findByForeignCurrency", query = "SELECT a FROM Account a WHERE a.foreignCurrency = :foreignCurrency"),
        @NamedQuery(name = "Account.findByForeignCurrencyBalance", query = "SELECT a FROM Account a WHERE a.foreignCurrencyBalance = :foreignCurrencyBalance"),
        @NamedQuery(name = "Account.findByAccountBalance", query = "SELECT a FROM Account a WHERE a.accountBalance = :accountBalance"),
        @NamedQuery(name = "Account.findByBaseCurrencyOneBalance", query = "SELECT a FROM Account a WHERE a.baseCurrencyOneBalance = :baseCurrencyOneBalance"),
        @NamedQuery(name = "Account.findByBaseCurrencyTwoBalance", query = "SELECT a FROM Account a WHERE a.baseCurrencyTwoBalance = :baseCurrencyTwoBalance"),
        @NamedQuery(name = "Account.findBySystemAccount", query = "SELECT a FROM Account a WHERE a.systemAccount = :systemAccount"),
        @NamedQuery(name = "Account.findByBankAccount", query = "SELECT a FROM Account a WHERE a.bankAccount = :bankAccount"),
        @NamedQuery(name = "Account.findByLastTransactionDate", query = "SELECT a FROM Account a WHERE a.lastTransactionDate = :lastTransactionDate"),
        @NamedQuery(name = "Account.findByDateCreated", query = "SELECT a FROM Account a WHERE a.dateCreated = :dateCreated"),
        @NamedQuery(name = "Account.findByOpenBy", query = "SELECT a FROM Account a WHERE a.openBy = :openBy"),
        @NamedQuery(name = Account.FIND_ACCOUNTS_BY_SUB_GROUP, query = "SELECT a FROM Account a WHERE a.accountSubGroupID = :sub and a.company=:comp"),
        @NamedQuery(name = "Account.findByApprovedBy", query = "SELECT a FROM Account a WHERE a.approvedBy = :approvedBy"),
        @NamedQuery(name = "Account.findByApproved", query = "SELECT a FROM Account a WHERE a.approved = :approved")})
public class Account implements Serializable {

    public static final String FIND_ACCOUNTS_BY_SUB_GROUP = "Account.FIND_ACCOUNTS_BY_SUB_GROUP";
    public static final String FIND_ACCOUNT_BY_ACCOUNT_NUMBER = "Account.FIND_ACCOUNT_BY_ACCOUNT_NUMBER";

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "accountID")
    private Integer accountID;
    @Version
    @XmlTransient
    @com.fasterxml.jackson.annotation.JsonIgnore
    private long version = 0;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accountNumber", unique = true)
    private String accountNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accountName")
    private String accountName;
    @Column(name = "accountGroupName")
    private String accountGroupName;
    @Column(name = "accountSubGroupName")
    private String accountSubGroupName;
    @Column(name = "currencyName")
    private String currencyName;
    @Column(name = "entryType")
    private String entryType;
    @Column(name = "taxable")
    private Boolean taxable = false;
    @Column(name = "taxa_rate")
    private Double taxRate = 0.0;
    @Basic(optional = false)
    @NotNull
    @Column(name = "foreignCurrency")
    private String foreignCurrency;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "foreignCurrencyBalance")
    private Double foreignCurrencyBalance = 0.0;
    @Column(name = "accountBalance")
    private Double accountBalance = 0.0;
    @Column(name = "baseCurrencyOneBalance")
    private Double baseCurrencyOneBalance = 0.0;
    @Column(name = "baseCurrencyTwoBalance")
    private Double baseCurrencyTwoBalance = 0.0;
    @Column(name = "systemAccount")
    private Character systemAccount;
    @Column(name = "bankAccount")
    private Character bankAccount;
    @Column(name = "lastTransactionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastTransactionDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated = new Date();
    @Column(name = "openBy")
    private String openBy;
    @Column(name = "approvedBy")
    private String approvedBy;
    @Column(name = "approved")
    private String approved;


    @JoinColumn(name = "accountGroupID", referencedColumnName = "accountGroupID")
    @ManyToOne(optional = false)
    private Accountgroup accountGroupID;
    @JoinColumn(name = "currencyID", referencedColumnName = "currencyID")
    @ManyToOne(optional = false)
    private Currency currencyID;
    @JoinColumn(name = "accountSubGroupID", referencedColumnName = "accountSubGroupID")
    @ManyToOne(optional = false)
    private Accountsubgroup accountSubGroupID;
    @ManyToOne
    private Company company;

//    @ManyToOne
//    private Account taxGl;

    private String retrievalCode;

    public Account() {
    }

    public Account(Integer accountID) {
        this.accountID = accountID;
    }

    public Account(Integer accountID, String accountNumber, String accountName, String foreignCurrency, Date dateCreated) {
        this.accountID = accountID;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.foreignCurrency = foreignCurrency;
        this.dateCreated = dateCreated;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountGroupName() {
        return accountGroupName;
    }

    public void setAccountGroupName(String accountGroupName) {
        this.accountGroupName = accountGroupName;
    }

    public String getAccountSubGroupName() {
        return accountSubGroupName;
    }

    public void setAccountSubGroupName(String accountSubGroupName) {
        this.accountSubGroupName = accountSubGroupName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public String getForeignCurrency() {
        return foreignCurrency;
    }

    public void setForeignCurrency(String foreignCurrency) {
        this.foreignCurrency = foreignCurrency;
    }

    public Double getForeignCurrencyBalance() {
        return foreignCurrencyBalance;
    }

    public void setForeignCurrencyBalance(Double foreignCurrencyBalance) {
        this.foreignCurrencyBalance = foreignCurrencyBalance;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Double getBaseCurrencyOneBalance() {
        return baseCurrencyOneBalance;
    }

    public void setBaseCurrencyOneBalance(Double baseCurrencyOneBalance) {
        this.baseCurrencyOneBalance = baseCurrencyOneBalance;
    }

    public Double getBaseCurrencyTwoBalance() {
        return baseCurrencyTwoBalance;
    }

    public void setBaseCurrencyTwoBalance(Double baseCurrencyTwoBalance) {
        this.baseCurrencyTwoBalance = baseCurrencyTwoBalance;
    }

    public Character getSystemAccount() {
        return systemAccount;
    }

    public void setSystemAccount(Character systemAccount) {
        this.systemAccount = systemAccount;
    }

    public Character getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(Character bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Date getLastTransactionDate() {
        return lastTransactionDate;
    }

    public void setLastTransactionDate(Date lastTransactionDate) {
        this.lastTransactionDate = lastTransactionDate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getOpenBy() {
        return openBy;
    }

    public void setOpenBy(String openBy) {
        this.openBy = openBy;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }



    public Accountgroup getAccountGroupID() {
        return accountGroupID;
    }

    public void setAccountGroupID(Accountgroup accountGroupID) {
        this.accountGroupID = accountGroupID;
    }

    public Currency getCurrencyID() {
        return currencyID;
    }

    public void setCurrencyID(Currency currencyID) {
        this.currencyID = currencyID;
    }

    public Accountsubgroup getAccountSubGroupID() {
        return accountSubGroupID;
    }

    public void setAccountSubGroupID(Accountsubgroup accountSubGroupID) {
        this.accountSubGroupID = accountSubGroupID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accountID != null ? accountID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.accountID == null && other.accountID != null) || (this.accountID != null && !this.accountID.equals(other.accountID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kamak.entities.Account[ accountID=" + accountID + " ]";
    }


    public Boolean getTaxable() {
        return taxable;
    }

    public void setTaxable(Boolean taxable) {
        this.taxable = taxable;
    }

    public Double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }

//    public Account getTaxGl() {
//        return taxGl;
//    }
//
//    public void setTaxGl(Account taxGl) {
//        this.taxGl = taxGl;
//    }
//
//    public AccountSummary getAccountSummary() {
//        return accountSummary;
//    }
//
//    public void setAccountSummary(AccountSummary accountSummary) {
//        this.accountSummary = accountSummary;
//    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getRetrievalCode() {
        return retrievalCode;
    }

    public void setRetrievalCode(String retrievalCode) {
        this.retrievalCode = retrievalCode;
    }


}

