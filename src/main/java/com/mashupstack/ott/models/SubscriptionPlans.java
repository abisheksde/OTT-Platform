package com.mashupstack.ott.models;

import jakarta.persistence.*;

@Entity
@Table
public class SubscriptionPlans {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int validity;
    private int price;

    public SubscriptionPlans(int validity, int price) {
        this.validity = validity;
        this.price = price;
    }

    public SubscriptionPlans() {
    }

    public long getId() {
        return id;
    }


    public int getValidity() {
        return validity;
    }

    public void setValidity(int validity) {
        this.validity = validity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
