package com.example.AutoShop.Service;

import com.example.AutoShop.DTO.UserDTO;
import com.example.AutoShop.Entity.Role;
import com.example.AutoShop.Entity.User;
import com.example.AutoShop.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class UserServiceImplements implements UserService{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private UserRepository userRepository;


    public UserServiceImplements(UserRepository userRepository){
        super();
        this.userRepository=userRepository;
    }


    @Override
    public boolean save(UserDTO userDTO) {
        User user_reg =  userRepository.findByUserName(userDTO.getUserName());
        if (user_reg == null) {
            User user = new User(userDTO.getUserName(), bCryptPasswordEncoder.encode(userDTO.getPassword()));
            user.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
            userRepository.save(user);
            return true;
        }
        else return false;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName);
        if (user==null){
            throw new UsernameNotFoundException("Invalid login or password!");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), user.getRoles());
    }

    private Collection <? extends GrantedAuthority> mapRolesToAuthorities (Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getAuthority())).collect(Collectors.toList());
    }
}
