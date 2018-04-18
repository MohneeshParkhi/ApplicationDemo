package com.example.demo.Service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.LoginModel;
//import com.example.demo.model.LoginModel;
import com.example.demo.model.RegisterCustomer;
import com.example.demo.repository.RegisterCustomerRepo;

@Service
public class LoginService {
     
	 @Autowired
	 RegisterCustomerRepo registerCustomerRepository;
	
public static int validateCredentials(List<RegisterCustomer> listCustomer, String username, String password)
	{
		//listCustomer.forEach(CustomerInstance -> System.out.println(CustomerInstance));
			Iterator<RegisterCustomer> it = listCustomer.iterator();
		  int passwordvalidateId=0;
			while(it.hasNext()) {
				RegisterCustomer obj = (RegisterCustomer)it.next();
				System.out.println(obj);
				String checkUsername = obj.getEmailId();
				String checkPassword =obj.getPassword();
				if(username.equals(checkUsername) && password.equals(checkPassword))
				{
					System.out.println("Matched");
					passwordvalidateId = 1;
				}
				
			}
			return passwordvalidateId;
			
			
			
	}

	public ResponseEntity<?> validateLogin(LoginModel login) {
		String username =login.getEmail();
		String password= login.getPassword();
		List<RegisterCustomer> listCustomer=	registerCustomerRepository.findAll();
		//calling to check validation
		int idloginCheck=validateCredentials(listCustomer,username,password);
	           
		 if(idloginCheck==1)
		 return new ResponseEntity<>(login,HttpStatus.OK);
		 else
			 return new ResponseEntity<>(false,HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
		}
		
	
	

