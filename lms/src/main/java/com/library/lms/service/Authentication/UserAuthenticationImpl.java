package com.library.lms.service.Authentication;

import com.library.lms.controller.request.auth.AuthRequest;
import com.library.lms.controller.request.auth.RegisterRequest;
import com.library.lms.controller.response.RegisterAndAuthResponse;
import com.library.lms.controller.response.Response;
import com.library.lms.entity.UserEntity;
import com.library.lms.exception.InternalException;
import com.library.lms.exception.InternalExceptionReason;
import com.library.lms.repo.UserRepo;
import com.library.lms.security.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAuthenticationImpl implements UserAuthentication {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;


    @Override
    public Response register(RegisterRequest request) {

        UserEntity existingUser = userRepo.findByUsername(request.getUserName()).orElse(null);
        if (existingUser != null) {
            throw new InternalException(InternalExceptionReason.USER_ALREADY_EXISTS, "User already exists with username: " + request.getUserName());
        }

        UserEntity userEntity = request.toEntity();
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));

        UserEntity saved = userRepo.save(userEntity);

        String token = jwtService.generateToken(userEntity);

        return RegisterAndAuthResponse.builder()
                .token(token)
                .userId(saved.getId())
                .userName(saved.getUsername())
                .build();
    }

    @Override
    public Response authenticate(AuthRequest request) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));

        UserEntity userEntity = userRepo.findByUsername(request.getUserName())
                .orElseThrow(() -> new InternalException(InternalExceptionReason.USER_NOT_FOUND, "User not found"));

        String token = jwtService.generateToken(userEntity);

        return RegisterAndAuthResponse.builder()
                .token(token)
                .userId(userEntity.getId())
                .userName(userEntity.getUsername())
                .build();

    }
}
