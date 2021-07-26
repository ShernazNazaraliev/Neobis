package com.example.AutoShop.Controller;


import com.example.AutoShop.Entity.Car;
import com.example.AutoShop.Entity.CarType;
import com.example.AutoShop.Exceptions.ResourceNotFound;
import com.example.AutoShop.Repository.CarTypeRepository;
import com.example.AutoShop.Service.CarService;
import com.example.AutoShop.Service.CarTypeService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carType")
public class CarTypeController {

    @Autowired
    private CarTypeService carTypeService;

    @GetMapping
    public List<CarType> getAll(){
        return carTypeService.getAll();
    }

    @GetMapping ("/{id}")
    public CarType getById (@PathVariable Long id){
        return carTypeService.getById(id);
    }

    @PostMapping
    public CarType add (@RequestBody CarType carType){
        return carTypeService.add(carType);
    }

    @PutMapping ("/{id}")
    public CarType update (@RequestBody CarType carTypeUpdate, @PathVariable Long id){
        return carTypeService.update(carTypeUpdate,id);
    }

    @DeleteMapping ("{id}")
    public void delete (@PathVariable Long id){
        carTypeService.delete(id);
    }
}
