package com.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fieldName;
	private Object fielValue;
	public ResourceNotFoundException(String resourceName, String fieldName, Object fielValue) {
		super(String.format("%s not found with %s : '%s'", resourceName,fieldName,fielValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fielValue = fielValue;
	}
	
	

}
