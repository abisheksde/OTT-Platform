package com.mashupstack.ott.service;

import com.mashupstack.ott.dto.ContentDto;
import com.mashupstack.ott.models.Content;
import com.mashupstack.ott.models.WatchHistory;
import com.mashupstack.ott.models.Wishlist;
import com.mashupstack.ott.repository.ContentRepository;
import com.mashupstack.ott.repository.WatchHistoryRepository;
import com.mashupstack.ott.repository.WishListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    WatchHistoryRepository watchHistoryRepository;

    @Autowired
    WishListRepository wishListRepository;

    public Content save(ContentDto contentDto){
        Content content = new Content(contentDto.getTitle(), contentDto.getDescription(), contentDto.getLanguage(), contentDto.getCategory(), contentDto.getUrl(), contentDto.getThumbnail());
        return contentRepository.save(content);
    }

    public void addWatchHistory(Long contentId){
        ///TODO: Get Content by Content ID
        ///TODO: Get User by User ID
        ///TODO: Create a Watch History
        ///TODO: Add Both Content Id & User Id to Watch History Repository
    }

    public List<WatchHistory> history(){
        ///TODO: Get Current Logged in User
        ///TODO: Get Watch History of Current User
        return watchHistoryRepository.findAll();
    }

    public void clearHistory(){
        ///TODO: Get Current Logged in User
        ///TODO: Get Watch History of Current User
        ///TODO: Clear All History of Current User

        watchHistoryRepository.deleteAll();
    }

    public void addToList(Long contentId){
        ///TODO: Get Content Id
        ///TODO: Get Current Logged in User
        ///TODO: Add Both Content Id & User Id to WishList Repository
    }

    public List<Wishlist> wishList(){
        ///TODO: Get Current User
        ///TODO: Get Current User's WishList
        return wishListRepository.findAll();
    }

    public void removeFromWishList(){
        ///TODO: Get Current Logged in User
        ///TODO: Get Respective Content Id via Path Variable
        ///TODO: Remove respective WishList Content of Current User

        wishListRepository.deleteAll();
    }

}
