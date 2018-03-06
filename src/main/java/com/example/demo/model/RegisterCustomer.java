package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="RegisterCustomer")
public class RegisterCustomer {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long custId;

@Override
public String toString() {
	return "RegisterCustomer [custId=" + custId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
			+ emailId + ", phoneNumber=" + phoneNumber + "]";
}

@Column(name="firstName")
private String firstName;

@Column(name="lastName")
private String lastName;

@Column(name="emailId")
private String emailId;

@Column(name="phNumber")
private Long phoneNumber;

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

public Long getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(Long phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public RegisterCustomer(Long custId, String firstName, String lastName, String emailId, Long phoneNumber) {
	super();
	this.custId = custId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.emailId = emailId;
	this.phoneNumber = phoneNumber;
}

public RegisterCustomer() {
	super();
	// TODO Auto-generated constructor stub
} 



}