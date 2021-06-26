package com.example.AutoShop.Repository;

import org.springframework.data.repository.CrudRepository;
import com.example.AutoShop.Model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
