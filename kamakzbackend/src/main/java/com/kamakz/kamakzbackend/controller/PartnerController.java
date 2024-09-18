package com.kamakz.kamakzbackend.controller;

import com.kamakz.kamakzbackend.service.PartnerService;
import com.kamakz.kamakzbackend.service.PartnerService.PartnerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partners")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    // Get all customers
    @GetMapping("/customers")
    public ResponseEntity<List<PartnerDTO>> getAllCustomers() {
        List<PartnerDTO> partners = partnerService.getAllCustomers();
        return ResponseEntity.ok(partners);
    }

    // Get all agents
    @GetMapping("/agents")
    public ResponseEntity<List<PartnerDTO>> getAllAgents() {
        List<PartnerDTO> partners = partnerService.getAllAgents();
        return ResponseEntity.ok(partners);
    }

    // Update partner details
    @PutMapping("/{id}")
    public ResponseEntity<PartnerDTO> updatePartner(@PathVariable Long id, @RequestBody PartnerDTO partnerDTO) {
        PartnerDTO updatedPartner = partnerService.updatePartner(id, partnerDTO);
        return ResponseEntity.ok(updatedPartner);
    }
}
