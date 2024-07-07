package com.mashupstack.ott.service;

import com.mashupstack.ott.dto.PlanDto;
import com.mashupstack.ott.models.Subscription;
import com.mashupstack.ott.models.SubscriptionPlans;
import com.mashupstack.ott.repository.SubscriptionPlanRepository;
import com.mashupstack.ott.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PlanService {

    @Autowired
    SubscriptionPlanRepository subscriptionPlanRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public SubscriptionPlans savePlan(PlanDto planDto){
        SubscriptionPlans subscriptionPlans = new SubscriptionPlans(planDto.getValidity(), planDto.getPrice());

        return subscriptionPlanRepository.save(subscriptionPlans);
    }

    public SubscriptionPlans updatePlan(Long planId,PlanDto planDto){
        Optional<SubscriptionPlans> optionalPlan = subscriptionPlanRepository.findById(planId);

        SubscriptionPlans plan = optionalPlan.get();

        plan.setValidity(planDto.getValidity());
        plan.setPrice(planDto.getPrice());

        System.out.println(planId);
        return subscriptionPlanRepository.save(plan);

    }

    public void deletePlan(Long planId){
        subscriptionPlanRepository.deleteById(planId);
    }

    ///TODO: Not Completed
    public void activatePlan(Long planId){
        Optional<SubscriptionPlans> optionalPlan = subscriptionPlanRepository.findById(planId);
        SubscriptionPlans planToActivate = optionalPlan.get();

        ///TODO: Get Current Logged in User (Using Authentication)
        ///TODO: Check the User Already have Active Plan??
        // If Not
        ///TODO: Create a Subscription for this Plan
        ///TODO: Set isActive is True
        ///TODO: Save that Subscription to Repository
        /// NOTE : Try to deactivate the Subscription automatically after the Expiry Date (If possible)

    }


    public void deactivatePlan(Long subscriptionId){
        Optional<Subscription> optionalPlan = subscriptionRepository.findById(subscriptionId);
        Subscription subscriptionToDeactivate = optionalPlan.get();

        if(subscriptionToDeactivate.isActive()){
            subscriptionToDeactivate.setActive(false);
        }

        subscriptionRepository.save(subscriptionToDeactivate);


    }

    public Long[] report(){
        long totalSubscription = subscriptionRepository.count();


        long activeSubscription = subscriptionRepository.countByIsActiveTrue();
        //It will take count of true value in isActive column

        long inactiveSubscription = totalSubscription-activeSubscription;

        Long[] reportArray = new Long[3];

        reportArray[0] = totalSubscription;
        reportArray[1] = activeSubscription;
        reportArray[2] = inactiveSubscription;

        return reportArray;
    }


}
