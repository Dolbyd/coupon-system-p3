package com.jb.couponsystemp3.service;

import com.jb.couponsystemp3.beans.Company;
import com.jb.couponsystemp3.beans.Customer;
import com.jb.couponsystemp3.exception.CouponSystemException;
import com.jb.couponsystemp3.exception.ErrMsg;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class AdminServiceImpl extends ClientService implements AdminService {


    @Override
    public boolean login(String email, String password) {
        return (email.equals("admin@admin.com") && password.equals("admin"));
    }

    @Override
    public Company addCompany(Company company) throws CouponSystemException {
        if (companyRepository.existsByNameOrEmail(company.getName(), company.getEmail())) {
            throw new CouponSystemException(ErrMsg.COMPANY_NAME_OR_EMAIL_EXIST);
        }
        return companyRepository.save(company);
    }

    @Override
    public Company updateCompany(int companyId, Company company) throws CouponSystemException {
        Company preCompany = this.getSingleCompany(companyId);
        company.setId(companyId);
        if (!preCompany.getName().equals(company.getName()) || (preCompany.getId() != company.getId())) {
            throw new CouponSystemException(ErrMsg.UPDATE_COMPANY);
        }
        return companyRepository.saveAndFlush(company);
    }

    @Override
    public void deleteCompany(int companyId) throws CouponSystemException {
        if (!companyRepository.existsById(companyId)) {
            throw new CouponSystemException(ErrMsg.COMPANY_NOT_EXIST_BY_ID);
        }
        this.companyRepository.deleteById(companyId);
    }

    @Override
    public List<Company> getAllCompanies() {
        return this.companyRepository.findAll();
    }

    @Override
    public Company getSingleCompany(int companyId) throws CouponSystemException {
        return companyRepository.findById(companyId).orElseThrow(() -> new CouponSystemException(ErrMsg.COMPANY_NOT_EXIST_BY_ID));
    }

    @Override
    public Customer addCustomer(Customer customer) throws CouponSystemException {
        if (this.customerRepository.existsByEmail(customer.getEmail())) {
            throw new CouponSystemException(ErrMsg.ADD_COUPON);
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(int customerId, Customer customer) throws CouponSystemException {
        Customer preCustomer = this.getSingleCustomer(customerId);
        customer.setId(customerId);
        if (preCustomer.getId() != customer.getId()) {
            throw new CouponSystemException(ErrMsg.UPDATE_CUSTOMER);
        }
        return customerRepository.saveAndFlush(customer);
    }

    @Override
    public void deleteCustomer(int customerId) throws CouponSystemException {
        if (!this.customerRepository.existsById(customerId)) {
            throw new CouponSystemException(ErrMsg.CUSTOMER_NOT_EXIST_BY_ID);
        }
        this.customerRepository.deleteById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer getSingleCustomer(int customerId) throws CouponSystemException {
        return customerRepository.findById(customerId).orElseThrow(() -> new CouponSystemException(ErrMsg.CUSTOMER_NOT_EXIST_BY_ID));
    }


}
