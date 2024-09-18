package com.kamakz.kamakzbackend.model.constants;


import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Date;

import com.kamakz.kamakzbackend.controller.constants.BloodGroup;
import com.kamakz.kamakzbackend.controller.constants.EmployeeStatus;
import com.kamakz.kamakzbackend.controller.constants.SalaryType;
import com.kamakz.kamakzbackend.model.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 *
 * @author Jboss
 */
@Entity
@Table(name = "company_employee")
@NamedQueries({
        @NamedQuery(name = CompanyEmployee.FIND_EMPLOYEES_BY_GRADE, query = "Select c from CompanyEmployee c where c.jobGrade=:grade"),
        @NamedQuery(name = CompanyEmployee.FIND_EMPLOYEES_BY_ROLE, query = "Select c from CompanyEmployee c where c.jobRole=:role"),
        @NamedQuery(name = CompanyEmployee.FIND_BY_SUPERVISOR, query = "Select c from CompanyEmployee c where c.supervisor=:supervisor"),
        @NamedQuery(name = CompanyEmployee.FIND_BY_EMPLOYEE_NUMBER, query = "Select c from CompanyEmployee c where c.employeeNumber=:number") })
public class CompanyEmployee extends Model {

    public static final String FIND_EMPLOYEES_BY_GRADE = "CompanyEmployee.FIND_EMPLOYEES_BY_GRADE";
    public static final String FIND_EMPLOYEES_BY_ROLE = "CompanyEmployee.FIND_EMPLOYEES_BY_ROLE";
    public static final String FIND_BY_EMPLOYEE_NUMBER = "CompanyEmployee.FIND_BY_EMPLOYEE_NUMBER";
    public static final String FIND_BY_SUPERVISOR = "CompanyEmployee.FIND_BY_SUPERVISOR";

    private static final long serialVersionUID = 1125184244367265216L;

