package com.zerobase.exception.impl;

import com.zerobase.exception.AbstractException;
import org.springframework.http.HttpStatus;

public class NoParamException extends AbstractException {
    @Override
    public int getStatusCode() {
        return HttpStatus.BAD_REQUEST.value();
    }

    @Override
    public String getMessage() {
        return "입력값이 없습니다.";
    }
}
