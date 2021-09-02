package com.example.demo.MailerApplication.model;
public class MailUser {
	/*
	 * this is the model class 
	 * Here private variables would be declared and 
	 * through the setter and getter methods we access the variables.
	 * @param String name
	 * @param String password 
	 */
	private String name;
	private String password;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
