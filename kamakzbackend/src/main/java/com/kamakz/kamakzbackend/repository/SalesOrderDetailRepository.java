package com.kamakz.kamakzbackend.repository;

import com.kamakz.kamakzbackend.model.SalesOrder;
import com.kamakz.kamakzbackend.model.SalesOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesOrderDetailRepository extends JpaRepository<SalesOrderDetail, Long> {
    List<SalesOrderDetail> findBySalesOrder(SalesOrder salesOrder);
    void deleteAllBySalesOrder(SalesOrder salesOrder);
}
