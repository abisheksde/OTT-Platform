package com.mashupstack.ott.controller;

import com.mashupstack.ott.dto.PlanDto;
import com.mashupstack.ott.models.Subscription;
import com.mashupstack.ott.models.SubscriptionPlans;
import com.mashupstack.ott.repository.SubscriptionPlanRepository;
import com.mashupstack.ott.repository.SubscriptionRepository;
import com.mashupstack.ott.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("api/subscription")
public class SubscriptionController {

    @Autowired
    SubscriptionPlanRepository subscriptionPlanRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    PlanService planService;

    @GetMapping("plans")
    public List<SubscriptionPlans> planList(){
        return subscriptionPlanRepository.findAll();
    }

    @PostMapping("plans/create")
    public void createPlan(@RequestBody PlanDto planDto){
        planService.savePlan(planDto);
    }

    @PutMapping("plans/update/{planId}")
    public void updatePlan(@PathVariable Long planId, @RequestBody PlanDto planDto){
        planService.updatePlan(planId, planDto);
    }

    @DeleteMapping("plans/delete/{planId}")
    public void deletePlan(@PathVariable Long planId){
        planService.deletePlan(planId);
    }

    ///TODO: Not Completed
    @PostMapping("plans/activate/{planid}")
    public void activateSubscription(@PathVariable Long planId){
        planService.activatePlan(planId);
    }

    ///TODO:Not Tested
    @PostMapping("plans/deactivate/{subscriptionId}")
    public void deactivateSubscription(@PathVariable Long subscriptionId){
        planService.deactivatePlan(subscriptionId);
    }

    ///TODO: Not Tested
    @PostMapping("plans/expired/{subscriptionId}")
    public void expireSubscription(@PathVariable Long subscriptionId){
        Optional<Subscription> subscriptionToExpire = subscriptionRepository.findById(subscriptionId);

        Subscription subscription = subscriptionToExpire.get();

        LocalDate expiryDate = subscription.getExpiryDate();

        if(expiryDate.isBefore(LocalDate.now())){
            planService.deactivatePlan(subscriptionId);
        }
    }
/*

    @GetMapping("report")
    public Object[] getReport(){
        return planService.report();
    }
*/
    @GetMapping("/report")
    public Long[] getTotalSubscriptionCount(){

        return planService.report();
    }

}
