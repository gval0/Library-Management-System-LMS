package com.library.lms.controller;

import com.library.lms.controller.request.AuthRequest;
import com.library.lms.controller.request.RegisterRequest;
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
@RequestMapping("/api/auth/user")
public class UserController {

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        log.info("Registering user: {}", registerRequest);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/log-in")
    public ResponseEntity<String> register(@RequestBody AuthRequest registerRequest) {
        log.info("Registering user: {}", registerRequest);
        return ResponseEntity.ok("User registered successfully");
    }

}
