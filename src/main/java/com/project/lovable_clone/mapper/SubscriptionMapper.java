package com.project.lovable_clone.mapper;


import com.project.lovable_clone.DTO.Subscription.PlanResponse;
import com.project.lovable_clone.DTO.Subscription.SubscriptionResponse;
import com.project.lovable_clone.entity.Plan;
import com.project.lovable_clone.entity.Subscription;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    SubscriptionResponse ToSubscriptionResponse(Subscription subscription);

    PlanResponse ToPlanResponse(Plan plan);
}
