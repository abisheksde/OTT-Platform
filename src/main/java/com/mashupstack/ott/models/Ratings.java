package com.mashupstack.ott.models;

import jakarta.persistence.*;

@Entity
@Table
public class Ratings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ratingsId;
    private long userId;
    private long contentId;

    public long getRatingsId() {
        return ratingsId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }
}
