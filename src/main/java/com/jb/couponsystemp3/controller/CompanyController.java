package com.jb.couponsystemp3.controller;

import com.jb.couponsystemp3.beans.Category;
import com.jb.couponsystemp3.beans.Company;
import com.jb.couponsystemp3.beans.Coupon;
import com.jb.couponsystemp3.beans.Customer;
import com.jb.couponsystemp3.exception.CouponSystemException;
import com.jb.couponsystemp3.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cs/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Coupon addCoupon(@RequestBody Coupon coupon) throws CouponSystemException {
        return companyService.addCoupon(coupon);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Coupon updateCoupon(@PathVariable int id, @RequestBody Coupon coupon) throws CouponSystemException {
        return companyService.updateCoupon(id, coupon);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoupon(@PathVariable int id) throws CouponSystemException {
        companyService.deleteCoupon(id);
    }

    @GetMapping
    public List<Coupon> getAllCompanyCoupons() {
        return companyService.getAllCompanyCoupons();
    }

    @GetMapping("/coupon/{id}")
    public Coupon getSingleCoupon(@PathVariable int id) throws CouponSystemException {
        return companyService.getSingleCoupon(id);
    }

    @GetMapping("/coupons/by/category")
    public List<Coupon> getAllCouponByCompanyAndCategory(Category category) {
        return companyService.getAllCouponByCompanyAndCategory(category);
    }

    @GetMapping("/coupons/by/price")
    public List<Coupon> getAllCouponByCompanyAndUnderPrice(double price) {
        return companyService.getAllCouponByCompanyAndUnderPrice(price);
    }

    @GetMapping("/details")
    public Company getCompanyDetails() throws CouponSystemException {
        return companyService.getCompanyDetails();
    }
}
