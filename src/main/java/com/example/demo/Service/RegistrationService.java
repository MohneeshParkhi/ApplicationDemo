package com.example.demo.Service;

import java.util.LinkedList;
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
	
    //@Cacheable("registerCustomer")
	public ResponseEntity<?> saveCustomerInfo(RegisterCustomer registerCustomer) {
		
		registerCustomerRepo.saveAndFlush(registerCustomer);
		
		return new ResponseEntity<>(registerCustomer,HttpStatus.OK);
	}
    
   /* @Cacheable("getAllCustomer")
	public List<RegisterCustomer> getCustomer() {
		
		List<RegisterCustomer> list=registerCustomerRepo.findAll();
		
	  //return new ResponseEntity<>(list,HttpStatus.OK);
 return list;
    }*/
    
    public ResponseEntity<?> getCustomer(){
    	List<RegisterCustomer> list = registerCustomerRepo.findAll();
    	return new ResponseEntity<>(list,HttpStatus.OK);
    	
    }

	public RegisterCustomer getCustomerById(Long customerId) {
	 return	registerCustomerRepo.findOne(customerId);
	}

	public List<RegisterCustomer> deleteById(Long customerId) {
		registerCustomerRepo.delete(customerId);
		return registerCustomerRepo.findAll();
	}

    
	public ResponseEntity<?> getHystrixUsage() throws Exception {
		List<String> listString = new LinkedList<String>();
		listString.add("HCL");
		listString.add("Infosys");
		listString.add("TCS");
		listString.add("google");
		listString.add("microsoft");
		
		if(listString.contains("mohneesh"))
			throw new RuntimeException();
		
		return new ResponseEntity<>(listString,HttpStatus.OK);
		
	}

	public ResponseEntity<?> getDataFallBack() {
		List<String> listString = new LinkedList<String>();
		listString.add("Hystrix method FallBack");
		listString.add("Hystrix Method FallBack");
		listString.add("Hystrix Method FallBack");
		listString.add("Hystrix Method FallBack");
		return new ResponseEntity<>(listString,HttpStatus.OK);
	}

	public ResponseEntity<?> saveCustInfoFallBack() {
		
		
		
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	//update method is incomplete as need the
	
	/*public ResponseEntity<?> updateCustomerInfo(RegisterCustomer registerCustomer) {
		// TODO Auto-generated method stub
		
		
		
		
		return new ResponseEntity<>(registerCustomer,HttpStatus.OK);
	}*/}
