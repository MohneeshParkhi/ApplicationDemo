package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.RegistrationService;
import com.example.demo.model.RegisterCustomer;

@RestController
@RequestMapping(value="/applicationDemo")
public class RegistrationController {
    
	@Autowired
	RegistrationService registerService;
	
	
	@PostMapping(value="/saveCustInfo",consumes="Json/Xml")
	public ResponseEntity<?> saveInformation(@RequestBody RegisterCustomer registerCustomer)
	{ 
		 registerService.saveCustomerInfo(registerCustomer);
		return null;
		
	}
}
