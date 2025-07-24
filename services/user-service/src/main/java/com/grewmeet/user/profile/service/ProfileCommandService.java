package com.grewmeet.user.profile.service;

import com.grewmeet.user.profile.dto.ProfileResponse;
import com.grewmeet.user.profile.dto.ProfileUpdateRequest;
import java.time.LocalDateTime;

public interface ProfileCommandService {
    void createProfileFromRegistration(String userId, String email, LocalDateTime registrationDate);
    ProfileResponse updateProfile(String userId, ProfileUpdateRequest request);
}
