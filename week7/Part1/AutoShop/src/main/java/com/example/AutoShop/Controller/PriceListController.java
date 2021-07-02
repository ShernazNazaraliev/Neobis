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
    public ResponseEntity<?> add(@RequestBody PriceList priceList) {
        try {
            priceListRepository.save(priceList);
            return  ResponseEntity.ok(priceList);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("failed to save");
        }
    }
    @GetMapping("/search/{id}")
    public PriceList findById(@PathVariable Long id){
        return priceListRepository.findById(id).orElseThrow(()->new ResourceNotFound("PriceList with this id is not on ",id));
    }

    @PutMapping("/update")
    public PriceList priceListUpdate(@RequestBody PriceList priceList){
        PriceList priceListUpdate = priceListRepository.findById(priceList.getPriceID()).orElseThrow(()->new ResourceNotFound("PriceList with this id is not on ",priceList.getPriceID()));
        priceListUpdate.setPrice(priceList.getPrice());
        return priceListRepository.save(priceListUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> pricelistDelete(@PathVariable Long id){
        try {
            priceListRepository.deleteById(id);
            return ResponseEntity.ok("deleted!");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("price with this id not found id = " + id);
        }
    }
}
