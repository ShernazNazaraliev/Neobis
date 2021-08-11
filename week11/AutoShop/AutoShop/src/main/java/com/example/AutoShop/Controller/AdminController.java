package com.example.AutoShop.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @GetMapping("/admin")
    public String helloAdmin(){
        return "<h1> Hello Admin! </h1>";
    }
}
