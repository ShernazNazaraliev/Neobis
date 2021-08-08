package com.example.AutoShop.Service;

import com.example.AutoShop.Entity.CarType;
import com.example.AutoShop.Repository.CarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarTypeService {

    private final CarTypeRepository carTypeRepository;

    @Autowired
    public CarTypeService(CarTypeRepository carTypeRepository) {
        this.carTypeRepository = carTypeRepository;
    }

    public List<CarType> getAllCarType(){
        return carTypeRepository.findAll();
    }

    public ResponseEntity<String> addCarType(CarType carType){
        try {
            carTypeRepository.save(carType);
            return new ResponseEntity<String>("carType created!", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("carType has not been created!", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> findById(Long id) {
        if (carTypeRepository.existsById(id)){
            return new ResponseEntity<Optional<CarType>>(carTypeRepository.findById(id), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("carType with id "+id+" not found", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> updateCarType(Long id, CarType newCarType){
        return carTypeRepository.findById(id)
                .map(carType -> {
                    carType.setCarType(newCarType.getCarType());
                    carTypeRepository.save(carType);
                    return new ResponseEntity<String>("carType with id "+id+" updated!",HttpStatus.OK);
                }).orElse(new ResponseEntity<String>("carType with id "+id+" not found",HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<String> deleteCarType(Long id){
        try {
            carTypeRepository.deleteById(id);
            return new ResponseEntity<String>("carType deleted!", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("carType with id "+id+" not found", HttpStatus.BAD_REQUEST);
        }
    }
}
