package com.iii.eeit109.bean;

import java.io.Serializable;

public class StringBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String message="No message specified";
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message=message;
	}
}
