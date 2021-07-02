package com.example.AutoShop.Controller;

import com.example.AutoShop.Entity.Car;
import com.example.AutoShop.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/Car")
public class CarController {
    private final CarRepository carRepository;

    @Autowired
    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/all")
    public List<Car> getAll(){
        return carRepository.findAll();
    }

    @GetMapping("/search/{id}")
    public Car findById(@PathVariable Long id){
        return carRepository.findById(id).orElse(null);
    }

    @PostMapping("/add")
    public Car add(@RequestBody Car car){
        return carRepository.save(car);
    }

    @PutMapping("/update")
    public Car updateCar(@RequestBody Car car){
        Car carUpdate = carRepository.findById(car.getCarId()).orElse(null);
        carUpdate.setCarName(car.getCarName());
        carUpdate.setColor(car.getColor());
        carUpdate.setCarType(car.getCarType());
        carUpdate.setPriceID(car.getPriceID());
        return carRepository.save(carUpdate);
    }

    @DeleteMapping("/deleteCar/{id}")
    public String carDelete(@PathVariable Long id){
        carRepository.deleteById(id);
        return "deleted!";
    }
}

