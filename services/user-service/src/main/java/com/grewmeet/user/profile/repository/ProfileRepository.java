package com.grewmeet.user.profile.repository;

import com.grewmeet.user.profile.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    boolean existsByUserId(String userId);
    Optional<Profile> findByUserId(String userId);
}
