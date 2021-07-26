package com.example.AutoShop.Service;

import com.example.AutoShop.Entity.Car;
import com.example.AutoShop.Entity.Customer;
import com.example.AutoShop.Exceptions.ResourceNotFound;
import com.example.AutoShop.Repository.CarRepository;
import com.example.AutoShop.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAll (){
        return customerRepository.findAll();
    }

    public Customer getById (Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Could not find customer with ID ", id) );
    }

    public Customer add (Customer customer){
        return customerRepository.save(customer);
    }

    public Customer update (Customer customerUpdate,Long id){
        return customerRepository.findById(id)
                .map(customer -> {
                    customer.setCustomersName(customerUpdate.getCustomersName());
                    customer.setAdress(customerUpdate.getAdress());
                    customer.setEmail(customerUpdate.getEmail());
                    customer.setPhoneNumber(customerUpdate.getPhoneNumber());
                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new ResourceNotFound("Could not find customer with ID ", id) );
    }

    public void delete(Long id){
        customerRepository.deleteById(id);
    }
}
