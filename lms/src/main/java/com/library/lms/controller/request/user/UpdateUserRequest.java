package com.library.lms.controller.request.user;

import com.library.lms.entity.UserEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    @NotNull
    private String userName;

    @NotNull
    private String password;

    public UserEntity toEntity() {

        return UserEntity.builder()
                .username(userName)
                .build();

    }
}
