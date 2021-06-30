package com.example.AutoShop.Controller;


import com.example.AutoShop.Entity.CarType;
import com.example.AutoShop.Repository.CarTypeRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CarType")
public class CarTypeController {

    private final CarTypeRepository carTypeRepository;

    @Autowired
    public CarTypeController(CarTypeRepository carTypeRepository) {
        this.carTypeRepository = carTypeRepository;
    }

    @GetMapping("/all")
    public List<CarType> getAll(){
        return carTypeRepository.findAll();
    }

    @PostMapping("/add")
    public CarType add(@RequestBody CarType carType){
        return carTypeRepository.save(carType);
    }

    @GetMapping("/search/{id}")
    public CarType findById(@PathVariable Long id){
        return carTypeRepository.findById(id).orElse(null);
    }

    @PutMapping("/update")
    public CarType carTypeUpdate(@RequestBody CarType carType){
        CarType carTypeUpdate = carTypeRepository.findById(carType.getTypeID()).orElse(null);
        carTypeUpdate.setCarType(carType.getCarType());
        return carTypeRepository.save(carType);
    }

    @DeleteMapping("/delete/{id}")
    public String carTypeDelete(@PathVariable long id){
        carTypeRepository.deleteById(id);
        return "deleted!";
    }
}
