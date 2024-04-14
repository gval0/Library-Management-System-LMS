package com.library.lms.service.bo;

import com.library.lms.controller.request.user.CreateUserRequest;
import com.library.lms.controller.request.user.UpdateUserRequest;
import com.library.lms.entity.UserEntity;
import com.library.lms.model.User;

public interface UserService {

    User create(CreateUserRequest request);

    User getById(Long id);

    UserEntity getEntityById(Long id);

    User update(Long id, UpdateUserRequest request);

    void delete(Long id);

}
