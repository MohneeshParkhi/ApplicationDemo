package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoginModel {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long loginId;

private String email;
private String password;
public Long getLoginId() {
	return loginId;
}
public void setLoginId(Long loginId) {
	this.loginId = loginId;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public LoginModel() {
	super();
	// TODO Auto-generated constructor stub
}
public LoginModel(Long loginId, String email, String password) {
	super();
	this.loginId = loginId;
	this.email = email;
	this.password = password;
}
@Override
public String toString() {
	return "LoginModel [loginId=" + loginId + ", email=" + email + ", password=" + password + "]";
}


}
