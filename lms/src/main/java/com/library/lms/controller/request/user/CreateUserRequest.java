package com.library.lms.controller.request.user;

import com.library.lms.entity.UserEntity;
import com.library.lms.entity.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {

    private String username;

    private String password;

    private UserRole userRole;

    public UserEntity toEntity() {

        return UserEntity.builder()
                .username(username)
                .userRole(userRole)
                .build();

    }
}
