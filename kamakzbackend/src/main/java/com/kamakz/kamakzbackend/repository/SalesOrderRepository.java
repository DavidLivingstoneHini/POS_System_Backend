package com.kamakz.kamakzbackend.repository;

import com.kamakz.kamakzbackend.model.constants.Company;
import com.kamakz.kamakzbackend.model.SalesOrder;
import com.kamakz.kamakzbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {
    List<SalesOrder> findByCompanyAndInProgressforPOS(Company company, boolean inProgressforPOS);
    List<SalesOrder> findByCompanyAndCreatorAndInProgressforPOS(Company company, User creator, boolean inProgressforPOS);
    Optional<SalesOrder> findById(Long orderId);

    // Check if an order exists by its ID
    boolean existsById(Long id);

    // Method to find the maximum order ID
    @Query("SELECT COALESCE(MAX(o.id), 0) FROM SalesOrder o")
    Long findMaxOrderId();
}
