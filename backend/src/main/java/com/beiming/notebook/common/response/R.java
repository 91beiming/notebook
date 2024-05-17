package com.beiming.notebook.common.response;

import com.beiming.notebook.common.constant.Constant;
import com.beiming.notebook.common.exception.CustomerException;
import com.beiming.notebook.common.exception.NotLoginException;
import com.beiming.notebook.common.exception.NotPermissionException;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class R<T> {

    private Integer code;

    private String message;

    private T data;

    private String responseId;

    public R() {
        this.responseId = MDC.get(Constant.TRACE_ID_KEY);
    }

    public R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.responseId = MDC.get(Constant.TRACE_ID_KEY);

    }

    public static <T> R<T> ok(T data) {
        return new R<>(HttpStatus.OK.value(), "success", data);
    }

    public static R<?> error(CustomerException e) {
        return new R<>(502, e.getMessage(), null);
    }

    public static R<?> error(@Nullable Throwable throwable) {
        return new R<>(500, throwable == null ? null : throwable.getMessage(), null);
    }

    public static R<?> error(NotLoginException e) {
        return new R<>(401, e.getMessage(), null);
    }

    public static R<?> error(NotPermissionException e) {
        return new R<>(403, e.getMessage(), null);
    }
}