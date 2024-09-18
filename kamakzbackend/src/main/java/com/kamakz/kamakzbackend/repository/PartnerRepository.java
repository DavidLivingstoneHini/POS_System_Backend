package com.kamakz.kamakzbackend.repository;

import com.kamakz.kamakzbackend.model.constants.Company;
import com.kamakz.kamakzbackend.model.constants.Partner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PartnerRepository extends JpaRepository<Partner, Long> {

    @Query("SELECT p FROM Partner p WHERE p.partnerType = :partnerType")
    List<Partner> findByPartnerType(@Param("partnerType") String partnerType);

    List<Partner> findByPartnerTelephoneAndCompany(String customerTelephone, Company company);
}
