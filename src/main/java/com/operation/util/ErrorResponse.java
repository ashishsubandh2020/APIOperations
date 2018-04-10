package com.operation.util;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by hudapeng on 4/3/16.
 */
@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Wrong input")
public class ErrorResponse {
    String errorCode;
    String message;

    public ErrorResponse(String errorCode, String message) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}