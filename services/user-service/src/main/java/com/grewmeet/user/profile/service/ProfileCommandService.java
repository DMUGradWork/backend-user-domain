package com.grewmeet.user.profile.service;

import java.time.LocalDateTime;

public interface ProfileCommandService {
    void createProfileFromRegistration(String userId, String email, LocalDateTime registrationDate);
}
