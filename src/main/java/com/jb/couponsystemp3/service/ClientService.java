package com.jb.couponsystemp3.service;

import com.jb.couponsystemp3.exception.CouponSystemException;
import com.jb.couponsystemp3.repos.CompanyRepository;
import com.jb.couponsystemp3.repos.CouponRepository;
import com.jb.couponsystemp3.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class ClientService {

    @Autowired
    protected CouponRepository couponRepository;
    @Autowired
    protected CustomerRepository customerRepository;
    @Autowired
    protected CompanyRepository companyRepository;

    public abstract boolean login(String email, String password) throws CouponSystemException;
}
