package com.kamakz.kamakzbackend.repository.constants;

import com.kamakz.kamakzbackend.model.constants.InventoryCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryCategoryRepository extends JpaRepository<InventoryCategory, Integer> {

    Optional<InventoryCategory> findByCategoryName(String categoryName);
}

