package com.example.sdj.model;

import org.springframework.http.HttpStatus;

public class RestError {

	private HttpStatus status;
	private String meessge;

	public RestError() {

	}

	public RestError(HttpStatus status, String messege) {
		this.status = status;
		this.meessge = messege;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMeessge() {
		return meessge;
	}

	public void setMeessge(String meessge) {
		this.meessge = meessge;
	}

}
