package com.wayne.general.validate.exception;

import com.wayne.general.validate.model.CriteriaException;

public enum ExceptionEnum {
	IMMEDIATELY_CONTAINS_SAME_SEQUENCE(-1001, "character immediately contains the same sequence"),
	LOWER_CASE_AND_DIGIT_NOT_CONTAINS(-1002, "lower case and digit should contains"),
	TEXT_LENGTH_EXCEED_THE_RESTRICTION(-1003, "text length exceed the restriction"),
	UNKOWN_EXCEPTION(-9999, "Unkown exception occurs"),
	SUCCESS(0, "Sucess");

	int errorCode;
	String errorMsg;

	private ExceptionEnum(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public CriteriaException toException() {
		return new CriteriaException(this.errorCode, this.errorMsg);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}
