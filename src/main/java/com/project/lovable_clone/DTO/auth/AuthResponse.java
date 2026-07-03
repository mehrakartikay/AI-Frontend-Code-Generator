package com.project.lovable_clone.DTO.auth;

public record AuthResponse(
        String token,
        UserProfileResponse user
) {
}
