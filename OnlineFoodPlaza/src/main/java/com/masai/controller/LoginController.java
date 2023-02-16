package com.masai.controller;

import org.aspectj.lang.annotation.DeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.CustomerDTO;
import com.masai.entity.CustomerLoginSession;
import com.masai.entity.OwnerDTO;
import com.masai.entity.OwnerLoginSession;
import com.masai.exception.UserNotFoundException;
import com.masai.service.LoginServiceImpl;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginServiceImpl login ;
	
	@PostMapping("/customer")
	public CustomerLoginSession logincustomer(@RequestBody CustomerDTO cus) throws UserNotFoundException {
		return login.customerLogin(cus);
	}
	@DeleteMapping("/customer/{apiKey}")
	public String logOutCustomer(@PathVariable String apiKey) throws UserNotFoundException{
		
		
		return login.customerLogout(apiKey); 
	}
	
	@PostMapping("/owner")
	public OwnerLoginSession loginOwner(@RequestBody OwnerDTO own)throws UserNotFoundException{
		return login.OwnerLogin(own);
	}
	@DeleteMapping("/owner/{apiKey}")
	public String logOutOwner(@PathVariable String apiKey) throws UserNotFoundException {
		return login.OwnerLogout(apiKey) ;
	}
}
