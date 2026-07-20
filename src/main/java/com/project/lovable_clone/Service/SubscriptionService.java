package com.project.lovable_clone.Service;

import com.project.lovable_clone.DTO.Subscription.SubscriptionResponse;
import com.project.lovable_clone.enums.SubscriptionStatus;

import java.time.Instant;

public interface SubscriptionService {
    public SubscriptionResponse getCurrentSubscription() ;


    void activateSubscription(Long userId, Long planId, String subscriptionId, String customerId);

    void updateSubscription(String subscriptionId, SubscriptionStatus status, Instant periodStart, Instant periodEnd, Boolean cancelAtPeriodEnd, Long planId);

    void cancelSubscription(String gatewaySubscriptionId);

    void markSubscriptionPastDue(String subId);

    void renewSubscriptionPeriod(String subId, Instant periodStart, Instant periodEnd);

    boolean canCreateNewProject();
}
