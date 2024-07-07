package com.mashupstack.ott.models;

import jakarta.persistence.*;

@Entity
@Table
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contentId;
    private String title;
    private String description;
    private String Language;
    private String category;
    private String url;
    private String thumbnail;

    public Content(String title, String description, String language, String category, String url, String thumbnail) {
        this.title = title;
        this.description = description;
        Language = language;
        this.category = category;
        this.url = url;
        this.thumbnail = thumbnail;
    }

    public Content() {
    }

    public long getContentId() {
        return contentId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
