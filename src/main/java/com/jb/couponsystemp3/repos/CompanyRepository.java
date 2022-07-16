package com.jb.couponsystemp3.repos;

import com.jb.couponsystemp3.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    boolean existsByNameOrEmail(String name, String email);

    boolean existsByEmailAndPassword(String email, String password);

    Optional <Company> findByEmail(String email);


}