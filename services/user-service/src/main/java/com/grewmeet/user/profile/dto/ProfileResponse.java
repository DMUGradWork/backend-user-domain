package com.grewmeet.user.profile.dto;

import com.grewmeet.user.profile.domain.Profile;
import java.time.LocalDateTime;

public record ProfileResponse(
        String userId,
        String email,
        String nickname,
        LocalDateTime registeredAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ProfileResponse from(Profile profile) {
        return new ProfileResponse(
                profile.getUserId(),
                profile.getEmail(),
                profile.getNickname(),
                profile.getRegisteredAt(),
                profile.getCreatedAt(),
                profile.getUpdatedAt()
        );
    }
}