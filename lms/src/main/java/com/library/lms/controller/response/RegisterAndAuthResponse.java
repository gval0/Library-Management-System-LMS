package com.library.lms.controller.response;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterAndAuthResponse implements Response {

    @NotNull
    private Long userId;

    @NotNull
    private String userName;

    @NotNull
    private String token;

}
