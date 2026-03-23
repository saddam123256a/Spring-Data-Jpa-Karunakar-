package com.jpa.repository;

import com.jpa.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Order findByOrderTrackingNumber(String orderTrackingNumber);
}
