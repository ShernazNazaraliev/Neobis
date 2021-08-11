package com.example.AutoShop.Controller;

import com.example.AutoShop.Entity.AuthorizationJwtUser;
import com.example.AutoShop.Security.JWT.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/auth")
    @ResponseBody
    public String generateToken(@RequestBody AuthorizationJwtUser authorizationJwtUser) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authorizationJwtUser.getUserName(), authorizationJwtUser.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username or password");
        }
        return jwtUtil.generateToken(authorizationJwtUser.getUserName());
    }

}
