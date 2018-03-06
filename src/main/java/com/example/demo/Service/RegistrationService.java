package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.RegisterCustomer;
import com.example.demo.repository.RegisterCustomerRepo;

@Service
public class RegistrationService {

    @Autowired
	RegisterCustomerRepo registerCustomerRepo;
	
	public ResponseEntity<?> saveCustomerInfo(RegisterCustomer registerCustomer) {
		
		registerCustomerRepo.saveAndFlush(registerCustomer);
		
		return new ResponseEntity<>(registerCustomer,HttpStatus.OK);
	}

}
