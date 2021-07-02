package com.example.demo.Controller;

import com.example.demo.Entity.Customer;
import com.example.demo.Exception.NotFound;
import com.example.demo.Repository.CustomerRepository;
import org.apache.catalina.LifecycleState;
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
    public Iterable<Customer> all(){
        return customerRepository.findAll();
    }

    @GetMapping("/search/{id}")
    public Customer getById(@PathVariable long id){
        return customerRepository.findById(id).orElseThrow(()->new NotFound(id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Customer customer){
        try {
            customerRepository.save(customer);
            return ResponseEntity.ok(customer);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("the object has not survived");
        }
    }

    @PutMapping("/update")
    public Customer update(@RequestBody Customer customer){
        Customer customerUpdate =customerRepository.findById(customer.getId()).orElseThrow(()-> new NotFound(customer.getId()));
        customerUpdate.setFirstName(customer.getFirstName());
        customerUpdate.setLastName(customer.getLastName());
        customerUpdate.setEmail(customer.getEmail());
        return customerRepository.save(customerUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        try {
            customerRepository.deleteById(id);
            return ResponseEntity.ok("deleted!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("error while deleting");
        }
    }
}
