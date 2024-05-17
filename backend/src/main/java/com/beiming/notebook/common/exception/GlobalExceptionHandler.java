package com.beiming.notebook.common.exception;

import com.beiming.notebook.common.response.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R<?> exceptionHandler(Exception e) {
        switch (e) {
            case NotLoginException exception -> {
                return R.error(exception);
            }
            case NotPermissionException exception -> {
                return R.error(exception);
            }
            case CustomerException exception -> {
                log.error(exception.getMessage(), exception);
                return R.error(exception);
            }
            case null, default -> {
                log.error("系统错误", e);
                return R.error(e);
            }
        }
    }
}