package com.example.AutoShop.service;

import com.example.AutoShop.dto.UserDTO;
import com.example.AutoShop.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserDTO userDTO);
}
