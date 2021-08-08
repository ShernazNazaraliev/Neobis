package com.example.AutoShop.Repository;

import com.example.AutoShop.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
