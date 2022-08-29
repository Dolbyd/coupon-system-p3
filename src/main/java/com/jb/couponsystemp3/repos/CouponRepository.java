package com.jb.couponsystemp3.repos;

import com.jb.couponsystemp3.beans.Category;
import com.jb.couponsystemp3.beans.Company;
import com.jb.couponsystemp3.beans.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    boolean existsByCompanyAndTitle(Company company, String title);

    List<Coupon> findByCompanyIdAndCategory(int companyId, Category category);

    List<Coupon> findByCompanyIdAndPriceGreaterThan(int companyId, double price);

    @Query(value = "select exists(select * from `spring-cs3`.coupons where id in (SELECT coupons_id FROM `spring-cs3`.customers_coupons  where customer_id = :customerId and coupons_id = :couponId)) as res;\n", nativeQuery = true)
    long existsByCustomerAndCoupon(@Param("customerId") int customerId, @Param("couponId") int couponId);

    @Query(value = "select * from `spring-cs3`.coupons where id in (SELECT coupons_id FROM `spring-cs3`.customers_coupons  where customer_id = :customerId )", nativeQuery = true)
    List<Coupon> getAllCustomerCoupons(@Param("customerId") int customerId);

    @Query(value = "select * from `spring-cs3`.coupons where id in (SELECT coupons_id FROM `spring-cs3`.customers_coupons  where customer_id = :customerId and category = :category)", nativeQuery = true)
    List<Coupon> getAllCustomerCouponsByCategory(@Param("customerId") int customerId, @Param("category") String category);

    @Query(value = "select * from `spring-cs3`.coupons where id in (SELECT coupons_id FROM `spring-cs3`.customers_coupons  where customer_id = :customerId and price < :price)\n", nativeQuery = true)
    List<Coupon> getAllCustomerCouponsUnderPrice(@Param("customerId") int customerId, @Param("price") double price);


    void deleteByEndDateBefore(Date localDate);

    List<Coupon> findByCompanyId(int companyId);
}