package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

//import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="RegisterCustomer")
public class RegisterCustomer {


@Column(name="custId")
private Long custId;

@Column(name="firstName")
private String firstName;

@Column(name="lastName")
private String lastName;

@Column(name="emailId")
private String emailId;

@Column(name="password")
private String password;



public RegisterCustomer() {
	
}


public RegisterCustomer(Long custId, String firstName, String lastName, String emailId, String password) {
	super();
	this.custId = custId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailId = emailId;
	this.password = password;
}

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
public Long getCustId() {
	return custId;
}


public void setCustId(Long custId) {
	this.custId = custId;
}


public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}


public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
}


public String getEmailId() {
	return emailId;
}


public void setEmailId(String emailId) {
	this.emailId = emailId;
}




public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}



@Override
public String toString() {
	return "RegisterCustomer [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
			+ emailId + ", password=" + password + "]";
}


}
