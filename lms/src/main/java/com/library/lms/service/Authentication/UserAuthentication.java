package com.library.lms.service.Authentication;

import com.library.lms.controller.request.auth.AuthRequest;
import com.library.lms.controller.request.auth.RegisterRequest;
import com.library.lms.controller.response.Response;

public interface UserAuthentication {

    Response register(RegisterRequest request);

    Response authenticate(AuthRequest request);

}
