package com.library.lms.service.bo;

import com.library.lms.controller.request.CreateBookRequest;
import com.library.lms.controller.request.UpdateBookRequest;
import com.library.lms.entity.UserEntity;
import com.library.lms.model.User;

public interface UserService {
    User create(CreateBookRequest request);
    User getById(Long id);
    UserEntity getEntityById(Long id);
    UserEntity getByUserName(String username);
    User update(Long id, UpdateBookRequest request);
    void delete(Long id);
}
