package com.example.AutoShop.Controller;

import com.example.AutoShop.Entity.PriceList;
import com.example.AutoShop.Service.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/priceList")
public class PriceListController {

    @Autowired
    private PriceListService priceListService;

    @GetMapping
    public List<PriceList> findAll(){
        return priceListService.getAllPriceList();
    }

    @PostMapping
    public ResponseEntity<String> add(@RequestBody PriceList priceList){
        return priceListService.addPriceList(priceList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return priceListService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
                                    @RequestBody PriceList priceList){
        return priceListService.updatePriceList(id, priceList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return priceListService.deletePriceList(id);
    }
}
