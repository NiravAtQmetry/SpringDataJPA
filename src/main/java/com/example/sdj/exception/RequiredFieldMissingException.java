package com.example.sdj.exception;

public class RequiredFieldMissingException  extends Exception{

	private String messege;
	private String field;
	
	public RequiredFieldMissingException(String field) {
		this.field=field;
	}

	public String getMessege() {
		return "Missing Field : "+field;
	}
	
}
