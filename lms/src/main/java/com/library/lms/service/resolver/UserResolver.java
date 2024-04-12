package com.library.lms.service.resolver;

import com.library.lms.entity.UserEntity;
import com.library.lms.entity.enums.UserRole;
import com.library.lms.exception.InternalException;
import com.library.lms.exception.InternalExceptionReason;
import com.library.lms.model.Transaction;
import com.library.lms.repo.UserRepo;
import com.library.lms.util.Mapper;

public class UserResolver implements Resolver {

    private UserRepo userRepo;

    @Override
    public Transaction resolve(Transaction transaction) {

        UserEntity entity = userRepo.findById(transaction.getUser().getId())
                .orElseThrow(() -> new InternalException(InternalExceptionReason.USER_NOT_FOUND, "User not found with id: " + transaction.getUser().getId()));

        transaction.updateUser(Mapper.getUser(entity));
        transaction.updateUserEntity(entity);

        return transaction;
    }
}
