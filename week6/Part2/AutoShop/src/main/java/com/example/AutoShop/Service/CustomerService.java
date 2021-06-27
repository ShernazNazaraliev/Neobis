package com.example.AutoShop.Service;

import com.example.AutoShop.Model.Customer;
import com.example.AutoShop.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
}
