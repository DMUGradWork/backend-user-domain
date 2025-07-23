package com.grewmeet.user.profile.domain;

import com.grewmeet.user.common.domain.BaseEntity;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile extends BaseEntity {

    private String userId;
    private String email;
    private String nickname;
    private LocalDateTime registeredAt;

    private Profile(String userId, String email, String nickname, LocalDateTime registeredAt) {
        this.userId = userId;
        this.email = email;
        this.nickname = nickname;
        this.registeredAt = registeredAt;
    }

    public static Profile of(String userId, String email, String nickname, LocalDateTime registeredAt) {
        return new Profile(userId, email, nickname, registeredAt);
    }
}
