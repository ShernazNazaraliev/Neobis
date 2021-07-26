package com.example.AutoShop.Controller;

import com.example.AutoShop.Entity.CarType;
import com.example.AutoShop.Entity.Customer;
import com.example.AutoShop.Exceptions.ResourceNotFound;
import com.example.AutoShop.Repository.CustomerRepository;
import com.example.AutoShop.Service.CarService;
import com.example.AutoShop.Service.CarTypeService;
import com.example.AutoShop.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAll(){
        return customerService.getAll();
    }

    @GetMapping ("/{id}")
    public Customer getById (@PathVariable Long id){
        return customerService.getById(id);
    }

    @PostMapping
    public Customer add (@RequestBody Customer customer){
        return customerService.add(customer);
    }

    @PutMapping ("/{id}")
    public Customer update (@RequestBody Customer customerTypeUpdate, @PathVariable Long id){
        return customerService.update(customerTypeUpdate,id);
    }

    @DeleteMapping ("{id}")
    public void delete (@PathVariable Long id){
        customerService.delete(id);
    }
}

