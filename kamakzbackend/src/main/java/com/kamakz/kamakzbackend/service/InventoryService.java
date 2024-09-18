package com.kamakz.kamakzbackend.service;

import com.kamakz.kamakzbackend.model.Inventory;
import com.kamakz.kamakzbackend.model.constants.Company;
import com.kamakz.kamakzbackend.model.constants.InventoryCategory;
import com.kamakz.kamakzbackend.repository.InventoryRepository;
import com.kamakz.kamakzbackend.repository.constants.CompanyRepository;
import com.kamakz.kamakzbackend.repository.constants.InventoryCategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private InventoryCategoryRepository inventoryCategoryRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public Map<String, Object> getInventoriesByCriteria(String companyId, String criteria) {
        Map<String, Object> response = new HashMap<>();
        try {
            Company company = companyRepository.findById(Integer.parseInt(companyId))
                    .orElseThrow(() -> new RuntimeException("Company not found"));

            List<Inventory> inventories;
            switch (criteria) {
                case "All":
                    inventories = inventoryRepository.findByCompanyAndAvailableOnPOS(company, true);
                    break;
                case "Category":
                    // Fetch the InventoryCategory based on the category name (assuming criteria is the category name)
                    InventoryCategory category = inventoryCategoryRepository.findByCategoryName(criteria)
                            .orElseThrow(() -> new RuntimeException("Category not found"));
                    inventories = inventoryRepository.findByCompanyAndAvailableOnPOSAndCategory(company, true, category);
                    break;
                case "BarCode":
                    inventories = inventoryRepository.findByCompanyAndAvailableOnPOSAndBarCode(company, true, criteria);
                    break;
                default:
                    inventories = Collections.emptyList();
            }

            List<Map<String, Object>> posInventories = inventories.stream()
                    .map(inv -> {
                        Map<String, Object> posInv = new HashMap<>();
                        posInv.put("productId", inv.getId());
                        posInv.put("productName", inv.getProductName());
                        posInv.put("sellingPriceActual", inv.getSellingPriceActual());
                        posInv.put("barCode", inv.getBarCode());
                        posInv.put("applyProductLevelDiscount", inv.getApplyProductLevelDiscount());
                        posInv.put("discount", inv.getDiscount());

                        String imagePath = "/images/hr/" + inv.getCompany().getCompanyCode().toLowerCase() + "/";
                        imagePath += (inv.getDefaultImagePath() != null ? inv.getDefaultImagePath() : "");
                        posInv.put("defaultImagePath", imagePath);

                        return posInv;
                    })
                    .collect(Collectors.toList());

            response.put("status", inventories.isEmpty() ? 0 : 1);
            response.put("message", inventories.isEmpty() ? "No Items" : "Success");
            response.put("posInventories", posInventories);

        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", 0);
            response.put("message", "Error: " + e.getMessage());
        }

        return response;
    }
}
