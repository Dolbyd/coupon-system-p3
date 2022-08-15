package com.jb.couponsystemp3.controller;


import com.jb.couponsystemp3.beans.Coupon;
import com.jb.couponsystemp3.repos.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/cs/coupon")
@RequiredArgsConstructor
public class CouponsController {

    private final CouponRepository couponRepository;

    @GetMapping
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }
}
