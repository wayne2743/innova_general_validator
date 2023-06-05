package com.wayne.general.validate.exception;

public class CriteriaException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -789658765663148686L;
	
	private int errorCode;
	private String errorName;
	
	
	
	public CriteriaException(int errorCode, String errorName) {
		super();
		this.errorCode = errorCode;
		this.errorName = errorName;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	

}
