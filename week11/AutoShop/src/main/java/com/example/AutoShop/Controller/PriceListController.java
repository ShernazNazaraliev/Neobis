package com.example.AutoShop.Controller;

import com.example.AutoShop.Entity.PriceList;
import com.example.AutoShop.Exceptions.ResourceNotFound;
import com.example.AutoShop.Repository.PriceListRepository;
import com.example.AutoShop.Service.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@RestController
@RequestMapping("/PriceList")
public class PriceListController {

    @Autowired
   public PriceListService priceListService;

    @GetMapping
    public List<PriceList> getAll(){
        return priceListService.getAll();
    }

    @GetMapping("/{id}")
    public PriceList fingById(@PathVariable Long id){
        return priceListService.findById(id);
    }

    @PostMapping
    public PriceList add(@RequestBody PriceList priceList){
        return priceListService.add(priceList);
    }

    @PutMapping("/{id}")
    public PriceList update(@RequestBody PriceList priceList, @PathVariable Long id){
         return priceListService.update(id, priceList);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable  Long id){
        priceListService.delete(id);
    }

}
