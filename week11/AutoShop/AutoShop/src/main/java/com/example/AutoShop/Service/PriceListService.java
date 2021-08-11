package com.example.AutoShop.Service;

import com.example.AutoShop.Entity.CarType;
import com.example.AutoShop.Entity.PriceList;
import com.example.AutoShop.Repository.CarTypeRepository;
import com.example.AutoShop.Repository.PriceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceListService {

    private final PriceListRepository priceListRepository;

    @Autowired
    public PriceListService(PriceListRepository priceListRepository) {
        this.priceListRepository = priceListRepository;
    }

    public List<PriceList> getAllPriceList(){
        return priceListRepository.findAll();
    }

    public ResponseEntity<String> addPriceList(PriceList priceList){
        try {
            priceListRepository.save(priceList);
            return new ResponseEntity<String>("priceList created!", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("priceList has not been created!", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> findById(Long id) {
        if (priceListRepository.existsById(id)){
            return new ResponseEntity<Optional<PriceList>>(priceListRepository.findById(id), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<String>("carType with id "+id+" not found", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> updatePriceList(Long id, PriceList newPriceList){
        return priceListRepository.findById(id)
                .map(priceList -> {
                    priceList.setPrice(newPriceList.getPrice());
                    priceListRepository.save(priceList);
                    return new ResponseEntity<String>("priceList with id "+id+" updated!",HttpStatus.OK);
                }).orElse(new ResponseEntity<String>("priceList with id "+id+" not found",HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<String> deletePriceList(Long id){
        try {
            priceListRepository.deleteById(id);
            return new ResponseEntity<String>("priceList deleted!", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("priceList with id "+id+" not found", HttpStatus.BAD_REQUEST);
        }
    }
}
