package com.grewmeet.user.profile.service;

import com.grewmeet.user.profile.dto.ProfileResponse;
import java.util.List;

public interface ProfileQueryService {
    ProfileResponse getProfileByUserId(String userId);
    List<ProfileResponse> getAllProfiles();
}