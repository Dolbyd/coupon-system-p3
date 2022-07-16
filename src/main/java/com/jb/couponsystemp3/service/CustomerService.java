package com.jb.couponsystemp3.service;

import com.jb.couponsystemp3.beans.Category;
import com.jb.couponsystemp3.beans.Coupon;
import com.jb.couponsystemp3.beans.Customer;
import com.jb.couponsystemp3.exception.CouponSystemException;

import java.util.List;

public interface CustomerService {

    boolean login(String email, String password);

    void setCustomer(Customer customer);

    Customer getCustomerByEmail(String email) throws CouponSystemException;

    void purchaseCoupon(Coupon coupon) throws CouponSystemException;

    List<Coupon> getAllCustomerCoupon();

    List<Coupon> getCustomerCouponByCategory(Category category);

    List<Coupon> getCustomerCouponsUnderPrice(double maxPrice);

    Customer getCustomerDetails() throws CouponSystemException;
}
