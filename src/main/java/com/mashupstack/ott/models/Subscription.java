package com.mashupstack.ott.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long userId;
    private long planid;
    private long txnid;
    private LocalDate subscriptionDate;
    private LocalDate expiryDate;
    private boolean isActive;

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserid(long userId) {
        this.userId = userId;
    }

    public long getPlanid() {
        return planid;
    }

    public void setPlanid(long planid) {
        this.planid = planid;
    }

    public long getTxnid() {
        return txnid;
    }

    public void setTxnid(long txnid) {
        this.txnid = txnid;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDate subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
