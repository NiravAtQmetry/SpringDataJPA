package com.example.sdj.exception;

public class EntityNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	private Long moduleId;
	private String messege;
	private String module;

	public EntityNotFoundException(String module, Long moduleId) {

		this.moduleId = moduleId;
		this.module = module;
	}

	public String getMessege() {
		return module + " Not Found for ID : " + moduleId;
	}

}
