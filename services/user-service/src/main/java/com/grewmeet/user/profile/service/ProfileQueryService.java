package com.grewmeet.user.profile.service;

import com.grewmeet.user.profile.domain.Profile;

public interface ProfileQueryService {
    Profile getProfileByUserId(String userId);
}