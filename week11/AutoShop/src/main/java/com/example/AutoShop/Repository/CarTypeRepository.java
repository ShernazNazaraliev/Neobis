package com.example.AutoShop.Repository;

import com.example.AutoShop.Entity.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarTypeRepository extends JpaRepository<CarType, Long> {
}
