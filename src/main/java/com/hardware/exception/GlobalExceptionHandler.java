package com.hardware.exception;

import com.hardware.common.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(LoginFailedException.class)
    public Result<Object> handleLoginFailed(LoginFailedException e) {
        return Result.error(401, e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public Result<Object> handleRuntime(RuntimeException e) {
        return Result.error(e.getMessage());
    }
}
