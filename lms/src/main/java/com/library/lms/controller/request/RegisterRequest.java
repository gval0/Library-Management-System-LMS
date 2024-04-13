package com.library.lms.controller.request;

import com.library.lms.entity.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

   private String userName;
   private String password;
   private UserRole userRole;
}
