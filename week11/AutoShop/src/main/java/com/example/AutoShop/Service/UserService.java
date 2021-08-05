package com.example.AutoShop.Service;

import com.example.AutoShop.Entity.User;
import com.example.AutoShop.Web.DTO.UserRegistrationDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDTO userRegistrationDto);
}
