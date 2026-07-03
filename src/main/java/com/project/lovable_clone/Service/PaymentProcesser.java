package com.project.lovable_clone.Service;

import com.project.lovable_clone.DTO.Subscription.CheckoutRequest;
import com.project.lovable_clone.DTO.Subscription.CheckoutResponse;
import com.project.lovable_clone.DTO.Subscription.PortalResponse;
import com.stripe.model.StripeObject;

import java.util.Map;

public interface PaymentProcesser {

    PortalResponse openCustomerPortal();

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);


    void handleWebhookEvent(String type, StripeObject stripeObject, Map<String, String> metadata);
}
