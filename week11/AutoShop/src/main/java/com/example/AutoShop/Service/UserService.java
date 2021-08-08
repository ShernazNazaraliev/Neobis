package com.example.AutoShop.Service;

import com.example.AutoShop.DTO.UserDTO;
import com.example.AutoShop.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserDTO userDTO);
}
