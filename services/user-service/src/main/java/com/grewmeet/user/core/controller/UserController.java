package com.grewmeet.user.core.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Tag(name = "user-controller", description = "일반 사용자 서비스를 위한 컨트롤러입니다.")
@Slf4j
public class UserController {
}
