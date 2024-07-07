package com.mashupstack.ott.service;

import com.mashupstack.ott.dto.ContentDto;
import com.mashupstack.ott.models.Content;
import com.mashupstack.ott.models.WatchHistory;
import com.mashupstack.ott.models.Wishlist;

import java.util.List;

public interface ContentService {

    Content save(ContentDto contentDto);

    void addWatchHistory(Long contentId);

    List<WatchHistory> history();

    void clearHistory();

    void addToList(Long contentId);

    List<Wishlist> wishList();

    void removeFromWishList();
}
