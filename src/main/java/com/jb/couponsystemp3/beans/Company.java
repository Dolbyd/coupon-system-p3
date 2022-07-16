package com.jb.couponsystemp3.beans;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20, nullable = false)
    private String name;
    @Column(length = 40, nullable = false)
    private String email;
    @Column(length = 20, nullable = false)
    private String password;


    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy = "company")
    @Singular
    @ToString.Exclude
    @JsonIgnore
    private List<Coupon> coupons = new ArrayList<>();

}
