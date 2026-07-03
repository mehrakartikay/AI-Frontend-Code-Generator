package com.project.lovable_clone.ServiceImpl;

import com.project.lovable_clone.DTO.Subscription.PlanLimitsResponse;
import com.project.lovable_clone.DTO.Subscription.UsageTodayResponse;
import com.project.lovable_clone.Service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {

    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
