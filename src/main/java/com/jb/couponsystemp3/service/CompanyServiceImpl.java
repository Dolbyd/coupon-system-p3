package com.jb.couponsystemp3.service;

import com.jb.couponsystemp3.beans.Category;
import com.jb.couponsystemp3.beans.Company;
import com.jb.couponsystemp3.beans.Coupon;
import com.jb.couponsystemp3.beans.Customer;
import com.jb.couponsystemp3.exception.CouponSystemException;
import com.jb.couponsystemp3.exception.ErrMsg;
import com.jb.couponsystemp3.repos.CompanyRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@NoArgsConstructor

public class CompanyServiceImpl extends ClientService implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    private Company company;


    @Override
    public boolean login(String email, String password) {
        return companyRepository.existsByEmailAndPassword(email, password);
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public Company getCompanyByEmail(String email) throws CouponSystemException {
        return companyRepository.findByEmail(email).orElseThrow(() -> new CouponSystemException(ErrMsg.COMPANY_NOT_EXIST));
    }

    @Override
    public Coupon addCoupon(Coupon coupon) throws CouponSystemException {
        if (this.couponRepository.existsByCompanyAndTitle(company, coupon.getTitle())) {
            throw new CouponSystemException(ErrMsg.ADD_COUPON);
        }
        coupon.setCompany(company);
        return this.couponRepository.save(coupon);
    }

    @Override
    public Coupon updateCoupon(int couponId, Coupon coupon) throws CouponSystemException {
        Coupon preCoupon = this.getSingleCoupon(couponId);
        coupon.setId(couponId);
        if (preCoupon.getId() != coupon.getId() || preCoupon.getCompany().equals(coupon.getCompany())) {
            throw new CouponSystemException(ErrMsg.UPDATE_COUPON);
        }
        return this.couponRepository.saveAndFlush(coupon);
    }

    @Override
    public void deleteCoupon(int couponId) throws CouponSystemException {
        if (!this.couponRepository.existsById(couponId)) {
            throw new CouponSystemException(ErrMsg.COUPON_NOT_EXIST_BY_ID);
        }
        this.couponRepository.deleteById(couponId);
    }


    public List<Coupon> getAllCompanyCoupons() {
        System.out.println(company);
        return couponRepository.findByCompanyId(company.getId());
    }

    @Override
    public Coupon getSingleCoupon(int couponId) throws CouponSystemException {
        return couponRepository.findById(couponId).orElseThrow(()->new CouponSystemException(ErrMsg.COUPON_NOT_EXIST_BY_ID));


    }

    @Override
    public List<Coupon> getAllCouponByCompanyAndCategory(Category category) {
        return this.couponRepository.findByCompanyIdAndCategory(company.getId(), category);
    }

    @Override
    public List<Coupon> getAllCouponByCompanyAndUnderPrice(double price) {
        return this.couponRepository.findByCompanyIdAndPriceGreaterThan(company.getId(), price);
    }

    @Override
    public Company getCompanyDetails() throws CouponSystemException {
        return this.companyRepository.findById(company.getId()).orElseThrow(() -> new CouponSystemException(ErrMsg.COMPANY_NOT_EXIST_BY_ID));
    }


}
