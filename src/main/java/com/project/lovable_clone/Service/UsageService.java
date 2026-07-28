package com.project.lovable_clone.Service;

import com.project.lovable_clone.DTO.Subscription.PlanLimitsResponse;
import com.project.lovable_clone.DTO.Subscription.UsageTodayResponse;

public interface  UsageService {
    void recordTokenUsage(Long userId, int actualTokens);
    void checkDailyTokensUsage();
}
