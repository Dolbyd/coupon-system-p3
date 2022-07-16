package com.jb.couponsystemp3.security;

import com.jb.couponsystemp3.beans.Customer;
import com.jb.couponsystemp3.exception.CouponSecurityException;
import com.jb.couponsystemp3.exception.CouponSystemException;
import com.jb.couponsystemp3.exception.SecMsg;
import com.jb.couponsystemp3.repos.CustomerRepository;
import com.jb.couponsystemp3.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
@RequiredArgsConstructor
public class LoginManager  {


    @Autowired
    private AdminService adminService;

       private final ApplicationContext applicationContext;


    public ClientService login(String email, String password, ClientType clientType) throws CouponSystemException {
        switch (clientType) {
            case Administrator: {
                if (adminService.login(email, password)) {
                    return (ClientService) adminService;
                }
            }
            case Company: {
                CompanyService companyService = applicationContext.getBean(CompanyService.class);
                if (companyService.login(email, password)) {
                    companyService.setCompany(companyService.getCompanyByEmail(email));
                    return (ClientService) companyService;
                }
            }
            case Customer: {
                CustomerService customerService = applicationContext.getBean(CustomerService.class);
                if (customerService.login(email, password)) {
                    customerService.setCustomer(customerService.getCustomerByEmail(email));
                    return (ClientService) customerService;
                }
            }
        }
        return null;


    }

}
