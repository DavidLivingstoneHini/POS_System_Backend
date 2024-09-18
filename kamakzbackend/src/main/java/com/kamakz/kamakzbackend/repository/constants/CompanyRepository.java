package com.kamakz.kamakzbackend.repository.constants;

import com.kamakz.kamakzbackend.model.constants.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    // Find companies by name
    List<Company> findByCompanyName(String companyName);

    // Find companies by address
    List<Company> findByCompanyAddress(String companyAddress);

    // Find companies by email
    List<Company> findByCompanyEmail(String companyEmail);

    // Find companies by telephone
    List<Company> findByCompanyTelephone(String companyTelephone);

    // Find companies by status
    List<Company> findByStatus(String status);

    // Find companies created within a date range
    List<Company> findByDateCreatedBetween(Date startDate, Date endDate);

    // Find companies by country
    List<Company> findByCountry(String country);
}

