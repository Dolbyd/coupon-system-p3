package com.jb.couponsystemp3.exception;


import lombok.Data;

@Data
public class CouponSecurityException extends Exception{


    private SecMsg secMsg;

    public CouponSecurityException(SecMsg secMsg) {
        super(secMsg.getMessage());
        this.secMsg = secMsg;
    }
}
