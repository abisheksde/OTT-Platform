package com.mashupstack.ott.repository;

import com.mashupstack.ott.models.SubscriptionPlans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionPlanRepository extends JpaRepository<SubscriptionPlans, Long> {
}
