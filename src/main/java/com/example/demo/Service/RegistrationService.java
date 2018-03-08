package com.example.demo.Service;

//import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.RegisterCustomer;
import com.example.demo.repository.RegisterCustomerRepo;

@Service
public class RegistrationService {

    @Autowired
	RegisterCustomerRepo registerCustomerRepo;
	
    @Cacheable("registerCustomer")
	public ResponseEntity<?> saveCustomerInfo(RegisterCustomer registerCustomer) {
		
		registerCustomerRepo.saveAndFlush(registerCustomer);
		
		return new ResponseEntity<>(registerCustomer,HttpStatus.OK);
	}
    
    @Cacheable("getAllCustomer")
	public ResponseEntity<?> getCustomer() {
		
		List<RegisterCustomer> list=registerCustomerRepo.findAll();
		
	  return new ResponseEntity<>(list,HttpStatus.OK);
}}
