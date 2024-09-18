package com.kamakz.kamakzbackend.controller;

import com.kamakz.kamakzbackend.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/pos")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/my_inventories/{companyid}/{criteria}")
    public ResponseEntity<Map<String, Object>> getMyInventories(
            @PathVariable("companyid") String companyId,
            @PathVariable("criteria") String criteria) {
        Map<String, Object> response = inventoryService.getInventoriesByCriteria(companyId, criteria);

        int status = (int) response.get("status");
        if (status == 1) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
