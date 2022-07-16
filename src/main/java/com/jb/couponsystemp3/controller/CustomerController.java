package com.jb.couponsystemp3.controller;

import com.jb.couponsystemp3.beans.Category;
import com.jb.couponsystemp3.beans.Coupon;
import com.jb.couponsystemp3.beans.Customer;
import com.jb.couponsystemp3.exception.CouponSystemException;
import com.jb.couponsystemp3.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cs/customer")
@RequiredArgsConstructor
public class CustomerController {


    private final CustomerService customerService;


    @PutMapping("/purchase")
    public void purchaseCoupon(@RequestBody Coupon coupon) throws CouponSystemException {
        customerService.purchaseCoupon(coupon);
    }

    @GetMapping
    public List<Coupon> getAllCustomerCoupon() {
        return customerService.getAllCustomerCoupon();
    }

    @GetMapping("/coupons/by/category")
    public List<Coupon> getCustomerCouponByCategory(Category category) {
        return customerService.getCustomerCouponByCategory(category);
    }

    @GetMapping("/coupons/by/maxPrise")
    public List<Coupon> getCustomerCouponsUnderPrice(double maxPrice) {
        return customerService.getCustomerCouponsUnderPrice(maxPrice);
    }

    @GetMapping("/details")
    public Customer getCustomerDetails() throws CouponSystemException {
        return customerService.getCustomerDetails();
    }
}
