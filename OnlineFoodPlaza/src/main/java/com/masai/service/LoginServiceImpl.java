package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Customer;
import com.masai.entity.CustomerDTO;
import com.masai.entity.CustomerLoginSession;
import com.masai.entity.Owner;
import com.masai.entity.OwnerDTO;
import com.masai.entity.OwnerLoginSession;
import com.masai.exception.UserNotFoundException;
import com.masai.repository.CustomerDao;
import com.masai.repository.CustomerLoginSessionDao;
import com.masai.repository.OwnerDao;
import com.masai.repository.OwnerLoginSessionDao;

@Service
public class LoginServiceImpl implements LoginService {
    
	@Autowired
	CustomerDao custmDao ;
	@Autowired
	OwnerDao ownerDao ;
	
	@Autowired
	CustomerLoginSessionDao custLoginSess ;
	@Autowired
	OwnerLoginSessionDao ownerLoginSess ;
	@Override
	public CustomerLoginSession customerLogin(CustomerDTO custDto) throws UserNotFoundException {
		
		Optional<Customer> opt = custmDao.findByMobileNumber(custDto.getMobileNo()) ;
		
		if(opt.isEmpty()) {
			throw new UserNotFoundException("Customer not found with given Mobile Number") ;
		}
		Customer customer = opt.get();
		Optional<CustomerLoginSession> cusLogSess = custLoginSess.findByCustomerId(customer.getCustomerId());
		
		if(!cusLogSess.isEmpty()) {
			throw new UserNotFoundException("Customer Already Logged in");
		}
	
		if(! customer.getPassword().equals(custDto.getPassword())) {
			throw new UserNotFoundException("Given password is incorrect");
		}
		
		CustomerLoginSession customerLogging = new CustomerLoginSession();
		customerLogging.setCustomerId(customer.getCustomerId());
		
		customerLogging.setApiKey(UUID.randomUUID().toString().replaceAll("-", "").substring(0,10));
		customerLogging.setDate(LocalDateTime.now());
		return custLoginSess.save(customerLogging) ;
		
		
		
		
		
		
	}


	@Override
	public OwnerLoginSession OwnerLogin(OwnerDTO ownerDto)throws UserNotFoundException {
		Optional<Owner> opt = ownerDao.findByMobileNo(ownerDto.getMobileNo()) ;
		
		if(opt.isEmpty()) {
			throw new UserNotFoundException("Owner not exist with given mobile number") ;
		}
		Owner owner = opt.get() ;
		
		OwnerLoginSession opt2 = ownerLoginSess.findByOwnerId(owner.getOwnerId()) ;
		
		if(opt2 != null) {
			throw new UserNotFoundException("Owner is already Login") ;
		}
		OwnerLoginSession ownerLoginSession = new OwnerLoginSession() ;
		ownerLoginSession.setDate(LocalDateTime.now());
		ownerLoginSession.setOwnerId(owner.getOwnerId());
		ownerLoginSession.setApiKey(UUID.randomUUID().toString().replaceAll("-", "").substring(0,10));
		
		return ownerLoginSess.save(ownerLoginSession);
	}


	@Override
	public String customerLogout(String apiKey)throws UserNotFoundException {
		CustomerLoginSession cusLogin =  custLoginSess.findByApiKey(apiKey);
		if(cusLogin==null) {
			throw new UserNotFoundException("You need to Login First") ;
		}
		
		custLoginSess.delete(cusLogin);
		
		return "Customer with id "+cusLogin.getCustomerId()+" is Logout Successfully";
	}


	@Override
	public String OwnerLogout(String apiKey) throws UserNotFoundException {
		OwnerLoginSession ownlogin =  ownerLoginSess.findByApiKey(apiKey);
		if(ownlogin==null) {
			throw new UserNotFoundException("Owner need to Login First") ;
		}
		ownerLoginSess.delete(ownlogin);
		return "Owner with id "+ownlogin.getOwnerId() + " is successfully Logout ";
	}
}
