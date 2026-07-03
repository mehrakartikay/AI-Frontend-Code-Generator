package com.project.lovable_clone.Service;

import com.project.lovable_clone.DTO.Subscription.PlanLimitsResponse;
import com.project.lovable_clone.DTO.Subscription.UsageTodayResponse;

public interface  UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId) ;

    PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
