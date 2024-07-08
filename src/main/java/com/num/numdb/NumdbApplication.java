package com.num.numdb;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication

@SpringBootApplication (exclude = SecurityAutoConfiguration.class)
public class NumdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumdbApplication.class, args);
	}

}
