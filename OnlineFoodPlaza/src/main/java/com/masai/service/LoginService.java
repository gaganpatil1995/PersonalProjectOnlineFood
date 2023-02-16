package com.masai.service;

import org.springframework.stereotype.Service;

import com.masai.entity.CustomerDTO;
import com.masai.entity.CustomerLoginSession;
import com.masai.entity.OwnerDTO;
import com.masai.entity.OwnerLoginSession;
import com.masai.exception.UserNotFoundException;

@Service
public interface LoginService {
	
	public CustomerLoginSession customerLogin(CustomerDTO custDto) ;
	public String customerLogout (String apiKey) throws UserNotFoundException;
	public OwnerLoginSession OwnerLogin(OwnerDTO ownerDto) ;
	public String OwnerLogout(String apiKey)throws UserNotFoundException ;
//
//    public Login signOut(Login login);
}
