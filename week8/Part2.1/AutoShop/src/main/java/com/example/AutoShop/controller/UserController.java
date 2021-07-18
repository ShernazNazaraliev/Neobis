package com.example.AutoShop.controller;


import com.example.AutoShop.dto.UserDTO;
import com.example.AutoShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userForm")
    public UserDTO userDTO(){
        return new UserDTO();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("userForm")UserDTO userDTO){
        userService.save(userDTO);
        return "redirect:/registration?success";
    }


}
