package com.beiming.notebook.common.exception;

import lombok.Getter;

import java.io.Serial;

@Getter
public class NotLoginException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -8152694207779998465L;

    public NotLoginException(String message) {
        super(message);
    }
}