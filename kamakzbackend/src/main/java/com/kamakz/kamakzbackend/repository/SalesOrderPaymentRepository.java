package com.kamakz.kamakzbackend.repository;
import com.kamakz.kamakzbackend.model.SalesOrder;

import com.kamakz.kamakzbackend.model.SalesOrderPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderPaymentRepository extends JpaRepository<SalesOrderPayment, Long> {
    // Custom queries
    void deleteAllBySalesOrder(SalesOrder salesOrder);
}
