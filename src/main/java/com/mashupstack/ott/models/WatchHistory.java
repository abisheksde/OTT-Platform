package com.mashupstack.ott.models;

import jakarta.persistence.*;

@Entity
@Table
public class WatchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long histroyId;
    private long userId;
    private long contentId;

    public WatchHistory(long userId, long contentId) {
        this.userId = userId;
        this.contentId = contentId;
    }

    public WatchHistory() {
    }

    public long getUserId() {
        return userId;
    }


    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public long getHistroyId() {
        return histroyId;
    }

    public void setHistroyId(long histroyId) {
        this.histroyId = histroyId;
    }
}
