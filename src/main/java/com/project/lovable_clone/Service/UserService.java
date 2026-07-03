package com.project.lovable_clone.Service;

import com.project.lovable_clone.DTO.auth.UserProfileResponse;

public interface UserService {
    UserProfileResponse getProfile(Long userId);
}
