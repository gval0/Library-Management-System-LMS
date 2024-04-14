package com.library.lms.controller.request.auth;

import com.library.lms.entity.UserEntity;
import com.library.lms.entity.enums.UserRole;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotNull
    private String userName;

    @NotNull
    private String password;

    public UserEntity toEntity() {

        return UserEntity.builder()
                .username(userName)
                .userRole(UserRole.LIBRARY_USER)
                .build();

    }

}
