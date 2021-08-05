package com.example.AutoShop.Controller;

import com.example.AutoShop.Entity.Order;
import com.example.AutoShop.Exceptions.ResourceNotFound;
import com.example.AutoShop.Repository.CustomerRepository;
import com.example.AutoShop.Repository.OrderRepository;
import com.example.AutoShop.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getAllOrderCustomers(@PathVariable Long cutomerId){
        return orderService.getAllOrderCustomers(cutomerId);
    }

    @GetMapping("/customer/{customerId}/oder/{orderId}")
    public Order getOneOrderCustomers(@PathVariable Long customerId, @PathVariable  Long orderId){
        return orderService.getOneOrderCustomers(customerId,orderId);
    }

    @PostMapping("/customer/{customerId}")
    public Order add(@PathVariable Long customerId, @RequestBody Order order){
        return orderService.add(customerId,order);
    }

    @PutMapping("/customer/{customerId}/order/{orderId}")
    public Order update (@PathVariable Long customerId,@PathVariable Long orderId, @RequestBody Order order){
        return orderService.update(order,orderId,customerId);
    }


    @DeleteMapping("/customer/{customerId}/order/{orderId}")
    public ResponseEntity<?> delete(@PathVariable Long customerId,@PathVariable Long orderID){
        return orderService.delete(customerId,orderID);
    }
}
