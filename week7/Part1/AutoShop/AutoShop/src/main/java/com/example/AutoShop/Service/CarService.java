package com.example.AutoShop.Service;

import com.example.AutoShop.Entity.Car;
import com.example.AutoShop.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCar(){
        return carRepository.findAll();
    }

    public ResponseEntity<String> addCar(Car car){
        try {
            carRepository.save(car);
            return new ResponseEntity<String>("car created!", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("car has not been created!", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> findById(Long id) {
        if (carRepository.existsById(id)){
            return new ResponseEntity<Optional<Car>>(carRepository.findById(id), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("car with id "+id+" not found", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> updateCar(Long id, Car newCar){
        return carRepository.findById(id)
                .map(car -> {
                    car.setCarName(newCar.getCarName());
                    car.setCarTypeId(newCar.getCarTypeId());
                    car.setColor(newCar.getColor());
                    car.setPriceListId(newCar.getPriceListId());
                    carRepository.save(car);
                    return new ResponseEntity<String>("car with id "+id+" updated!",HttpStatus.OK);
                }).orElse(new ResponseEntity<String>("car with id "+id+" not found",HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<String> deleteCar(Long id){
        try {
            carRepository.deleteById(id);
            return new ResponseEntity<String>("car deleted!", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("car with id "+id+" not found", HttpStatus.BAD_REQUEST);
        }

    }
}
