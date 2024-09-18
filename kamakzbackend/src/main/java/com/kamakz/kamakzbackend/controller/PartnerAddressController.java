package com.kamakz.kamakzbackend.controller;

import com.kamakz.kamakzbackend.model.constants.PartnerAddress;
import com.kamakz.kamakzbackend.service.PartnerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partner-addresses")
public class PartnerAddressController {

    @Autowired
    private PartnerAddressService partnerAddressService;

    // Get addresses by partner ID
    @GetMapping("/partner/{partnerId}")
    public ResponseEntity<List<PartnerAddressService.PartnerAddressDTO>> getAddressesByPartnerId(@PathVariable Long partnerId) {
        List<PartnerAddressService.PartnerAddressDTO> addresses = partnerAddressService.getAddressesByPartnerId(partnerId);
        return ResponseEntity.ok(addresses);
    }

    // Save a new partner address
    @PostMapping
    public ResponseEntity<PartnerAddress> createAddress(@RequestBody PartnerAddress partnerAddress) {
        PartnerAddress savedAddress = partnerAddressService.saveAddress(partnerAddress);
        return ResponseEntity.ok(savedAddress);
    }
}