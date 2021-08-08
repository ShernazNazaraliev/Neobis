package com.example.AutoShop.Controller;

import com.example.AutoShop.Entity.Car;
import com.example.AutoShop.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> findAll(){
        return carService.getAllCar();
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody Car car){
        return carService.addCar(car);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return carService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody Car car){
        return carService.updateCar(id, car);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return carService.deleteCar(id);
    }
}
