package com.mashupstack.ott.models;

import jakarta.persistence.*;

@Entity
@Table
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long wishlistId;
    private long contentId;
    private long userId;

    public long getWishlistId() {
        return wishlistId;
    }

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
