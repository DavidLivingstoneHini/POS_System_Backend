package com.kamakz.kamakzbackend.repository;

import com.kamakz.kamakzbackend.model.Inventory;
import com.kamakz.kamakzbackend.model.constants.Company;
import com.kamakz.kamakzbackend.model.constants.InventoryCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    // Query for retrieving all inventories available on POS for a company
    @Query("SELECT i FROM Inventory i WHERE i.company = :company AND i.availableOnPOS = :availableOnPOS ORDER BY i.productName")
    List<Inventory> findByCompanyAndAvailableOnPOS(@Param("company") Company company, @Param("availableOnPOS") boolean availableOnPOS);

    // Query for retrieving inventories available on POS for a company with a specific category
    @Query("SELECT i FROM Inventory i WHERE i.company = :company AND i.availableOnPOS = :availableOnPOS AND i.category = :category ORDER BY i.productName")
    List<Inventory> findByCompanyAndAvailableOnPOSAndCategory(@Param("company") Company company, @Param("availableOnPOS") boolean availableOnPOS, @Param("category") InventoryCategory category);

    // Query for retrieving inventories available on POS for a company with a specific barcode
    @Query("SELECT i FROM Inventory i WHERE i.company = :company AND i.availableOnPOS = :availableOnPOS AND i.barCode = :barCode ORDER BY i.productName")
    List<Inventory> findByCompanyAndAvailableOnPOSAndBarCode(@Param("company") Company company, @Param("availableOnPOS") boolean availableOnPOS, @Param("barCode") String barCode);
}
