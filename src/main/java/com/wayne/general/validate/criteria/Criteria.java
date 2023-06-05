package com.wayne.general.validate.criteria;

public abstract class Criteria {

	String name;
	int code;
	String description;
	int errorCode;

	public Criteria(String name, int code, String description, int errorCode) {
		super();
		this.name = name;
		this.code = code;
		this.description = description;
		this.errorCode = errorCode;
	}

	public abstract boolean check(String input);

}