    @ManyToOne(optional=true)
    private CompanyEmployee supervisor;
    @ManyToOne
    private Company company;
    @ManyToOne
    private Branch branch;
    @ManyToOne
    private Businesssegment businesssegment;
    @ManyToOne
    private Businesssegmentunit businesssegmentunit;
    @ManyToOne
    private JobGrade jobGrade;
    @ManyToOne
    private JobRole jobRole;
    @ManyToOne
    private JobDesignation jobDesignation;
    @ManyToOne
    private District district;
    @ManyToOne(optional = true)
    private EducationLevel educationLevel;
    private String title;
    private String surname;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "other_name")
    private String otherName;

    private String birthPlace;
    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
    @Temporal(jakarta.persistence.TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "nationality")
    private String nationality = "Ghanaian";

    private String spouseName;
    private String fatherName;
    private String motherName;

    @Column(columnDefinition = "TEXT", name = "first_address")
    private String firstAddress;

    @Column(columnDefinition = "TEXT", name = "second_address")
    private String secondAddress;

    private String city;
    private String region;
    private String country;
    private String zipCode;

    private String workPhone;
    private String homePhone;

    @Column(name = "work_email_address")
    private String workEmailAddress;
    @Column(name = "personal_email_address")
    private String personalEmailAddress;

    private String nationalId;
    private String otherIdType;
    private String otherIdNumber;
    private String passportNumber;

    private String picture;
    private String ghanaCardNumber ="";

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_group")
    private BloodGroup bloodGroup;

    private String religion;

    @Column(unique = true)
    private String employeeNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_joined")
    private Date dateJoined;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_confirmed")
    private Date dateConfirmed;

    private String reportTo;

    private String ssfNumber;
    private String tiierTwoNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_left")
    private Date dateLeft;

    private String designationReason;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status = EmployeeStatus.ACTIVE;

    @Enumerated(EnumType.STRING)
    @Column(name = "salary_type")
    private SalaryType salaryType;

    @Temporal(TemporalType.DATE)
    @Column(name = "salary_applicable_date")
    private Date salaryApplicableDate;

    private Integer hoursWorked = 0;
    private Double ratePerHour = 0.0;

    private Double grossSalary = 0.0;
    private Double totalDeductions = 0.0;
    private Double taxableIncome = 0.0;
    private Double pennsionableIncome = 0.0;
    private Double totalOtherIncome = 0.0;
    private Double totalOtherDeductions = 0.0;
    private Double taxRelief = 0.0;
    private Double netSalary = 0.0;
    private Double totalUniqueIncome = 0.0;
    private Double totalIncomeLines = 0.0;
    private Double totalDeductibleLines = 0.0;
    private Double basicSalary = 0.0;
    private Double totalExpensesReimbursement = 0.0;
    private Double totalOverTimePayments = 0.0;
    private Double totalBonusPayments = 0.0;
    private Double totalSpecialpayments = 0.0;
    private Double totalUpfrontDeductions = 0.0;
    private Double totalEmployeeSsDeductions = 0.0;

    private Double totalLoans = 0.0;
    private Double totalLoanInstallments = 0.0;
    private Double totalLoanBalance = 0.0;

    private Integer priorYearLeaveDays = 0;
    private Integer thisYearLeaveDays = 0;
    private Integer totalLeaveDays = 0;
    private Integer leaveTaken = 0;
    private Integer leaveDaysBalance = 0;

    private Double priorBasic = 0.0;
    private Double priorGlassSalary = 0.0;
    private Double priorTotalDeductions = 0.0;
    private Double priorNetPay = 0.0;
    private String contractor;

    private Boolean confirmned;

    @Temporal(TemporalType.DATE)
    private Date confirmationDate;

    private Boolean resigned = false;

    private String levelOfSupervision;

    @ManyToOne(optional=true)
    private CompanyEmployee firstLevelSupervisor;
    @ManyToOne(optional=true)
    private CompanyEmployee secondlevelSupervisor;

    private Double incomeTax = 0.0;
    private Double employeeTierOne = 0.0;
    private Double employerTierOne = 0.0;
    private Double employeeTierTwo = 0.0;
    private Double employerTierTwo = 0.0;
    private Double employeepf = 0.0;
    private Double employerPf = 0.0;
    private Double employeeOtherTierThree = 0.0;
    private Double employerOtherTierThree = 0.0;
    private Double employeeOtherContribution = 0.0;
    private Double employerOtherContribution = 0.0;
    private Double totalSavingsDeductions = 0.0;
    private Double totalLoanDeductions = 0.0;
    private String bankName;
    private String bankBranch;
    private String bankAccount;
    private Integer savingsCount = 0;
    private Double taxAllowance = 0.0;
    private Double ssfAllowance = 0.0;
    private Double totalPF = 0.0;
    private String closed = "No";
    private String groupings = "Group1";
    private Double bonusTaxRate = 0.0;

    private String searchCode;
    private String educationLevelName;


    private Double internalSavingsDeductions = 0.0;
    private Double internalLoansDeductions = 0.0;
    private Boolean wageWorker = false;
    private UnitOfTime unitOfTime = UnitOfTime.NONE;
    private Double costPerTimeUnit = 0.0;

    private String filePath;


    @Column(columnDefinition = "TEXT", name = "resignation_reason")
    private String resignationReason;

    public CompanyEmployee() {
    }

    public int getAge() {
        if (birthDate == null) {
            return 0;
        }
        LocalDate birthdate = LocalDate.of(birthDate.getYear() + 1900, Month.of(birthDate.getMonth() + 1), birthDate.getDate());
        Period period = Period.between(birthdate, LocalDate.now());
        return period.getYears();
    }

    public String getResignationReason() {
        return resignationReason;
    }

    public void setResignationReason(String resignationReason) {
        this.resignationReason = resignationReason;
    }

    public String getGhanaCardNumber() {
        return ghanaCardNumber;
    }

    public void setGhanaCardNumber(String ghanaCardNumber) {
        this.ghanaCardNumber = ghanaCardNumber;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Businesssegment getBusinesssegment() {
        return businesssegment;
    }

    public void setBusinesssegment(Businesssegment businesssegment) {
        this.businesssegment = businesssegment;
    }

    public Businesssegmentunit getBusinesssegmentunit() {
        return businesssegmentunit;
    }

    public void setBusinesssegmentunit(Businesssegmentunit businesssegmentunit) {
        this.businesssegmentunit = businesssegmentunit;
    }

    public JobGrade getJobGrade() {
        return jobGrade;
    }

    public void setJobGrade(JobGrade jobGrade) {
        this.jobGrade = jobGrade;
    }

    public JobDesignation getJobDesignation() {
        return jobDesignation;
    }

    public void setJobDesignation(JobDesignation jobDesignation) {
        this.jobDesignation = jobDesignation;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getOtherName() {
        return otherName;
    }

    public String getFullName() {
        return getTitle() + " " + getSurname() + " " + getFirstName() + " " + getOtherName();
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkEmailAddress() {
        return workEmailAddress;
    }

    public void setWorkEmailAddress(String workEmailAddress) {
        this.workEmailAddress = workEmailAddress;
    }

    public String getPersonalEmailAddress() {
        return personalEmailAddress;
    }

    public void setPersonalEmailAddress(String personalEmailAddress) {
        this.personalEmailAddress = personalEmailAddress;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getOtherIdType() {
        return otherIdType;
    }

    public void setOtherIdType(String otherIdType) {
        this.otherIdType = otherIdType;
    }

    public String getOtherIdNumber() {
        return otherIdNumber;
    }

    public void setOtherIdNumber(String otherIdNumber) {
        this.otherIdNumber = otherIdNumber;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Date getDateConfirmed() {
        return dateConfirmed;
    }

    public void setDateConfirmed(Date dateConfirmed) {
        this.dateConfirmed = dateConfirmed;
    }

    public String getReportTo() {
        return reportTo;
    }

    public void setReportTo(String reportTo) {
        this.reportTo = reportTo;
    }

    public String getSsfNumber() {
        return ssfNumber;
    }

    public void setSsfNumber(String ssfNumber) {
        this.ssfNumber = ssfNumber;
    }

    public String getTiierTwoNumber() {
        return tiierTwoNumber;
    }

    public void setTiierTwoNumber(String tiierTwoNumber) {
        this.tiierTwoNumber = tiierTwoNumber;
    }

    public Date getDateLeft() {
        return dateLeft;
    }

    public void setDateLeft(Date dateLeft) {
        this.dateLeft = dateLeft;
    }

    public String getDesignationReason() {
        return designationReason;
    }

    public void setDesignationReason(String designationReason) {
        this.designationReason = designationReason;
    }

    public SalaryType getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(SalaryType salaryType) {
        this.salaryType = salaryType;
    }

    public Date getSalaryApplicableDate() {
        return salaryApplicableDate;
    }

    public void setSalaryApplicableDate(Date salaryApplicableDate) {
        this.salaryApplicableDate = salaryApplicableDate;
    }

    public Integer getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(Integer hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public Double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(Double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public Double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(Double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public Double getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(Double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public Double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(Double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public Double getPennsionableIncome() {
        return pennsionableIncome;
    }

    public void setPennsionableIncome(Double pennsionableIncome) {
        this.pennsionableIncome = pennsionableIncome;
    }

    public Double getTotalOtherIncome() {
        return totalOtherIncome;
    }

    public void setTotalOtherIncome(Double totalOtherIncome) {
        this.totalOtherIncome = totalOtherIncome;
    }

    public Double getTotalOtherDeductions() {
        return totalOtherDeductions;
    }

    public void setTotalOtherDeductions(Double totalOtherDeductions) {
        this.totalOtherDeductions = totalOtherDeductions;
    }

    public Double getTaxRelief() {
        return taxRelief;
    }

    public void setTaxRelief(Double taxRelief) {
        this.taxRelief = taxRelief;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }

    public JobRole getJobRole() {
        return jobRole;
    }

    public void setJobRole(JobRole jobRole) {
        this.jobRole = jobRole;
    }

    public Boolean getResigned() {
        return resigned;
    }

    public void setResigned(Boolean resigned) {
        this.resigned = resigned;
    }

    public Boolean getConfirmned() {
        return confirmned;
    }

    public void setConfirmned(Boolean confirmned) {
        this.confirmned = confirmned;
    }

    public Date getConfirmationDate() {
        return confirmationDate;
    }

    public void setConfirmationDate(Date confirmationDate) {
        this.confirmationDate = confirmationDate;
    }

    public Double getTotalUniqueIncome() {
        return totalUniqueIncome;
    }

    public void setTotalUniqueIncome(Double totalUniqueIncome) {
        this.totalUniqueIncome = totalUniqueIncome;
    }

    public String getLevelOfSupervision() {
        return levelOfSupervision;
    }

    public void setLevelOfSupervision(String levelOfSupervision) {
        this.levelOfSupervision = levelOfSupervision;
    }

    public CompanyEmployee getFirstLevelSupervisor() {
        return firstLevelSupervisor;
    }

    public void setFirstLevelSupervisor(CompanyEmployee firstLevelSupervisor) {
        this.firstLevelSupervisor = firstLevelSupervisor;
    }

    public CompanyEmployee getSecondlevelSupervisor() {
        return secondlevelSupervisor;
    }

    public void setSecondlevelSupervisor(CompanyEmployee secondlevelSupervisor) {
        this.secondlevelSupervisor = secondlevelSupervisor;
    }



    public Double getTotalIncomeLines() {
        return totalIncomeLines;
    }

    public void setTotalIncomeLines(Double totalIncomeLines) {
        this.totalIncomeLines = totalIncomeLines;
    }

    public Double getTotalDeductibleLines() {
        return totalDeductibleLines;
    }

    public void setTotalDeductibleLines(Double totalDeductibleLines) {
        this.totalDeductibleLines = totalDeductibleLines;
    }

    public Double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(Double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public Double getEmployeeTierOne() {
        return employeeTierOne;
    }

    public void setEmployeeTierOne(Double employeeTierOne) {
        this.employeeTierOne = employeeTierOne;
    }

    public Double getEmployerTierOne() {
        return employerTierOne;
    }

    public void setEmployerTierOne(Double employerTierOne) {
        this.employerTierOne = employerTierOne;
    }

    public Double getEmployeeTierTwo() {
        return employeeTierTwo;
    }

    public void setEmployeeTierTwo(Double employeeTierTwo) {
        this.employeeTierTwo = employeeTierTwo;
    }

    public Double getEmployerTierTwo() {
        return employerTierTwo;
    }

    public void setEmployerTierTwo(Double employerTierTwo) {
        this.employerTierTwo = employerTierTwo;
    }

    public Double getEmployeepf() {
        return employeepf;
    }

    public void setEmployeepf(Double employeepf) {
        this.employeepf = employeepf;
    }

    public Double getEmployerPf() {
        return employerPf;
    }

    public void setEmployerPf(Double employerPf) {
        this.employerPf = employerPf;
    }

    public Double getEmployeeOtherTierThree() {
        return employeeOtherTierThree;
    }

    public void setEmployeeOtherTierThree(Double employeeOtherTierThree) {
        this.employeeOtherTierThree = employeeOtherTierThree;
    }

    public Double getEmployerOtherTierThree() {
        return employerOtherTierThree;
    }

    public void setEmployerOtherTierThree(Double employerOtherTierThree) {
        this.employerOtherTierThree = employerOtherTierThree;
    }

    public Double getEmployeeOtherContribution() {
        return employeeOtherContribution;
    }

    public void setEmployeeOtherContribution(Double employeeOtherContribution) {
        this.employeeOtherContribution = employeeOtherContribution;
    }

    public Double getEmployerOtherContribution() {
        return employerOtherContribution;
    }

    public void setEmployerOtherContribution(Double employerOtherContribution) {
        this.employerOtherContribution = employerOtherContribution;
    }

    public Double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(Double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public Double getTotalExpensesReimbursement() {
        return totalExpensesReimbursement;
    }

    public void setTotalExpensesReimbursement(Double totalExpensesReimbursement) {
        this.totalExpensesReimbursement = totalExpensesReimbursement;
    }

    public Double getTotalOverTimePayments() {
        return totalOverTimePayments;
    }

    public void setTotalOverTimePayments(Double totalOverTimePayments) {
        this.totalOverTimePayments = totalOverTimePayments;
    }

    public Double getTotalBonusPayments() {
        return totalBonusPayments;
    }

    public void setTotalBonusPayments(Double totalBonusPayments) {
        this.totalBonusPayments = totalBonusPayments;
    }

    public Double getTotalSpecialpayments() {
        return totalSpecialpayments;
    }

    public void setTotalSpecialpayments(Double totalSpecialpayments) {
        this.totalSpecialpayments = totalSpecialpayments;
    }

    public Double getTotalUpfrontDeductions() {
        return totalUpfrontDeductions;
    }

    public void setTotalUpfrontDeductions(Double totalUpfrontDeductions) {
        this.totalUpfrontDeductions = totalUpfrontDeductions;
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

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Double getTotalEmployeeSsDeductions() {
        return totalEmployeeSsDeductions;
    }

    public void setTotalEmployeeSsDeductions(Double totalEmployeeSsDeductions) {
        this.totalEmployeeSsDeductions = totalEmployeeSsDeductions;
    }

    public Double getTotalSavingsDeductions() {
        return totalSavingsDeductions;
    }

    public void setTotalSavingsDeductions(Double totalSavingsDeductions) {
        this.totalSavingsDeductions = totalSavingsDeductions;
    }

    public Integer getSavingsCount() {
        return savingsCount;
    }

    public void setSavingsCount(Integer savingsCount) {
        this.savingsCount = savingsCount;
    }

    public Integer getPriorYearLeaveDays() {
        return priorYearLeaveDays;
    }

    public void setPriorYearLeaveDays(Integer priorYearLeaveDays) {
        this.priorYearLeaveDays = priorYearLeaveDays;
    }

    public Integer getThisYearLeaveDays() {
        return thisYearLeaveDays;
    }

    public void setThisYearLeaveDays(Integer thisYearLeaveDays) {
        this.thisYearLeaveDays = thisYearLeaveDays;
    }

    public Integer getTotalLeaveDays() {
        return totalLeaveDays;
    }

    public void setTotalLeaveDays(Integer totalLeaveDays) {
        this.totalLeaveDays = totalLeaveDays;
    }

    public Integer getLeaveTaken() {
        return leaveTaken;
    }

    public void setLeaveTaken(Integer leaveTaken) {
        this.leaveTaken = leaveTaken;
    }

    public Integer getLeaveDaysBalance() {
        return leaveDaysBalance;
    }

    public void setLeaveDaysBalance(Integer leaveDaysBalance) {
        this.leaveDaysBalance = leaveDaysBalance;
    }

    public CompanyEmployee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(CompanyEmployee supervisor) {
        this.supervisor = supervisor;
    }

    public Double getTotalLoanBalance() {
        return totalLoanBalance;
    }

    public void setTotalLoanBalance(Double totalLoanBalance) {
        this.totalLoanBalance = totalLoanBalance;
    }

    public Double getTotalLoans() {
        return totalLoans;
    }

    public void setTotalLoans(Double totalLoans) {
        this.totalLoans = totalLoans;
    }

    public Double getTotalLoanInstallments() {
        return totalLoanInstallments;
    }

    public void setTotalLoanInstallments(Double totalLoanInstallments) {
        this.totalLoanInstallments = totalLoanInstallments;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Double getPriorBasic() {
        return priorBasic;
    }

    public void setPriorBasic(Double priorBasic) {
        this.priorBasic = priorBasic;
    }

    public Double getPriorGlassSalary() {
        return priorGlassSalary;
    }

    public void setPriorGlassSalary(Double priorGlassSalary) {
        this.priorGlassSalary = priorGlassSalary;
    }

    public Double getPriorTotalDeductions() {
        return priorTotalDeductions;
    }

    public void setPriorTotalDeductions(Double priorTotalDeductions) {
        this.priorTotalDeductions = priorTotalDeductions;
    }

    public Double getPriorNetPay() {
        return priorNetPay;
    }

    public void setPriorNetPay(Double priorNetPay) {
        this.priorNetPay = priorNetPay;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public Double getTotalLoanDeductions() {
        return totalLoanDeductions;
    }

    public void setTotalLoanDeductions(Double totalLoanDeductions) {
        this.totalLoanDeductions = totalLoanDeductions;
    }

    public Double getTaxAllowance() {
        return taxAllowance;
    }

    public void setTaxAllowance(Double taxAllowance) {
        this.taxAllowance = taxAllowance;
    }

    public Double getSsfAllowance() {
        return ssfAllowance;
    }

    public void setSsfAllowance(Double ssfAllowance) {
        this.ssfAllowance = ssfAllowance;
    }

    public Double getTotalPF() {
        return totalPF;
    }

    public void setTotalPF(Double totalPF) {
        this.totalPF = totalPF;
    }

    public String getClosed() {
        return closed;
    }

    public void setClosed(String closed) {
        this.closed = closed;
    }

    public String getSearchCode() {
        return searchCode;
    }

    public void setSearchCode(String searchCode) {
        this.searchCode = searchCode;
    }

    public String getGroupings() {
        return groupings;
    }

    public void setGroupings(String groupings) {
        this.groupings = groupings;
    }

    public Double getBonusTaxRate() {
        return bonusTaxRate;
    }

    public void setBonusTaxRate(Double bonusTaxRate) {
        this.bonusTaxRate = bonusTaxRate;
    }

    public String getEducationLevelName() {
        return educationLevelName;
    }

    public void setEducationLevelName(String educationLevelName) {
        this.educationLevelName = educationLevelName;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    public Double getInternalSavingsDeductions() {
        return internalSavingsDeductions;
    }

    public void setInternalSavingsDeductions(Double internalSavingsDeductions) {
        this.internalSavingsDeductions = internalSavingsDeductions;
    }

    public Double getInternalLoansDeductions() {
        return internalLoansDeductions;
    }

    public void setInternalLoansDeductions(Double internalLoansDeductions) {
        this.internalLoansDeductions = internalLoansDeductions;
    }

    public Boolean getWageWorker() {
        return wageWorker;
    }

    public void setWageWorker(Boolean wageWorker) {
        this.wageWorker = wageWorker;
    }

    public UnitOfTime getUnitOfTime() {
        return unitOfTime;
    }

    public void setUnitOfTime(UnitOfTime unitOfTime) {
        this.unitOfTime = unitOfTime;
    }

    public Double getCostPerTimeUnit() {
        return costPerTimeUnit;
    }

    public void setCostPerTimeUnit(Double costPerTimeUnit) {
        this.costPerTimeUnit = costPerTimeUnit;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }


}
