package com.grewmeet.user.profile.controller;

import com.grewmeet.user.profile.dto.ProfileResponse;
import com.grewmeet.user.profile.dto.ProfileUpdateRequest;
import com.grewmeet.user.profile.service.ProfileCommandService;
import com.grewmeet.user.profile.service.ProfileQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileQueryService profileQueryService;
    private final ProfileCommandService profileCommandService;

    @Operation(summary = "전체 사용자 프로필 조회", description = "등록된 모든 사용자 프로필 목록을 조회합니다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping
    public ResponseEntity<List<ProfileResponse>> getAllProfiles() {
        return ResponseEntity.ok(profileQueryService.getAllProfiles());
    }

    @Operation(summary = "사용자 프로필 조회", description = "userId로 사용자 프로필 정보를 조회합니다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @GetMapping("/{userId}")
    public ResponseEntity<ProfileResponse> getProfile(@PathVariable String userId) {
        return ResponseEntity.ok(profileQueryService.getProfileByUserId(userId));
    }

    @Operation(summary = "사용자 프로필 업데이트", description = "userId로 사용자 프로필을 부분 업데이트합니다")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
    })
    @PatchMapping("/{userId}")
    public ResponseEntity<ProfileResponse> updateProfile(
            @PathVariable String userId,
            @Valid @RequestBody ProfileUpdateRequest request) {
        ProfileResponse response = profileCommandService.updateProfile(userId, request);
        return ResponseEntity.ok(response);
    }
}
