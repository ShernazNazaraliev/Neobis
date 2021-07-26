package com.example.AutoShop.Service;

import com.example.AutoShop.Entity.Car;
import com.example.AutoShop.Entity.CarType;
import com.example.AutoShop.Exceptions.ResourceNotFound;
import com.example.AutoShop.Repository.CarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarTypeService {


    private final CarTypeRepository carTypeRepository;

    @Autowired
    public CarTypeService(CarTypeRepository carTypeRepository) {
        this.carTypeRepository = carTypeRepository;
    }


    public List<CarType> getAll (){
        return carTypeRepository.findAll();
    }

    public CarType getById (Long id){
        return carTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Could not find CarType with ID ", id) );
    }

    public CarType add (CarType carType){
        return carTypeRepository.save(carType);
    }

    public CarType update (CarType carTypeUpdate,Long id){
        return carTypeRepository.findById(id)
                .map(carType -> {
                    carType.setCarType(carTypeUpdate.getCarType());
                    return carTypeRepository.save(carType);
                })
                .orElseThrow(() -> new ResourceNotFound("Could not find CarType with ID ", id) );
    }

    public void delete(Long id){
        carTypeRepository.deleteById(id);
    }
}
