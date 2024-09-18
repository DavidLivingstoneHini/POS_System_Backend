package com.kamakz.kamakzbackend.repository;

import com.kamakz.kamakzbackend.model.constants.PartnerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PartnerAddressRepository extends JpaRepository<PartnerAddress, Long> {
    List<PartnerAddress> findByPartnerId(Long partnerId);
}
