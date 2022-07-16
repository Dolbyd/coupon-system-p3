package com.jb.couponsystemp3.advice;


import com.jb.couponsystemp3.exception.CouponSecurityException;
import com.jb.couponsystemp3.exception.CouponSystemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CouponSystemControllerAdvice {

    @ExceptionHandler(value = {CouponSystemException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrDetails handleError(Exception e) {
        return new ErrDetails("CouponSystem", e.getMessage());
    }

    @ExceptionHandler(value = {CouponSecurityException.class})
    public ResponseEntity<?> handleSecException(CouponSecurityException e) {
        return new ResponseEntity<>(e.getSecMsg().getMessage(),e.getSecMsg().getStatus());
    }


}


