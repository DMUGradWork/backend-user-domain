package com.grewmeet.user.profile.service;

import com.grewmeet.user.profile.domain.Profile;
import com.grewmeet.user.profile.dto.ProfileResponse;
import com.grewmeet.user.profile.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileQueryServiceImpl implements ProfileQueryService {

    private final ProfileRepository profileRepository;

    @Override
    public ProfileResponse getProfileByUserId(String userId) {
        Profile profile = profileRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("프로필을 찾을 수 없습니다: " + userId));
        return ProfileResponse.from(profile);
    }

    @Override
    public List<ProfileResponse> getAllProfiles() {
        return profileRepository.findAll()
                .stream()
                .map(ProfileResponse::from)
                .collect(Collectors.toList());
    }
}