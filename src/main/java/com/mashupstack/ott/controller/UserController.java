package com.mashupstack.ott.controller;

import com.mashupstack.ott.dto.UserDto;
import com.mashupstack.ott.models.User;
import com.mashupstack.ott.models.WatchHistory;
import com.mashupstack.ott.models.Wishlist;
import com.mashupstack.ott.repository.UserRepository;
import com.mashupstack.ott.repository.WatchHistoryRepository;
import com.mashupstack.ott.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WatchHistoryRepository watchHistoryRepository;

    @Autowired
    WishListRepository wishListRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping("/user-page")
    public String userPage(){
        return "user-page";
    }

    @PutMapping("update")
    public void updateProfile(@RequestBody UserDto userDto){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        //TODO: Set the Updated Value to Current User Repository
        User user = userRepository.findByEmail(userEmail);

        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);
    }

    @GetMapping("/profile")
    public User getUserProfile(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        return userRepository.findByEmail(userEmail);

    }

    @DeleteMapping("delete")
    public void deleteUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail);

        userRepository.delete(user);
    }

    @GetMapping("/history")
    public String showHistory(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();


        //User user = userRepository.findByEmail(userEmail);
        List<WatchHistory> watchHistory = watchHistoryRepository.findByEmail(userEmail);

        model.addAttribute("watchHistory", watchHistory);
        return "watch-history";
    }

    @PostMapping("/addHistory")
    public void addWatchHistory(Long contentId){
        ///TODO: Get Content by Content ID
        ///TODO: Get User by User ID
        ///TODO: Create a Watch History
        ///TODO: Add Both Content Id & User Id to Watch History Repository
    }

    @PostMapping("clear")
    public void clearHistory(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        //User user = userRepository.findByEmail(userEmail);

        List<WatchHistory> watchHistory = watchHistoryRepository.findByEmail(userEmail);
        watchHistory.clear();

    }


    @PostMapping("/addWishList")
    public void addWishList(@PathVariable Long contentId){
        ///TODO: Get Content Id
        ///TODO: Get Current Logged in User
        ///TODO: Add Both Content Id & User Id to WishList Repository
    }

    @GetMapping("wishlist")
    public String wishlists(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();


        List<Wishlist> wishList = wishListRepository.findByEmail(userEmail);
        model.addAttribute("wishList", wishList);

        return "wishlist";
    }

    @PostMapping("removefromList/{contentId}")
    public void removeFromList(@PathVariable Long contentId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        Optional<Wishlist> whishlist = wishListRepository.findById(contentId);
        ///TODO: Remove respective WishList Content of Current User

        wishListRepository.deleteAll();
    }


}
