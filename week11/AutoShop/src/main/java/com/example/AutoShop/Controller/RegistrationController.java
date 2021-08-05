package com.example.AutoShop.Controller;


import com.example.AutoShop.Service.UserService;
import com.example.AutoShop.Web.DTO.UserRegistrationDTO;
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
    public UserRegistrationDTO userRegistration(){
        return new UserRegistrationDTO();
    }

    @GetMapping
    public String showRegistrationForm(){
        return "registration";
    }

    @PostMapping
    public String registerUser (@ModelAttribute ("userForm") UserRegistrationDTO userRegistration){
        userService.save(userRegistration);
            return "redirect:/registration?success";
    }

}
