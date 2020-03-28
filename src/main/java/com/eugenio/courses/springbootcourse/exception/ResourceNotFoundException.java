package com.eugenio.courses.springbootcourse.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Long id) {
		super("Resource with id: " + id + " not found. Please provide a valid id. ");
	}
}
