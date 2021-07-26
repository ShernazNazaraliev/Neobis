package com.example.AutoShop.Service;

import com.example.AutoShop.Entity.PriceList;
import com.example.AutoShop.Exceptions.ResourceNotFound;
import com.example.AutoShop.Repository.PriceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceListService {

    @Autowired
    public PriceListRepository priceListRepository;

    public List<PriceList> getAll(){
        return priceListRepository.findAll();
    }

    public PriceList findById(Long id){
        return priceListRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFound("Could not find Price with ID ",id));
    }

    public PriceList add(PriceList priceList){
        return priceListRepository.save(priceList);
    }

    public PriceList update(Long id, PriceList priceList){
        return priceListRepository.findById(id).map(priceUpdate -> {
            priceUpdate.setPrice(priceList.getPrice());
            return priceListRepository.save(priceUpdate);
        }).orElseThrow(()-> new ResourceNotFound("Could not find Price with ID ",id));
    }

    public void delete( Long id){
        priceListRepository.deleteById(id);
    }

}
