package com.jb.couponsystemp3.service;

import com.jb.couponsystemp3.beans.Company;
import com.jb.couponsystemp3.beans.Customer;
import com.jb.couponsystemp3.exception.CouponSystemException;

import java.util.List;

public interface AdminService {

    boolean login(String email, String password);

    void addCompany(Company company) throws CouponSystemException;

    void updateCompany(int companyId, Company company) throws CouponSystemException;

    void deleteCompany(int companyId) throws CouponSystemException;

    List<Company> getAllCompanies();

    Company getSingleCompany(int companyId) throws CouponSystemException;

    void addCustomer(Customer customer) throws CouponSystemException;

    void updateCustomer(int customerId, Customer customer) throws CouponSystemException;

    void deleteCustomer(int customerId) throws CouponSystemException;

    List<Customer> getAllCustomers();

    Customer getSingleCustomer(int customerId) throws CouponSystemException;

}
