package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Owner;
import com.masai.service.OwnerServiceImpl;

@RestController
public class OwnerController {
      
	@Autowired
	 OwnerServiceImpl ownerImp ;
	 
	@PostMapping("/owner")
	public Owner addOwnerDetails(@RequestBody Owner owner) {
		return ownerImp.addOwner(owner);
	}
	@GetMapping("/owner")
	public List<Owner> getAllOwnersDetails(){
		return ownerImp.getAllOwner();
	}
}
