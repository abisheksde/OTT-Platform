package com.mashupstack.ott.controller;

import com.mashupstack.ott.models.User;
import com.mashupstack.ott.repository.UserRepository;
import com.mashupstack.ott.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/usersList")
    public List<User> getUsers(){
        //List<User> userList = userRepository.findAll();

        return userRepository.findByRole("USER");

    }


    @PostMapping("block/{userId}")
    public void blockUser(@PathVariable Long userId){
        userService.blockUser(userId);
        ///TODO:Just We Set the Boolean Value. We didn't implement Block Functionality yet
        ///TODO:We blocked the User, But not denied Access
    }

    @PostMapping("unblock/{userId}")
    public void unblockUser(@PathVariable Long userId){
        userService.unblockUser(userId);
        ///TODO:Just We Set the Boolean Value. We didn't implement Unblock Functionality yet
    }
}
