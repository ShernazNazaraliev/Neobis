package com.example.AutoShop.Controller;

import com.example.AutoShop.Entity.Customer;
import com.example.AutoShop.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping
    public List<Customer> findAll(){
        return customerService.getAllCustomer();
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody Customer customer){
        return customerService.updateCustomer(id, customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }
}
