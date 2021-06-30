package com.example.AutoShop.Controller;

import com.example.AutoShop.Entity.PriceList;
import com.example.AutoShop.Exceptions.ResourceNotFound;
import com.example.AutoShop.Repository.PriceListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/PriceList")
public class PriceListController {

    private final PriceListRepository priceListRepository;

    @Autowired
    public PriceListController(PriceListRepository priceListRepository) {
        this.priceListRepository = priceListRepository;
    }

    @GetMapping("/all")
    public List<PriceList> getAll(){
        return priceListRepository.findAll();
    }

    @PostMapping("/add")
    public PriceList add(@RequestBody PriceList priceList){
        return priceListRepository.save(priceList);
    }

    @GetMapping("/search/{id}")
    public PriceList findById(@PathVariable Long id){
        return priceListRepository.findById(id).orElseThrow(()->new ResourceNotFound("Could not find",id));
    }

    @PutMapping("/update")
    public PriceList priceListUpdate(@RequestBody PriceList priceList){
        return priceListRepository.findById(priceList.getPriceID()).map(priceList1 -> {
            return priceListRepository.save(priceList);
        }).orElseThrow(()-> new ResourceNotFound("Could not find",priceList.getPriceID()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> pricelistDelete(@PathVariable Long id){
        return priceListRepository.findById(id).map(priceList -> {
            priceListRepository.deleteById(id);
            return new ResponseEntity<>("Deleted!", HttpStatus.OK);
        }).orElseThrow(()-> new ResourceNotFound("Could not find", id));
    }
}
