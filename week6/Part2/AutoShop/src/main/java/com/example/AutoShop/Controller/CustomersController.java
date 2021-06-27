package com.example.AutoShop.Controller;

import com.example.AutoShop.Model.Customer;
import com.example.AutoShop.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/all")
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
    @GetMapping("/search/{id}")
    public Customer getById(@PathVariable Long id) throws Exception {
        return customerRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public Customer addCustomers(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @PutMapping("/update")
    public Customer updateCustomers(@RequestBody Customer customer){
        Customer customerUpdate = customerRepository.findById(customer.getCustomerID()).orElse(null);
        customerUpdate.setCustomersName(customer.getCustomersName());
        customerUpdate.setEmail(customer.getEmail());
        customerUpdate.setAdress(customer.getAdress());
        customerUpdate.setPhoneNumber(customer.getPhoneNumber());
        return customerRepository.save(customerUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCustomers(@PathVariable Long id){
        customerRepository.deleteById(id);
        return "deleted!";
    }

}

