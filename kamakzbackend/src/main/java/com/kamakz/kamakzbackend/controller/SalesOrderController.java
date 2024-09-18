package com.kamakz.kamakzbackend.controller;

import com.kamakz.kamakzbackend.model.SalesOrder;
import com.kamakz.kamakzbackend.model.constants.Company;
import com.kamakz.kamakzbackend.service.SalesOrderService;
import com.kamakz.kamakzbackend.service.SalesOrderService.PosOrders;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pos")
public class SalesOrderController {

    @Autowired
    private SalesOrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/my_orders/{staffid}")
    public ResponseEntity<PosOrders> getMyOrders(@PathVariable("staffid") Integer staffId) {
        try {
            String response = orderService.getOrders(staffId);
            PosOrders orders = objectMapper.readValue(response, PosOrders.class);
            return ResponseEntity.ok(orders);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/order_details/{orderId}")
    public ResponseEntity<SalesOrderService.OrderDetailsResponse> getOrderDetails(@PathVariable("orderId") Long orderId) {
        try {
            String response = orderService.getOrderDetails(orderId);
            SalesOrderService.OrderDetailsResponse orderDetails = objectMapper.readValue(response, SalesOrderService.OrderDetailsResponse.class);
            return ResponseEntity.ok(orderDetails);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

        @PostMapping("/save")
        public ResponseEntity<?> saveOrder(@RequestBody Map<String, Object> orderData) {
            return orderService.saveOrder(orderData);
        }

        @PatchMapping("/save/{id}")
        public ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody Map<String, Object> orderData) {
            // Include the orderId in the orderData for the service to recognize it's an update
            orderData.put("orderId", String.valueOf(id));
            return orderService.saveOrder(orderData);
        }

    @DeleteMapping("/delete_order_detail/{detailid}")
    public String deleteOrderDetail(@PathVariable("detailid") Long detailId) {
        return orderService.deleteOrderDetail(detailId);
    }

    @DeleteMapping("/delete_order/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable Long orderId) {
        try {
            // Delegate the deletion process to the service
            orderService.deleteOrder(orderId);

            // Return success response
            return ResponseEntity.ok("Order and associated details deleted successfully.");
        } catch (Exception e) {
            // Log and return the error
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting order: " + e.getMessage());
        }
    }

    @PatchMapping("/update_sales_order/{orderId}")
    public ResponseEntity<SalesOrderService.SalesOrderResponse> updateSalesOrder(
            @PathVariable Long orderId,
            @RequestBody SalesOrder salesOrder) throws Exception {

        SalesOrderService.SalesOrderResponse updatedOrderResponse = orderService.updateSalesOrder(orderId, salesOrder);
        return ResponseEntity.ok(updatedOrderResponse);
    }
}
