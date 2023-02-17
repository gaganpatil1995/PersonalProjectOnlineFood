package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Address;
import com.masai.entity.Customer;
import com.masai.exception.CustomerException;
import com.masai.repository.AddressDao;
import com.masai.repository.CustomerDao;

@Service
public class CustomerServiceImpl implements CustomerService {
    
	@Autowired
	CustomerDao customerDao ;
	
	@Autowired
	AddressDao addressDao ;
	
	@Override
	public Customer addCustomer(Customer customer) {
	
		Address add = customer.getAddress() ;
		add.setCustomer(customer);
		return customerDao.save(customer);
	}



	@Override
	public List<Customer> getAllCustomer() throws CustomerException{
		List<Customer> cusList = customerDao.findAll();
		if(cusList.isEmpty()) {
			throw new CustomerException("No customer Found") ;
		}
		return cusList ;
	}



	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		 Optional<Customer> opt = customerDao.findById(customer.getCustomerId()) ;
		 
		 if(opt.isEmpty()) {
			 throw new CustomerException("No Customer found");
		 }
		 
		 
		return customerDao.save(customer);
	}



	@Override
	public Customer removeCustomer(Integer customerId) throws CustomerException {
	
		Optional<Customer> opt = customerDao.findById(customerId) ;
		
		if(opt.isEmpty()) {
			throw new CustomerException("Customer not Found") ;
		}
		Customer customer = opt.get() ;
		 customerDao.delete(customer);
		 return customer ;
	}

    
	
	
	
	
}

//	@Override
//	public Customer addCustomer(Customer customer) {
//		// TODO Auto-generated method stub
//		Customer customer1 = customerDao.save(customer);
//		return customer1;
//	}
//
//	@Override
//	public Customer updateCustomer(Customer customer) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Customer removeCustomer(Customer customer) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
////	public Customer viewCustomer(Customer customer) {
////		// TODO Auto-generated method stub
////
////		return null;
////	}
//	@Override
//	public Customer viewCustomer(Integer id) {
//		Optional<Customer> opt = customerDao.findById(id);
//		Customer customer = opt.get();
//		return customer;
//	}
//
//	@Override
//	public Customer viewAllCustomers(List<Customer> customer) {
//		// TODO Auto-generated method stub
//		return null;
//	}


