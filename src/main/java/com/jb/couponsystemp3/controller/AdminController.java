package com.jb.couponsystemp3.controller;

import com.jb.couponsystemp3.beans.Company;
import com.jb.couponsystemp3.beans.Customer;
import com.jb.couponsystemp3.exception.CouponSystemException;
import com.jb.couponsystemp3.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cs/admin")
@RequiredArgsConstructor
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {


    private final AdminService adminService;


    @PostMapping("/company")
    @ResponseStatus(HttpStatus.CREATED)
    public Company addCompany(@RequestBody Company company) throws CouponSystemException {
        return adminService.addCompany(company);

    }

    @PutMapping("/company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Company updateCompany(@PathVariable int id, @RequestBody Company company) throws CouponSystemException {
        return adminService.updateCompany(id, company);
    }

    @DeleteMapping("/company/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCompany(@PathVariable int id) throws CouponSystemException {
        adminService.deleteCompany(id);
    }

    @GetMapping("/company")
    public List<Company> getAllCompanies() {
        return adminService.getAllCompanies();
    }

    @GetMapping("/company/{id}")
    public Company getSingleCompany(@PathVariable int id) throws CouponSystemException {
        return adminService.getSingleCompany(id);
    }

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) throws CouponSystemException {
        return adminService.addCustomer(customer);
    }

    @PutMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customer) throws CouponSystemException {
        return adminService.updateCustomer(id, customer);
    }

    @DeleteMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable int id) throws CouponSystemException {
        adminService.deleteCustomer(id);
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers() {
        return adminService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public Customer getSingleCustomer(@PathVariable int id) throws CouponSystemException {
        return adminService.getSingleCustomer(id);
    }


}
