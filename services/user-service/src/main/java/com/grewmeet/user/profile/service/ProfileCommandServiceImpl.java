package com.grewmeet.user.profile.service;

import com.grewmeet.user.profile.domain.Profile;
import com.grewmeet.user.profile.dto.ProfileResponse;
import com.grewmeet.user.profile.dto.ProfileUpdateRequest;
import com.grewmeet.user.profile.repository.ProfileRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProfileCommandServiceImpl implements ProfileCommandService {

    private final ProfileRepository profileRepository;

    @Override
    public void createProfileFromRegistration(String userId, String email, LocalDateTime registeredAt) {

        if(profileRepository.existsByUserId(userId)) {
            throw new IllegalStateException("이미 존재하는 프로필입니다: " + userId);
        }

        String randomNickname = generateRandomNickname();
        Profile profile = Profile.of(userId, email, randomNickname, registeredAt);
        profileRepository.save(profile);
    }

    @Override
    public ProfileResponse updateProfile(String userId, ProfileUpdateRequest request) {
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("프로필을 찾을 수 없습니다: " + userId));
        
        profile.updateProfile(request.nickname());
        Profile savedProfile = profileRepository.save(profile);
        
        return ProfileResponse.from(savedProfile);
    }

    private String generateRandomNickname() {
        return "User" + UUID.randomUUID().toString().substring(0, 8);
    }
}
