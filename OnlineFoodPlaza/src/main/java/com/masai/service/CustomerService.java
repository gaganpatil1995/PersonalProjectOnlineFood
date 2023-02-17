package com.masai.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.masai.entity.Customer;
import com.masai.exception.CustomerException;
@Service
public interface CustomerService {

	public Customer addCustomer(Customer customer) ;
	public List<Customer> getAllCustomer() throws CustomerException ;
	public Customer updateCustomer(Customer customer) throws CustomerException;
	public Customer removeCustomer(Integer customerId) throws CustomerException;
	
}
	
