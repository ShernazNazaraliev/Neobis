package com.example.AutoShop.Service;

import com.example.AutoShop.Entity.Order;
import com.example.AutoShop.Exceptions.ResourceNotFound;
import com.example.AutoShop.Repository.CustomerRepository;
import com.example.AutoShop.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }


    public List<Order> getAll (){
        return orderRepository.findAll();
    }

    public List<Order> getAllOrderCustomers(Long customerId){
        return orderRepository.findByCustomerID(customerRepository.findById(customerId));
    }

    public Order getOneOrderCustomers (Long customerId, Long id){
        if (!customerRepository.existsById(customerId)){
            throw new ResourceNotFound("Could not find customer with ID ",customerId);
        }
        return orderRepository.findByOrderIDAndCustomerID(id, customerRepository.findById(customerId));
    }

    public Order add (Long customerId, Order order){
        return customerRepository.findById(customerId).map(customer -> {
            order.setCustomerID(customer);
            return orderRepository.save(order);
        }).orElseThrow(() -> new ResourceNotFound("Could not find customer with ID ",customerId));
    }

    public Order update (Order orderUpdate,Long orderId, Long customerId){
        if (!customerRepository.existsById(customerId)){
            throw new ResourceNotFound("Could not find order with ID ", customerId);
        }
        return orderRepository.findById(orderId)
                .map(order -> {
                    order.setCustomerID(orderUpdate.getCustomerID());
                    order.setCarID(orderUpdate.getCarID());
                    return orderRepository.save(order);
                })
                .orElseThrow(() -> new ResourceNotFound("Could not find order with ID ", orderId) );
    }

    public ResponseEntity<?> delete(Long customerId, Long orderId){
        return orderRepository.findAllByCustomerIDAndOrderID(orderId, customerRepository.findById(customerId)).map(order->{
            orderRepository.deleteById(orderId);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFound("Could not find order with ID ", orderId));
    }

}
