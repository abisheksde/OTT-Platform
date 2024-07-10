package com.mashupstack.ott.models;

import jakarta.persistence.*;

@Entity
@Table
public class WatchHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long histroyId;
    private String email;
    private long contentId;

    public WatchHistory(String email, long contentId) {
        this.email = email;
        this.contentId = contentId;
    }

    public WatchHistory() {
    }

    public String getEmail() {
        return email;
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
