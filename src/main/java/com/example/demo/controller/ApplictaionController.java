package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.LoginService;
import com.example.demo.Service.RegistrationService;
import com.example.demo.model.LoginModel;
//import com.example.demo.model.LoginModel;
import com.example.demo.model.RegisterCustomer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/applicationDemo")
@CrossOrigin(value="http://localhost:4200")
public class ApplictaionController {

	@Autowired
	RegistrationService registerService;
	
	@Autowired
	LoginService loginService;

	@PostMapping(value = "/saveCustInfo")
	public ResponseEntity<?> saveInformation(@RequestBody RegisterCustomer registerCustomer) {
		return registerService.saveCustomerInfo(registerCustomer);

	}

	/*
	 * @GetMapping(value="/getLoginValidate") public ResponseEntity<?>
	 * getLoginValidate(@RequestBody LoginValidate loginValidate){ return
	 * loginValidateService.getLoginValidate(loginValidate);
	 * 
	 * }
	 */
	@PostMapping(value="/validateLogin")
	public int validateLogin(@RequestBody LoginModel login)
	{
		System.out.println(login);
		int validateId = loginService.validateLogin(login);; 
		System.out.println(validateId);
		
		return validateId;
		
	}

	@GetMapping(value = "/getAllCustomers")
	public ResponseEntity<?> getCustomer() {
		return registerService.getCustomer();
	}

	/*
	 * @GetMapping(value="/getCustomer") public List<RegisterCustomer>
	 * getCustomer(){ System.out.println(registerService.getCustomer()); return
	 * registerService.getCustomer(); }
	 */

	@GetMapping(value = "/getCustomerById/{customerId}")
	public RegisterCustomer getById(@PathVariable("customerId") Long customerId) {
		return registerService.getCustomerById(customerId);
	}

	@DeleteMapping(value = "/deleteById/{customerId}")
	public List<RegisterCustomer> deleteById(@PathVariable("customerId") Long customerId) {
		return registerService.deleteById(customerId);
	}

	/*
	 * getHystrix Method is hard coded method. Shows the use pattern of hystrix
	 * usage. configure the registerService method to show the usage of hystrix
	 * method.
	 */
    
	
	
	
	@GetMapping(value = "/showHystrixUsage")
	@HystrixCommand(fallbackMethod="getDataFallBack")
	public ResponseEntity<?> getHystrixUsage() throws Exception {
		return registerService.getHystrixUsage();
	}
	
	
	public ResponseEntity<?> getDataFallBack(){
	return registerService.getDataFallBack();	
	}
	
}
