package com.project.lovable_clone.ServiceImpl;

import com.project.lovable_clone.DTO.Subscription.PlanResponse;
import com.project.lovable_clone.Service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {


    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
