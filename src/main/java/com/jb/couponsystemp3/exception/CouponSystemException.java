package com.jb.couponsystemp3.exception;

public class CouponSystemException extends Exception {

    public CouponSystemException(ErrMsg errMsg) {
        super(errMsg.getMessage());
    }
}
