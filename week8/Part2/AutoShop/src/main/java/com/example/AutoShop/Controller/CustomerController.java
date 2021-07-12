package com.example.AutoShop.Controller;

import com.example.AutoShop.Entity.Customer;
import com.example.AutoShop.Exceptions.ResourceNotFound;
import com.example.AutoShop.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @GetMapping("/all")
    public List<Customer> get(){
        return customerRepository.findAll();
    }

    @GetMapping("/search/{id}")
    public Customer getById(@PathVariable Long id) {
        return customerRepository.findById(id).orElseThrow(()-> new ResourceNotFound("customer with this go not found ",id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCustomers(@RequestBody Customer customer){
        try {
            customerRepository.save(customer);
            return ResponseEntity.ok(customer);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("the object has not survived");
        }
    }

    @PutMapping("/update")
    public Customer updateCustomers(@RequestBody Customer customer){
        Customer customerUpdate = customerRepository.findById(customer.getCustomerID()).orElseThrow(()->new ResourceNotFound("customer with this go not found ",customer.getCustomerID()));
        customerUpdate.setCustomersName(customer.getCustomersName());
        customerUpdate.setEmail(customer.getEmail());
        customerUpdate.setAdress(customer.getAdress());
        customerUpdate.setPhoneNumber(customer.getPhoneNumber());
        return customerRepository.save(customerUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomers(@PathVariable Long id){
        try {
            customerRepository.deleteById(id);
            return ResponseEntity.ok("deleted!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("user with this id not found id = " + id);
        }
    }

}

