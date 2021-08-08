package com.example.AutoShop.Repository;

import com.example.AutoShop.Entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
