package com.jb.couponsystemp3.service;

import com.jb.couponsystemp3.beans.Category;
import com.jb.couponsystemp3.beans.Company;
import com.jb.couponsystemp3.beans.Coupon;
import com.jb.couponsystemp3.exception.CouponSystemException;

import java.util.List;

public interface CompanyService {

    boolean login(String email, String password);

    void setCompany(Company company);

    Company getCompanyByEmail(String email) throws CouponSystemException;

    Coupon addCoupon(Coupon coupon) throws CouponSystemException;

    Coupon updateCoupon(int couponId, Coupon coupon) throws CouponSystemException;

    void deleteCoupon(int couponId) throws CouponSystemException;

    List<Coupon> getAllCompanyCoupons();

    Coupon getSingleCoupon(int couponId) throws CouponSystemException;

    List<Coupon> getAllCouponByCompanyAndCategory(Category category);

    List<Coupon> getAllCouponByCompanyAndUnderPrice(double price);

    Company getCompanyDetails() throws CouponSystemException;


}
