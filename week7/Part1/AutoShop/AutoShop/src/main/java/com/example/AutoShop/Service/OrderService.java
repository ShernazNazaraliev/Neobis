package com.example.AutoShop.Service;

import com.example.AutoShop.Entity.Order;
import com.example.AutoShop.Repository.CustomerRepository;
import com.example.AutoShop.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }

    public ResponseEntity<String> addOrder(Order order){
        try {
            orderRepository.save(order);
            return new ResponseEntity<String>("order created!", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("order has not been created!", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> findById(Long id) {
        if (orderRepository.existsById(id)){
            return new ResponseEntity<Optional<Order>>(orderRepository.findById(id), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("order with id "+id+" not found", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> updateOrder(Long id, Order newOrder){
        return orderRepository.findById(id)
                .map(order -> {
                    order.setCustomerId(newOrder.getCustomerId());
                    order.setCarId(newOrder.getCarId());
                    order.setStatus(newOrder.getStatus());
                    order.setActionDate(newOrder.getActionDate());
                    orderRepository.save(order);
                    return new ResponseEntity<String>("order with id "+id+" updated!",HttpStatus.OK);
                }).orElse(new ResponseEntity<String>("order with id "+id+" not found",HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<String> deleteOrder(Long id){
        try {
            orderRepository.deleteById(id);
            return new ResponseEntity<String>("order deleted!", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("order with id "+id+" not found", HttpStatus.BAD_REQUEST);
        }
    }
}
