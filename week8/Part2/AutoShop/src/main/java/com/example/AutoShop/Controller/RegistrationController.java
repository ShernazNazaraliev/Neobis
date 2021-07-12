package com.example.AutoShop.Controller;


import com.example.AutoShop.Service.UserService;
import com.example.AutoShop.Web.DTO.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userForm")
    public UserRegistration userRegistration(){
        return new UserRegistration();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping
    public String registerUser (@ModelAttribute ("userForm")UserRegistration userRegistration){
        userService.save(userRegistration);
        return "redirect:/registration?success";
    }
}
