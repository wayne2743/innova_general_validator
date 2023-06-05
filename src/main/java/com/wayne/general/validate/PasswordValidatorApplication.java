package com.wayne.general.validate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wayne.general.validate.criteria.ImmediatelyContainsSameSequenceCriteria;

@SpringBootApplication
public class PasswordValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordValidatorApplication.class, args);
	}


	
}
