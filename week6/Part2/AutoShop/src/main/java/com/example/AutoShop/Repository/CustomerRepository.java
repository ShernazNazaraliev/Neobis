package com.example.AutoShop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.AutoShop.Model.Customer;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
