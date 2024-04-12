package com.library.lms.exception;

import java.io.Serializable;

public interface ExceptionReason extends Serializable {

    int getReasonCode();

    String getReason();
}
