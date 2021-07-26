package com.example.AutoShop.Service;

import com.example.AutoShop.Entity.Car;
import com.example.AutoShop.Exceptions.ResourceNotFound;
import com.example.AutoShop.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAll (){
        return carRepository.findAll();
    }

    public Car getById (Long id){
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Could not find car with ID ", id) );
    }

    public Car add (Car car){
        return carRepository.save(car);
    }

    public Car update (Car carUpdate,Long id){
        return carRepository.findById(id)
                .map(car -> {
                    car.setCarName(carUpdate.getCarName());
                    car.setColor(carUpdate.getColor());
                    car.setPriceID(carUpdate.getPriceID());
                    car.setCarType(carUpdate.getCarType());
                    return carRepository.save(car);
                })
                .orElseThrow(() -> new ResourceNotFound("Could not find car with ID ", id) );
    }

    public void delete(Long id){
        carRepository.deleteById(id);
    }
}
