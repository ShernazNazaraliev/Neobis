package com.example.AutoShop.Controller;

import com.example.AutoShop.Entity.Car;
import com.example.AutoShop.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> getAll(){
        return carService.getAll();
    }

    @GetMapping ("/{id}")
    public Car getById (@PathVariable Long id){
        return carService.getById(id);
    }

    @PostMapping
    public Car add (@RequestBody Car car){
        return carService.add(car);
    }

    @PutMapping ("/{id}")
    public Car update (@RequestBody Car carUpdate, @PathVariable Long id){
        return carService.update(carUpdate,id);
    }

    @DeleteMapping ("{id}")
    public void delete (@PathVariable Long id){
        carService.delete(id);
    }
}

