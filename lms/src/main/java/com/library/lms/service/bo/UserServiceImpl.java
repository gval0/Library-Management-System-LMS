package com.library.lms.service.bo;

import com.library.lms.controller.request.user.CreateUserRequest;
import com.library.lms.controller.request.user.UpdateUserRequest;
import com.library.lms.entity.UserEntity;
import com.library.lms.exception.InternalException;
import com.library.lms.exception.InternalExceptionReason;
import com.library.lms.model.User;
import com.library.lms.repo.UserRepo;
import com.library.lms.util.Mapper;
import com.library.lms.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    @Override
    public User create(CreateUserRequest request) {

        UserEntity existingUser = userRepo.findByUsername(request.getUsername()).orElse(null);
        if (existingUser != null) {
            throw new InternalException(InternalExceptionReason.USER_ALREADY_EXISTS, "User already exists with username: " + request.getUsername());
        }

        UserEntity userEntity = request.toEntity();
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));

        return Mapper.getUser(userRepo.save(userEntity));

    }

    @Override
    public User getById(Long id) {

        return Mapper.getUser(userRepo.findById(id)
                .orElseThrow(() -> new InternalException(InternalExceptionReason.USER_NOT_FOUND, "User not found with id: " + id)));

    }

    @Override
    public UserEntity getEntityById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new InternalException(InternalExceptionReason.USER_NOT_FOUND, "User not found with id: " + id));

    }

    @Override
    public User update(Long id, UpdateUserRequest request) {

        userRepo.findById(id)
                .orElseThrow(() -> new InternalException(InternalExceptionReason.USER_NOT_FOUND, "User not found with id: " + id));

        UserEntity userEntity = request.toEntity();
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));

        return Mapper.getUser(userRepo.save(userEntity));
    }

    @Override
    public void delete(Long id) {
        userRepo.delete(userRepo.findById(id)
                .orElseThrow(() -> new InternalException(InternalExceptionReason.USER_NOT_FOUND, "User not found with id: " + id)));
    }

}
