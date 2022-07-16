package com.jb.couponsystemp3.controller;


import com.jb.couponsystemp3.beans.LoginParams;
import com.jb.couponsystemp3.exception.CouponSystemException;
import com.jb.couponsystemp3.exception.ErrMsg;
import com.jb.couponsystemp3.repos.CompanyRepository;
import com.jb.couponsystemp3.repos.CustomerRepository;
import com.jb.couponsystemp3.security.JWTUtil;
import com.jb.couponsystemp3.security.MyUserDetailsService;
import com.jb.couponsystemp3.service.CompanyService;
import com.jb.couponsystemp3.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/cs/auth")
@RequiredArgsConstructor
public class AuthController {


    private final JWTUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    private final MyUserDetailsService myUserDetailsService;

    private final CompanyService companyService;

    private final CustomerService customerService;

    private final CompanyRepository companyRepository;

    private final CustomerRepository customerRepository;

    @PostMapping("/login")
    public Map<String, Object> createAuthenticationLogin(@RequestBody LoginParams loginParams) throws Exception {

        String username = loginParams.getEmail() + ":" + loginParams.getClientType().name();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, loginParams.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("incorrect user name or password", e);
        }
        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);
        Map<String, Object> claims = new HashMap<>();
        claims.put("clientType", loginParams.getClientType().name());
        final String jwt = jwtUtil.generateToken(userDetails, claims);
        switch (loginParams.getClientType().name()){
            case "company" :
                companyService.setCompany(companyRepository.findByEmail(jwtUtil.extractUsername(jwt)).orElseThrow(()->new CouponSystemException(ErrMsg.COMPANY_NOT_EXIST)));
                break;
            case "customer" :
                customerService.setCustomer(customerRepository.findByEmail(jwtUtil.extractUsername(jwt)).orElseThrow(()-> new CouponSystemException(ErrMsg.CUSTOMER_NOT_EXIST)));
                break;
        }
        return Collections.singletonMap("jwtToken",jwt);
    }
}
