package com.grewmeet.user.profile.event;

import com.grewmeet.user.profile.repository.ProfileRepository;
import com.grewmeet.user.profile.service.ProfileCommandService;
import com.grewmeet.user.saga.UserRegisteredEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProfileEventConsumer {

    private final ProfileCommandService profileCommandService;

    @KafkaListener(topics = "${app.kafka.topics.user-registered}", groupId = "user-service-group")
    public void handleUserRegisteredEvent(UserRegisteredEvent event) {
        log.info("회원가입 이벤트를 수신했습니다: userId={}", event.userId());

        try {
            profileCommandService.createProfileFromRegistration(
                    event.userId(),
                    event.email(),
                    event.registeredAt()
            );
        } catch (Exception e) {
            log.error("회원가입 이벤트 처리 중 오류가 발생했습니다. userId: {}, error: {}", event.userId(), e.getMessage());
        }
    }
}

