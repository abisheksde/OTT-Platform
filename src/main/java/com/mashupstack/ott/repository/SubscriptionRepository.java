package com.mashupstack.ott.repository;

import com.mashupstack.ott.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    //Long findByIsActive(boolean b);

    long countByIsActiveTrue();


    List<Subscription> findByUserId(long id);

    boolean existsByUserIdAndActive(long userId, boolean active);

    Subscription findByUserIdAndIsActive(long id, boolean b);
}