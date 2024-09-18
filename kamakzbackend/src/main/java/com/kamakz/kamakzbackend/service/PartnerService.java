package com.kamakz.kamakzbackend.service;

import com.kamakz.kamakzbackend.model.constants.Partner;
import com.kamakz.kamakzbackend.repository.PartnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerService {
    @Autowired
    private PartnerRepository partnerRepository;

    // Inner DTO class
    public static class PartnerDTO {
        private Long id;
        private String fullName;
        private String partnerType;
        private String barCode;
        private String email;
        private String partnerTelephone;
        private Double salesDiscount;

        // Constructor
        public PartnerDTO(Long id, String fullName, String partnerType, String barCode, String email, String partnerTelephone, Double salesDiscount) {
            this.id = id; // Accept Long directly
            this.fullName = fullName;
            this.partnerType = partnerType;
            this.barCode = barCode;
            this.email = email;
            this.partnerTelephone = partnerTelephone;
            this.salesDiscount = salesDiscount; // Initialize discount
        }

        // Getters
        public Long getId() {
            return id;
        }

        public String getFullName() {
            return fullName;
        }

        public String getPartnerType() {
            return partnerType;
        }

        public String getBarCode() {
            return barCode;
        }

        public String getEmail() {
            return email;
        }

        public String getPartnerTelephone() {
            return partnerTelephone;
        }

        public Double getSalesDiscount() {
            return salesDiscount; // Return discount
        }
    }

    public List<PartnerDTO> getAllCustomers() {
        List<Partner> partners = partnerRepository.findByPartnerType("Customer");
        return partners.stream()
                .map(partner -> new PartnerDTO(
                        partner.getId(),
                        partner.getFullName(),
                        partner.getPartnerType(),
                        partner.getBarCode(),
                        partner.getEmail(),
                        partner.getPartnerTelephone(),
                        partner.getSalesDiscount() // Assuming discount exists in Partner
                ))
                .collect(Collectors.toList());
    }

    public List<PartnerDTO> getAllAgents() {
        List<Partner> partners = partnerRepository.findByPartnerType("Agent");
        return partners.stream()
                .map(partner -> new PartnerDTO(
                        partner.getId(),
                        partner.getFullName(),
                        partner.getPartnerType(),
                        partner.getBarCode(),
                        partner.getEmail(),
                        partner.getPartnerTelephone(),
                        partner.getSalesDiscount()
                ))
                .collect(Collectors.toList());
    }

    // PATCH method to update specific fields
    @Transactional
    public PartnerDTO updatePartner(Long id, PartnerDTO partnerDTO) {
        Partner partner = partnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Partner not found"));

        if (partnerDTO.getPartnerTelephone() != null) {
            partner.setPartnerTelephone(partnerDTO.getPartnerTelephone());
        }
        if (partnerDTO.getBarCode() != null) {
            partner.setBarCode(partnerDTO.getBarCode());
        }
        if (partnerDTO.getSalesDiscount() != null) { // Use the correct getter
            partner.setSalesDiscount(partnerDTO.getSalesDiscount()); // Update discount if provided
        }

        partnerRepository.save(partner); // Save updated partner

        return new PartnerDTO(
                partner.getId(),
                partner.getFullName(),
                partner.getPartnerType(),
                partner.getBarCode(),
                partner.getEmail(),
                partner.getPartnerTelephone(),
                partner.getSalesDiscount() // Return updated discount
        );
    }
}
