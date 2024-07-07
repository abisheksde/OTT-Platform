package com.mashupstack.ott.controller;
import com.mashupstack.ott.dto.ContentDto;
import com.mashupstack.ott.models.Content;
import com.mashupstack.ott.repository.ContentRepository;
import com.mashupstack.ott.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/content")
public class ContentController {

    @Autowired
    ContentService contentService;

    @Autowired
    ContentRepository contentRepository;

    @PostMapping("/create")
    public void addContent(@RequestBody ContentDto contentDto){
        contentService.save(contentDto);
    }

    @GetMapping("/contentList")
    public List<Content> showContent(){

        List<Content> contentList = contentRepository.findAll();
        return contentList;
    }

    ///TODO: Not Completed
    @GetMapping("/play/{contentId}")
    public void playContent(@PathVariable Long contentId){
        ///TODO: Get the Current Logged in User
        ///TODO: Check Role is User
        ///IF USER
            ///TODO: Check User have any Active Plan
                ///TODO: If Have - Check The Plan is Expired or Not (Code Already Written in Subscription Controller)
                    ///TODO: If Not Expired - Allow to Watch & Add to Watch History (contentService.addWatchHistory(contentId);)
                    ///TODO: If Expired - Deactivate the Plan (Code Already Written in Subscription Controller>PlanService) & Don't Allow to Watch
                ///TODO: If Don't Have - Don't Allow to Watch
        ///IF ADMIN
            ///TODO: Allow to Watch without any Restrictions & Add to Watch History (contentService.addWatchHistory(contentId);
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

    @PostMapping("clear")
    public void clearHistory(){
        contentService.clearHistory();
    }

}
