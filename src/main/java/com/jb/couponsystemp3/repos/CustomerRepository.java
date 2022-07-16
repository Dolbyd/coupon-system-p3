package com.jb.couponsystemp3.repos;


import com.jb.couponsystemp3.beans.Company;
import com.jb.couponsystemp3.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);

    Optional<Customer> findByEmail(String email);
}
