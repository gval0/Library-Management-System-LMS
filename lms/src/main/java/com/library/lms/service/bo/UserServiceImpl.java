package com.library.lms.service.bo;

import com.library.lms.controller.request.CreateBookRequest;
import com.library.lms.controller.request.UpdateBookRequest;
import com.library.lms.entity.UserEntity;
import com.library.lms.exception.InternalException;
import com.library.lms.exception.InternalExceptionReason;
import com.library.lms.model.User;
import com.library.lms.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public User create(CreateBookRequest request) {
        return null;
    }

    @Override
    public User getById(Long id) {
        return null;
    }


    public UserEntity getByUserName(String username) {
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new InternalException(InternalExceptionReason.USER_NOT_FOUND, "User not found with username: " + username));
    }

    @Override
    public UserEntity getEntityById(Long id) {
        return null;
    }

    @Override
    public User update(Long id, UpdateBookRequest request) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
