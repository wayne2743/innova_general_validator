package com.wayne.general.validate.criteria;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Criteria {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

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
	
	public boolean check(String input) {
		// Some verification before checked
		if(input == null || input.equals("")) {
			logger.error(String.format("Criteria input is empty : %s", this.getClass().getCanonicalName()));
			throw new NullPointerException("Current input in Criteria is null, please check!");
		}
		return checkCriteria(input);
	};

	protected abstract boolean checkCriteria(String input);

}
