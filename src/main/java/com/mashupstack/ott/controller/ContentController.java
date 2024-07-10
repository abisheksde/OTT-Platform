package com.mashupstack.ott.controller;
import com.mashupstack.ott.dto.ContentDto;
import com.mashupstack.ott.models.Content;
import com.mashupstack.ott.models.Subscription;
import com.mashupstack.ott.models.User;
import com.mashupstack.ott.repository.ContentRepository;
import com.mashupstack.ott.repository.SubscriptionRepository;
import com.mashupstack.ott.repository.UserRepository;
import com.mashupstack.ott.repository.WatchHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/content")
public class ContentController {

    @Autowired
    WatchHistoryRepository watchHistoryRepository;

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SubscriptionController subscriptionController;

    @Autowired
    UserController userController;

    @PostMapping("/create")
    public void addContent(@RequestBody ContentDto contentDto){
        Content content = new Content(contentDto.getTitle(), contentDto.getDescription(), contentDto.getLanguage(), contentDto.getCategory(), contentDto.getUrl(), contentDto.getThumbnail());
         contentRepository.save(content);
    }

    @GetMapping("/contentList")
    public List<Content> showContent(){

        List<Content> contentList = contentRepository.findAll();
        return contentList;
    }

    ///TODO: Not Completed
    @GetMapping("/play/{contentId}")
    public void playContent(@PathVariable Long contentId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userRepository.findByEmail(userEmail);

        if(user.getRole().equals("USER")){

            Subscription subscription = subscriptionRepository.findByUserIdAndIsActive(user.getId(), true);

            Long subscriptionId = subscription.getId();

            boolean active = subscriptionRepository.existsByUserIdAndActive(user.getId(), true);

            if(active){
                boolean isActive = subscriptionController.expireSubscription(subscriptionId);

                if (isActive){
                    ///TODO: Allow to Watch
                    userController.addWatchHistory(contentId);

                }else {
                    subscriptionController.deactivateSubscription(subscriptionId);
                }
            } else {
                ///TODO: Don't Allow to Watch
            }
        } else {
            ///TODO: Allow to Watch
            userController.addWatchHistory(contentId);
        }

    }

    @DeleteMapping("delete/{contentId}")
    public void deleteContent(@PathVariable Long contentId){
        if(contentId != null){
             contentRepository.deleteById(contentId);
        }
    }

    @PutMapping("/update/{contentId}")
    public void updateContent(@PathVariable Long contentId, @RequestBody ContentDto contentDto){
        /////////////////////////////////////////////////// All Content will Receive by Whole Object, Not One by One (in POSTMAN)
        /////////////////////////////////////////////////// in Form, I will Come On bye One, So we can receive one by one & Whole Object

        Optional<Content> optionalContent =  contentRepository.findById(contentId);
        ///findById() method returns Optional of Data from Repository.
        /// If we receive Optional of Data from Repository, We cannot take Value without .get() method
        Content content = optionalContent.get();

        content.setTitle(contentDto.getTitle());
        content.setDescription(contentDto.getDescription());
        content.setLanguage(contentDto.getLanguage());
        content.setCategory(contentDto.getCategory());
        content.setUrl(contentDto.getUrl());
        content.setThumbnail(contentDto.getThumbnail());

        contentRepository.save(content);

    }




}
