package com.mashupstack.ott.controller;

import com.mashupstack.ott.dto.UserDto;
import com.mashupstack.ott.models.User;
import com.mashupstack.ott.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthenticationController {

    @Autowired
    PasswordEncoder passwordEncoder;



    @Autowired
    UserRepository userRepository;

    @GetMapping("/login")
    public String userLogin(){
        return "login";
    }

    @GetMapping("/register")
    public String userRegistration(){
        return "registration";
    }

    @PostMapping("/create")
    public void createUser(@RequestBody UserDto userDto){

        User user = new User(userDto.getName(), userDto.getAge(), userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()));

        user.setIsblocked(false);
        user.setRole("USER");
        //TODO: Encode the Password & Save
        userRepository.save(user);
    }
}
