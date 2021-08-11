package com.example.AutoShop.Service;

import com.example.AutoShop.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    boolean save(UserDTO userDTO);
}
