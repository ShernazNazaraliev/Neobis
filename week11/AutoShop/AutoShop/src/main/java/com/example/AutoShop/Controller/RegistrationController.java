package com.example.AutoShop.Controller;


import com.example.AutoShop.DTO.UserDTO;
import com.example.AutoShop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userForm")
    public UserDTO newUserDTO(){
        return new UserDTO();
    }

    @GetMapping
    public String registration(){
        return "registration";
    }

    @PostMapping
    public String registrationUser(@ModelAttribute("userForm")UserDTO userDTO){

        if (!userService.save(userDTO)){
            return "redirect:/registration?error";
        }
        userService.save(userDTO);
        return "redirect:/registration?success";
    }
}
