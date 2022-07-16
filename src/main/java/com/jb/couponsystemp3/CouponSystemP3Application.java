package com.jb.couponsystemp3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = { "com.jb.couponsystemp3" }, excludeFilters = @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "com.jb.couponsystemp3.clr.off.*"))
public class CouponSystemP3Application {

	public static void main(String[] args) {
		SpringApplication.run(CouponSystemP3Application.class, args);
	}

}
