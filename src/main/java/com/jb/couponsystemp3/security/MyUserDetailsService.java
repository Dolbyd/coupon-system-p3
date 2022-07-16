package com.jb.couponsystemp3.security;

import com.jb.couponsystemp3.beans.Company;
import com.jb.couponsystemp3.beans.Customer;
import com.jb.couponsystemp3.exception.CouponSystemException;
import com.jb.couponsystemp3.exception.ErrMsg;
import com.jb.couponsystemp3.repos.CompanyRepository;
import com.jb.couponsystemp3.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;

import static java.lang.String.format;


@Component
public class MyUserDetailsService implements UserDetailsService {

    @Value("${admin_email}")
    private String ADMIN_EMAIL;
    @Value("${admin_password}")
    private String ADMIN_PASSWORD;

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String usernamePart = null;
        if (username.contains(":")) {
            int cloneIndex = username.lastIndexOf(":");
            usernamePart = username.substring(0, cloneIndex);
        }
        usernamePart = usernamePart == null ? username : usernamePart;
        String usernameType = null;
        if (username.contains(":")) {
            int cloneIndex = username.lastIndexOf(":");
            usernameType = username.substring(cloneIndex + 1, username.length());
        }
        switch (usernameType){
            case "Company" :
                String finalUsernamePart = usernamePart;
                Company company = companyRepository.findByEmail(usernamePart).orElseThrow(()-> new UsernameNotFoundException(format("company : %s,not found", finalUsernamePart)));
                return new User(company.getEmail(),company.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_COMPANY")));

            case "Customer" :
                String finalUsernamePartCus = usernamePart;
                Customer customer = customerRepository.findByEmail(usernamePart).orElseThrow(()-> new UsernameNotFoundException(format("company : %s,not found", finalUsernamePartCus)));
                return new User(customer.getEmail(),customer.getPassword(), Collections.singleton(new SimpleGrantedAuthority("ROLE_CUSTOMER")));

            default:
                return new User(ADMIN_EMAIL,ADMIN_PASSWORD,Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")));
        }
    }
}
