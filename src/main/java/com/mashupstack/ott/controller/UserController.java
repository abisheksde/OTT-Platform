package com.mashupstack.ott.controller;

import com.mashupstack.ott.dto.UserDto;
import com.mashupstack.ott.models.User;
import com.mashupstack.ott.models.WatchHistory;
import com.mashupstack.ott.models.Wishlist;
import com.mashupstack.ott.repository.UserRepository;
import com.mashupstack.ott.service.ContentService;
import com.mashupstack.ott.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ContentService contentService;

    @Autowired
    UserService userService;

    @PutMapping("update")
    public void updateProfile(@RequestBody UserDto userDto){
        userService.userUpdation(userDto);
    }

    @GetMapping("/profile")
    public User getUserProfile(){
        return userService.getUser();
    }

    @DeleteMapping("delete")
    public void deleteUser(){
        userService.deleteUser();
    }
/*
    @PostMapping("/addWatchHistory")
    public void addWatchHistory(){
        contentService.addWatchHistory();
    }
*/
    @GetMapping("/history")
    public List<WatchHistory> showHistory(){
        return contentService.history();
    }

    @PostMapping("/addWishList")
    public void addWishList(@PathVariable Long contentId){
        contentService.addToList(contentId);
    }

    @GetMapping("wishlist")
    public List<Wishlist> wishlists(){
        return contentService.wishList();
    }

    @PostMapping("removefromList")
    public void removeFromList(){
        contentService.removeFromWishList();
    }


}
