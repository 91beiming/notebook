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
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

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
        this();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 只展示最多30个字的错误信息
     *
     * @return
     */
    public String getMessage() {
        if (message.length() > 30) {
            return message.substring(0, 30);
        }
        return message;
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

    public static R<?> error(BindException e) {
        List<String> msgList = new ArrayList<>();
        for (ObjectError objectError : e.getAllErrors()) {
            msgList.add(objectError.getDefaultMessage());
        }
        return new R<>(502, msgList.toString(), null);
    }
}