package com.jb.couponsystemp3.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SecMsg {

    EMAIL_ALREADY_EXIST("email already exist..", HttpStatus.CONFLICT);


    private final String message;
    private final HttpStatus status;

    SecMsg(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
