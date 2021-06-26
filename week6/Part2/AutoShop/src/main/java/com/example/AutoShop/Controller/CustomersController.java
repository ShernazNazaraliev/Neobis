package com.example.AutoShop.Controller;


import com.example.AutoShop.Model.Customer;
import com.example.AutoShop.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auto")
public class CustomersController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/add")
    public @ResponseBody String addCustomers(@RequestParam String customersName,@RequestParam String adress,@RequestParam String email,@RequestParam String phoneNumber){
        Customer customer=new Customer();
        customer.setCustomersName(customersName);
        customer.setAdress(adress);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customerRepository.save(customer);
        return ("saved");
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }

}

