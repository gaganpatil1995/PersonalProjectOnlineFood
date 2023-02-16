package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Customer;
import com.masai.service.CustomerServiceImpl;

@RestController
//@RequestMapping("/customer")
public class CustomerControl {
    @Autowired
    private CustomerServiceImpl customerService;

//    @GetMapping("/{id}")
//    public Customer viewCustomerHandler(@PathVariable Integer id){
//        return customerService.viewCustomer(id);
//    }

    @PostMapping("/customer")
    public ResponseEntity<Customer> saveCustomerHandler(@RequestBody  Customer customer){
        
    	return new ResponseEntity<> (customerService.addCustomer(customer) , HttpStatus.CREATED );
    }
    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomer(){
    	
    	return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.ACCEPTED);
    }

}
