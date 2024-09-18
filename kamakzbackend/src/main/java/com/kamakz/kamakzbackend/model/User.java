package com.kamakz.kamakzbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import com.kamakz.kamakzbackend.model.constants.Company;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private Integer userID;

    @ManyToOne
    @JoinColumn(name = "company_companyID", nullable = true)
    @JsonIgnore
    private Company company;

    @Column(name = "shop_id")
    private Integer companyId;

    @Column(name = "cashier")
    private String cashier;

    @Version
    @JsonIgnore
    private long version;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "username")
    private String username;

    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "password")
    private String password;

    @Size(max = 250)
    @Email(message = "Invalid email format, please check again")
    @Column(name = "email")
    private String email;

    @Column(name = "dateCreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated = new Date();

    @Column(name = "administrator")
    private String administrator;

    @Size(max = 1)
    @Column(name = "userLocked")
    private String userLocked = "N";

    @Column(name = "expiryDate")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;

    @Size(max = 1)
    @Column(name = "userLogin")
    private String userLogin = "N";

    @Column(name = "date_logged_in")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLoggedIn;

    @Column(name = "date_logged_out")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLoggedOut;

    @Size(max = 1)
    @Column(name = "handle_notification")
    private String handleNotification;

    @Size(max = 1)
    @Column(name = "manage_tickets")
    private String manageTickets;

    private Boolean loginForever = true;

    @Temporal(TemporalType.DATE)
    private Date logInFrom = new Date();

    @Temporal(TemporalType.DATE)
    private Date logInTo = new Date();

    private Boolean approved = false;
    private String approver;

    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;

    private String createdBy;

    private Boolean loginSuspended = false;

    private Boolean allowSunday = false;
    private String sundayFrom = "01:00:00";
    private String sundayTo = "23:59:00";

    private Boolean allowMonday = true;
    private String mondayFrom = "01:00:00";
    private String mondayTo = "23:59:00";

    private Boolean allowTuesday = true;
    private String tuesdayFrom = "01:00:00";
    private String tuesdayTo = "23:59:00";

    private Boolean allowWednesday = true;
    private String wednesdayFrom = "01:00:00";
    private String wednesdayTo = "23:59:00";

    private Boolean allowThursday = true;
    private String thursdayFrom = "01:00:00";
    private String thursdayTo = "23:59:00";

    private Boolean allowFriday = true;
    private String fridayFrom = "01:00:00";
    private String fridayTo = "23:59:00";

    private Boolean allowSaturday = true;
    private String saturdayFrom = "01:00:00";
    private String saturdayTo = "23:59:00";

    private String userOtp;
    @Temporal(TemporalType.TIMESTAMP)
    private Date userOtpExpiryTime = new Date();
    private String telephone;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public @NotNull @Size(min = 1, max = 50) String getUsername() {
        return username;
    }

    public void setUsername(@NotNull @Size(min = 1, max = 50) String username) {
        this.username = username;
    }

    public @NotNull @Size(min = 1, max = 32) String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @Size(min = 1, max = 32) String password) {
        this.password = password;
    }

    public @Size(max = 250) @Email(message = "Invalid email format, please check again") String getEmail() {
        return email;
    }

    public void setEmail(@Size(max = 250) @Email(message = "Invalid email format, please check again") String email) {
        this.email = email;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getAdministrator() {
        return administrator;
    }

    public void setAdministrator(String administrator) {
        this.administrator = administrator;
    }

    public @Size(max = 1) String getUserLocked() {
        return userLocked;
    }

    public void setUserLocked(@Size(max = 1) String userLocked) {
        this.userLocked = userLocked;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public @Size(max = 1) String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(@Size(max = 1) String userLogin) {
        this.userLogin = userLogin;
    }

    public Date getDateLoggedIn() {
        return dateLoggedIn;
    }

    public void setDateLoggedIn(Date dateLoggedIn) {
        this.dateLoggedIn = dateLoggedIn;
    }

    public Date getDateLoggedOut() {
        return dateLoggedOut;
    }

    public void setDateLoggedOut(Date dateLoggedOut) {
        this.dateLoggedOut = dateLoggedOut;
    }

    public @Size(max = 1) String getHandleNotification() {
        return handleNotification;
    }

    public void setHandleNotification(@Size(max = 1) String handleNotification) {
        this.handleNotification = handleNotification;
    }

    public @Size(max = 1) String getManageTickets() {
        return manageTickets;
    }

    public void setManageTickets(@Size(max = 1) String manageTickets) {
        this.manageTickets = manageTickets;
    }

    public Boolean getLoginForever() {
        return loginForever;
    }

    public void setLoginForever(Boolean loginForever) {
        this.loginForever = loginForever;
    }

    public Date getLogInFrom() {
        return logInFrom;
    }

    public void setLogInFrom(Date logInFrom) {
        this.logInFrom = logInFrom;
    }

    public Date getLogInTo() {
        return logInTo;
    }

    public void setLogInTo(Date logInTo) {
        this.logInTo = logInTo;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Boolean getLoginSuspended() {
        return loginSuspended;
    }

    public void setLoginSuspended(Boolean loginSuspended) {
        this.loginSuspended = loginSuspended;
    }

    public Boolean getAllowSunday() {
        return allowSunday;
    }

    public void setAllowSunday(Boolean allowSunday) {
        this.allowSunday = allowSunday;
    }

    public String getSundayFrom() {
        return sundayFrom;
    }

    public void setSundayFrom(String sundayFrom) {
        this.sundayFrom = sundayFrom;
    }

    public String getSundayTo() {
        return sundayTo;
    }

    public void setSundayTo(String sundayTo) {
        this.sundayTo = sundayTo;
    }

    public Boolean getAllowMonday() {
        return allowMonday;
    }

    public void setAllowMonday(Boolean allowMonday) {
        this.allowMonday = allowMonday;
    }

    public String getMondayFrom() {
        return mondayFrom;
    }

    public void setMondayFrom(String mondayFrom) {
        this.mondayFrom = mondayFrom;
    }

    public String getMondayTo() {
        return mondayTo;
    }

    public void setMondayTo(String mondayTo) {
        this.mondayTo = mondayTo;
    }

    public Boolean getAllowTuesday() {
        return allowTuesday;
    }

    public void setAllowTuesday(Boolean allowTuesday) {
        this.allowTuesday = allowTuesday;
    }

    public String getTuesdayFrom() {
        return tuesdayFrom;
    }

    public void setTuesdayFrom(String tuesdayFrom) {
        this.tuesdayFrom = tuesdayFrom;
    }

    public String getTuesdayTo() {
        return tuesdayTo;
    }

    public void setTuesdayTo(String tuesdayTo) {
        this.tuesdayTo = tuesdayTo;
    }

    public Boolean getAllowWednesday() {
        return allowWednesday;
    }

    public void setAllowWednesday(Boolean allowWednesday) {
        this.allowWednesday = allowWednesday;
    }

    public String getWednesdayFrom() {
        return wednesdayFrom;
    }

    public void setWednesdayFrom(String wednesdayFrom) {
        this.wednesdayFrom = wednesdayFrom;
    }

    public String getWednesdayTo() {
        return wednesdayTo;
    }

    public void setWednesdayTo(String wednesdayTo) {
        this.wednesdayTo = wednesdayTo;
    }

    public Boolean getAllowThursday() {
        return allowThursday;
    }

    public void setAllowThursday(Boolean allowThursday) {
        this.allowThursday = allowThursday;
    }

    public String getThursdayFrom() {
        return thursdayFrom;
    }

    public void setThursdayFrom(String thursdayFrom) {
        this.thursdayFrom = thursdayFrom;
    }

    public String getThursdayTo() {
        return thursdayTo;
    }

    public void setThursdayTo(String thursdayTo) {
        this.thursdayTo = thursdayTo;
    }

    public Boolean getAllowFriday() {
        return allowFriday;
    }

    public void setAllowFriday(Boolean allowFriday) {
        this.allowFriday = allowFriday;
    }

    public String getFridayFrom() {
        return fridayFrom;
    }

    public void setFridayFrom(String fridayFrom) {
        this.fridayFrom = fridayFrom;
    }

    public String getFridayTo() {
        return fridayTo;
    }

    public void setFridayTo(String fridayTo) {
        this.fridayTo = fridayTo;
    }

    public Boolean getAllowSaturday() {
        return allowSaturday;
    }

    public void setAllowSaturday(Boolean allowSaturday) {
        this.allowSaturday = allowSaturday;
    }

    public String getSaturdayFrom() {
        return saturdayFrom;
    }

    public void setSaturdayFrom(String saturdayFrom) {
        this.saturdayFrom = saturdayFrom;
    }

    public String getSaturdayTo() {
        return saturdayTo;
    }

    public void setSaturdayTo(String saturdayTo) {
        this.saturdayTo = saturdayTo;
    }

    public String getUserOtp() {
        return userOtp;
    }

    public void setUserOtp(String userOtp) {
        this.userOtp = userOtp;
    }

    public Date getUserOtpExpiryTime() {
        return userOtpExpiryTime;
    }

    public void setUserOtpExpiryTime(Date userOtpExpiryTime) {
        this.userOtpExpiryTime = userOtpExpiryTime;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
