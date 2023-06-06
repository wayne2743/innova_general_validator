package com.wayne.general.validate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wayne.general.validate.service.ValidationService;

@RestController
@RequestMapping(value = "validate")
public class ValidationController {

	@Autowired
	ValidationService passwordValidationService;

	@GetMapping(path = "password/check")
	public boolean passwordCheck(@RequestParam String input) throws Exception {
		return passwordValidationService.validate(input);
	}
}
