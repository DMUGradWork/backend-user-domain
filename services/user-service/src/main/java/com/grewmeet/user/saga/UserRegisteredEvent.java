package com.grewmeet.user.saga;


import java.time.LocalDateTime;

public record UserRegisteredEvent(
        String email,
        String userId,
        LocalDateTime registeredAt
) {}