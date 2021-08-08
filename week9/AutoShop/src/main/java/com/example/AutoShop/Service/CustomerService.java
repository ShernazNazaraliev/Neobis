package com.example.AutoShop.Service;

import com.example.AutoShop.Entity.Customer;
import com.example.AutoShop.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

    public ResponseEntity<String> addCustomer(Customer customer){
        try {
            customerRepository.save(customer);
            return new ResponseEntity<String>("customer created!", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("customer has not been created!", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> findById(Long id) {
        if (customerRepository.existsById(id)){
            return new ResponseEntity<Optional<Customer>>(customerRepository.findById(id), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("customer with id "+id+" not found", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> updateCustomer(Long id, Customer newCustomer){
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setCustomerName(newCustomer.getCustomerName());
                    customer.setAddress(newCustomer.getAddress());
                    customer.setEmail(newCustomer.getEmail());
                    customer.setPhoneNumber(newCustomer.getPhoneNumber());
                    customerRepository.save(customer);
                    return new ResponseEntity<String>("customer with id "+id+" updated!",HttpStatus.OK);
                }).orElse(new ResponseEntity<String>("customer with id "+id+" not found",HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<String> deleteCustomer(Long id){
        try {
            customerRepository.deleteById(id);
            return new ResponseEntity<String>("customer deleted!", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("customer with id "+id+" not found", HttpStatus.BAD_REQUEST);
        }

    }
}
