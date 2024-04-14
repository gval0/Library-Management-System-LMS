package com.library.lms.controller;

import com.library.lms.controller.request.auth.AuthRequest;
import com.library.lms.controller.request.auth.RegisterRequest;
import com.library.lms.controller.response.Response;
import com.library.lms.service.Authentication.UserAuthentication;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final UserAuthentication userAuthentication;

    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody @Valid RegisterRequest request) {
        return ResponseEntity.ok(userAuthentication.register(request));
    }

    @PostMapping("/log_in")
    public ResponseEntity<Response> register(@RequestBody @Valid AuthRequest request) {
        return ResponseEntity.ok(userAuthentication.authenticate(request));
    }

}
