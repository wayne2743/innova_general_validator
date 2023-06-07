package com.wayne.general.validate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wayne.general.validate.service.ValidationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping(value = "validate")
public class ValidationController {

	/**
	 *
	 */
	private static final String PASSWORD_CHECK_SUMMARY_DES = "The service is meant to check a text string for compliance to any number of password validation rules.";

	private static final String PASSWORD_CHECK_FUNCTION_DES = "<b>Condition :</b> <br/> 1. Must consist of a mixture of lowercase letters and numerical digits only, with at least one of each. <br/> 2. Must be between 5 and 12 characters in length. <br/>3. Must not contain any sequence of characters immediately followed by the same sequence";
	
	@Autowired
	ValidationService passwordValidationService;

	@GetMapping(path = "password/check")
	@Operation(summary = "Input text for password verification", description = PASSWORD_CHECK_SUMMARY_DES)
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "Message Send OK!", 
				content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
	})
	public boolean passwordCheck(@RequestParam @Parameter(example = "test123", description = PASSWORD_CHECK_FUNCTION_DES) String input) throws Exception {
		return passwordValidationService.validate(input);
	}
}
