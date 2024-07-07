package com.mashupstack.ott.models;

import jakarta.persistence.*;

@Entity
@Table
public class Billings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long billingId;
    private long userId;
    private long subscriptionId;
    private String name;
    private String email;
    private String billingAddress;
    private float price;

    public long getBillingId() {
        return billingId;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
