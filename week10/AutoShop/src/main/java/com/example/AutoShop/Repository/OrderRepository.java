package com.example.AutoShop.Repository;

import com.example.AutoShop.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order>  findByCustomerID(Optional customerID);
    Order findByOrderIDAndCustomerID (Long orderID, Optional customerID);
    Optional<Order> findAllByCustomerIDAndOrderID(Long id, Optional customerID);
}
