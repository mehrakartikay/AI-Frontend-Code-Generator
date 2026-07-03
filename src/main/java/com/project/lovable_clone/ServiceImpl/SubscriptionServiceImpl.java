package com.project.lovable_clone.ServiceImpl;

import com.project.lovable_clone.DTO.Subscription.SubscriptionResponse;
import com.project.lovable_clone.Error.ResourceNotFoundException;
import com.project.lovable_clone.Repository.PlanRepository;
import com.project.lovable_clone.Repository.SubscriptionRepository;
import com.project.lovable_clone.Repository.UserRepository;
import com.project.lovable_clone.Service.SubscriptionService;
import com.project.lovable_clone.entity.Plan;
import com.project.lovable_clone.entity.Subscription;
import com.project.lovable_clone.entity.User;
import com.project.lovable_clone.enums.SubscriptionStatus;
import com.project.lovable_clone.mapper.SubscriptionMapper;
import com.project.lovable_clone.security.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final AuthUtil authUtil;
    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper subscriptionMapper;
    private final UserRepository userRepository;
    private final PlanRepository planRepository;

    @Override
    public SubscriptionResponse getCurrentSubscription() {
        Long userId = authUtil.getUserId();

        var currentSubscription = subscriptionRepository.findByUserIdAndStatusIn(userId, Set.of(
                SubscriptionStatus.ACTIVE,SubscriptionStatus.PAST_DUE,
                SubscriptionStatus.TRIALING
        )).orElse(
                new Subscription()
        );

        return subscriptionMapper.ToSubscriptionResponse(currentSubscription);
    }

    @Override
    public void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId) {
        boolean exists = subscriptionRepository.existsByStripeSubscriptionId(subscriptionId);

        if(exists){
            return;
        }
        User user = getUser(userId);
        Plan plan = getPlan(planId);

        Subscription subscription = Subscription.builder()
                .user(user)
                .plan(plan)
                .stripeSubscriptionId(subscriptionId)
                .status(SubscriptionStatus.INCOMPLETE)
                .build();

        subscriptionRepository.save(subscription);


    }

    @Override
    public void updateSubscription(String subscriptionId, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId) {

    }

    @Override
    public void cancelSubscription(String subscriptionId) {

    }

    @Override
    public void markSubscriptionPastDue(String gatewaySubscriptionId) {
        Subscription subscription = getSubscription(gatewaySubscriptionId);


    }

    @Override
    public void renewSubscriptionPeriod(String gatewaySubscriptionId, Instant periodStart, Instant periodEnd) {

        Subscription subscription = getSubscription(gatewaySubscriptionId);
        Instant newStart = periodStart!=null ? periodStart : subscription.getCurrentPeriodEnd();
        subscription.setCurrentPeriodStart(newStart);
        subscription.setCurrentPeriodEnd(periodEnd);

        if(subscription.getStatus().equals(SubscriptionStatus.PAST_DUE)){
            subscription.setStatus(SubscriptionStatus.ACTIVE);
        }
        subscriptionRepository.save(subscription);


    }


    //utility methods

    private User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User",userId.toString()));
    }
    private Plan getPlan(Long planId) {
        return planRepository.findById(planId).orElseThrow(()->
                new ResourceNotFoundException("Plan",planId.toString()));
    }
    private Subscription getSubscription(String gatewaySubscriptionId) {
        return subscriptionRepository.findByStripeSubscriptionId(gatewaySubscriptionId).
                orElseThrow(() -> new ResourceNotFoundException("Subscription", gatewaySubscriptionId));
    }



}
