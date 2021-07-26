package com.example.AutoShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AutoShop.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
