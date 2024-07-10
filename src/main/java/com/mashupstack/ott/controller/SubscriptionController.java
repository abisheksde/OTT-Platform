package com.mashupstack.ott.controller;

import com.mashupstack.ott.dto.PlanDto;
import com.mashupstack.ott.models.Subscription;
import com.mashupstack.ott.models.SubscriptionPlans;
import com.mashupstack.ott.repository.SubscriptionPlanRepository;
import com.mashupstack.ott.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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



    @GetMapping("plans")
    public String planList(Model model){
        List<SubscriptionPlans> plans = subscriptionPlanRepository.findAll();
        model.addAttribute("plan", plans);

        return "plan-page";
    }

    @PostMapping("plans/create")
    public void createPlan(@RequestBody PlanDto planDto){
        SubscriptionPlans subscriptionPlans = new SubscriptionPlans(planDto.getValidity(), planDto.getPrice());

        subscriptionPlanRepository.save(subscriptionPlans);
    }

    @PutMapping("plans/update/{planId}")
    public void updatePlan(@PathVariable Long planId, @RequestBody PlanDto planDto){
        Optional<SubscriptionPlans> optionalPlan = subscriptionPlanRepository.findById(planId);

        SubscriptionPlans plan = optionalPlan.get();

        plan.setValidity(planDto.getValidity());
        plan.setPrice(planDto.getPrice());

        System.out.println(planId);
        subscriptionPlanRepository.save(plan);
    }

    @DeleteMapping("plans/delete/{planId}")
    public void deletePlan(@PathVariable Long planId){
        subscriptionPlanRepository.deleteById(planId);
    }

    ///TODO: Not Completed
    @PostMapping("plans/activate/{planid}")
    public void activateSubscription(@PathVariable Long planId){
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

    ///TODO:Not Tested
    @PostMapping("plans/deactivate/{subscriptionId}")
    public void deactivateSubscription(@PathVariable Long subscriptionId){
        Optional<Subscription> optionalPlan = subscriptionRepository.findById(subscriptionId);
        Subscription subscriptionToDeactivate = optionalPlan.get();

        if(subscriptionToDeactivate.isActive()){
            subscriptionToDeactivate.setActive(false);
        }

        subscriptionRepository.save(subscriptionToDeactivate);
    }

    ///TODO: Not Tested
    @PostMapping("plans/expired/{subscriptionId}")
    public boolean expireSubscription(@PathVariable Long subscriptionId){
        Optional<Subscription> subscriptionToExpire = subscriptionRepository.findById(subscriptionId);

        Subscription subscription = subscriptionToExpire.get();

        LocalDate expiryDate = subscription.getExpiryDate();

        if(expiryDate.isBefore(LocalDate.now())){
            Optional<Subscription> optionalPlan = subscriptionRepository.findById(subscriptionId);
            Subscription subscriptionToDeactivate = optionalPlan.get();

            if(subscriptionToDeactivate.isActive()){
                subscriptionToDeactivate.setActive(false);
            }

            subscriptionRepository.save(subscriptionToDeactivate);
            return false;
        }

        return true;
    }
/*

    @GetMapping("report")
    public Object[] getReport(){
        return planService.report();
    }
*/
    @GetMapping("/report")
    public Long[] getTotalSubscriptionCount(){

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
