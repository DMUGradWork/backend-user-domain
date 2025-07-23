package com.grewmeet.user.profile.service;

import com.grewmeet.user.profile.domain.Profile;
import com.grewmeet.user.profile.repository.ProfileRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileCommandServiceImpl implements ProfileCommandService {

    private final ProfileRepository profileRepository;

    @Override
    public void createProfileFromRegistration(String userId, String email, LocalDateTime registeredAt) {

        if(profileRepository.existsByUserId(userId)) {
            return;
        }

        String randomNickname = generateRandomNickname();
        Profile profile = Profile.of(userId, email, randomNickname, registeredAt);
        profileRepository.save(profile);
    }

    private String generateRandomNickname() {
        return "User" + UUID.randomUUID().toString().substring(0, 8);
    }
}
