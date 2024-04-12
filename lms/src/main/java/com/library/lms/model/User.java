package com.library.lms.model;

import com.library.lms.entity.enums.UserRole;
import org.hibernate.usertype.UserType;

public interface User {
    Long getId();

    UserRole getUserRole();
}
