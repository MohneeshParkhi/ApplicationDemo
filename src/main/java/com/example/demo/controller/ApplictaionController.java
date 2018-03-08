package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.Service.RegistrationService;

import com.example.demo.model.RegisterCustomer;

@RestController
@RequestMapping(value="/applicationDemo")
public class ApplictaionController {
    
	@Autowired
	RegistrationService registerService;
	
	
	@PostMapping(value="/saveCustInfo")
	public ResponseEntity<?> saveInformation(@RequestBody RegisterCustomer registerCustomer)
	{ 
		return registerService.saveCustomerInfo(registerCustomer);
		
		
	}
	
	/*@GetMapping(value="/getLoginValidate")
	public ResponseEntity<?> getLoginValidate(@RequestBody LoginValidate loginValidate){
		return  loginValidateService.getLoginValidate(loginValidate);
		
	}
	*/
	
	@GetMapping(value="/getCustomer")
	public ResponseEntity<?> getCustomer() {
		return registerService.getCustomer();
	}
	
}
