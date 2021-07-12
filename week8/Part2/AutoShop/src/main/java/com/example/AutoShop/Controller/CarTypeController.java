package com.example.AutoShop.Controller;


import com.example.AutoShop.Entity.CarType;
import com.example.AutoShop.Exceptions.ResourceNotFound;
import com.example.AutoShop.Repository.CarTypeRepository;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> add(@RequestBody CarType carType){
        try {
            carTypeRepository.save(carType);
            return ResponseEntity.ok(carType);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("the object has not survived");
        }
    }

    @GetMapping("/search/{id}")
    public CarType findById(@PathVariable Long id){
        return carTypeRepository.findById(id).orElseThrow(()->new ResourceNotFound("CarType with such id not found ", id));
    }

    @PutMapping("/update")
    public CarType carTypeUpdate(@RequestBody CarType carType){
        CarType carTypeUpdate = carTypeRepository.findById(carType.getTypeID()).orElseThrow(()->new ResourceNotFound("CarType with such id not found ", carType.getTypeID()));
        carTypeUpdate.setCarType(carType.getCarType());
        return carTypeRepository.save(carType);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> carTypeDelete(@PathVariable long id){
        try {
            carTypeRepository.deleteById(id);
            return ResponseEntity.ok("deleted!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("CarType with this id not found id = " + id);
        }
    }
}
