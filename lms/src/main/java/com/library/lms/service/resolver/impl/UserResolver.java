package com.library.lms.service.resolver.impl;

import com.library.lms.entity.UserEntity;
import com.library.lms.exception.InternalException;
import com.library.lms.exception.InternalExceptionReason;
import com.library.lms.model.Transaction;
import com.library.lms.service.bo.UserService;
import com.library.lms.service.resolver.Resolver;
import com.library.lms.util.Mapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserResolver implements Resolver {

    private final UserService userService;

    @Override
    public Transaction resolve(Transaction transaction) {

        UserEntity entity = userService.getEntityById(transaction.getUser().getId());

        if(transaction.getUser() == null || transaction.getUser().getId() == null) {
            throw  new InternalException(InternalExceptionReason.GENERAL_ERROR, "User id not valid");
        }

        transaction.updateUser(Mapper.getUser(entity));
        transaction.updateUserEntity(entity);

        return transaction;
    }
}
