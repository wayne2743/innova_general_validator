package com.wayne.general.validate.model;

public class CriteriaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -789658765663148686L;

	private int errorCode;
	private String errorMsg;

	public CriteriaException(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
