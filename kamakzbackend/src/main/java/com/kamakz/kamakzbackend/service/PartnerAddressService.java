package com.kamakz.kamakzbackend.service;

import com.kamakz.kamakzbackend.model.constants.PartnerAddress;
import com.kamakz.kamakzbackend.repository.PartnerAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PartnerAddressService {

    @Autowired
    private PartnerAddressRepository partnerAddressRepository;

    public List<PartnerAddressDTO> getAddressesByPartnerId(Long partnerId) {
        List<PartnerAddress> addresses = partnerAddressRepository.findByPartnerId(partnerId);
        return addresses.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PartnerAddress saveAddress(PartnerAddress partnerAddress) {
        return partnerAddressRepository.save(partnerAddress);
    }

    // Method to convert PartnerAddress to PartnerAddressDTO
    private PartnerAddressDTO convertToDTO(PartnerAddress partnerAddress) {
        PartnerAddressDTO dto = new PartnerAddressDTO();
        dto.setId(partnerAddress.getId()); // Set the ID
        dto.setAddress1(partnerAddress.getAddress1());
        dto.setAddress2(partnerAddress.getAddress2());
        dto.setCity(partnerAddress.getCity());
        dto.setCountry(partnerAddress.getCountry());
        dto.setContactPerson(partnerAddress.getContactPerson());
        dto.setTelephone(partnerAddress.getTelephone());
        return dto;
    }

    // Static inner class for PartnerAddressDTO
    public static class PartnerAddressDTO {
        private Long id; // Add ID field
        private String address1;
        private String address2;
        private String city;
        private String country;
        private String contactPerson;
        private String telephone;

        // Getters and Setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getAddress2() {
            return address2;
        }

        public void setAddress2(String address2) {
            this.address2 = address2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getContactPerson() {
            return contactPerson;
        }

        public void setContactPerson(String contactPerson) {
            this.contactPerson = contactPerson;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }
    }
}
