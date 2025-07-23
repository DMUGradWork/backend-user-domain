package com.grewmeet.user.profile.controller;

import com.grewmeet.user.profile.dto.ProfileResponse;
import com.grewmeet.user.profile.service.ProfileQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileQueryService profileQueryService;

    @Operation(summary = "사용자 프로필 조회", description = "userId로 사용자 프로필 정보를 조회합니다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/{userId}")
    public ResponseEntity<ProfileResponse> getProfile(@PathVariable String userId) {
        ProfileResponse profile = ProfileResponse.from(
                profileQueryService.getProfileByUserId(userId)
        );
        return ResponseEntity.ok(profile);
    }
}
