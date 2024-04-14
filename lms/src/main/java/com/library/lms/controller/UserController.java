package com.library.lms.controller;

import com.library.lms.controller.request.user.CreateUserRequest;
import com.library.lms.controller.request.user.UpdateUserRequest;
import com.library.lms.model.User;
import com.library.lms.service.bo.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<User> create(@RequestBody @Valid CreateUserRequest request) {
        return ResponseEntity.ok(userService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable("id") @Valid @NotNull Long id) {
        return ResponseEntity.ok(userService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable("id") @Valid @NotNull Long id,
                                    @RequestBody @Valid UpdateUserRequest request) {
        return ResponseEntity.ok(userService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") @Valid @NotNull Long id) {
        userService.delete(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
