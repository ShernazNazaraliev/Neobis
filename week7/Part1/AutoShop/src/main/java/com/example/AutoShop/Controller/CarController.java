package com.example.AutoShop.Controller;

import com.example.AutoShop.Entity.Car;
import com.example.AutoShop.Exceptions.ResourceNotFound;
import com.example.AutoShop.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/car")
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
        return carRepository.findById(id).orElseThrow(()->new ResourceNotFound("car with such id not found ", id));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody Car car){
        try {
            carRepository.save(car);
            return ResponseEntity.ok(car);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("the object has not survived");
        }
    }

    @PutMapping("/update")
    public Car updateCar(@RequestBody Car car){
        Car carUpdate = carRepository.findById(car.getCarId()).orElseThrow(()->new ResourceNotFound("car with such id not found ", car.getCarId()));
        carUpdate.setCarName(car.getCarName());
        carUpdate.setColor(car.getColor());
        carUpdate.setCarType(car.getCarType());
        carUpdate.setPriceID(car.getPriceID());
        return carRepository.save(carUpdate);
    }

    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<?> carDelete(@PathVariable Long id){
        try {
            carRepository.deleteById(id);
            return ResponseEntity.ok("deleted!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("user with this id not found id = " + id);
        }
    }
}

