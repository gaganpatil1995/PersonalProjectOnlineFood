package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Owner;
import com.masai.exception.OwnerException;
import com.masai.service.OwnerServiceImpl;

@RestController
public class OwnerController {
      
	@Autowired
	 OwnerServiceImpl ownerImp ;
	 
	@PostMapping("/owner")
	public ResponseEntity<Owner> addOwnerDetails(@RequestBody Owner owner) {
		return new ResponseEntity<>(ownerImp.addOwner(owner),HttpStatus.ACCEPTED);
	}
	@GetMapping("/owner")
	public ResponseEntity<List<Owner>> getAllOwnersDetails()throws OwnerException{
		return new ResponseEntity<>(ownerImp.getAllOwner(),HttpStatus.ACCEPTED) ;
	}
	@GetMapping("/getOwner")
	public ResponseEntity<Owner> getOwnerById(@RequestParam Integer ownerId)throws OwnerException{
		
		return new ResponseEntity<>(ownerImp.findOwnerById(ownerId), HttpStatus.FOUND);
	}
	
	@PutMapping("/updateOwner")
	public ResponseEntity<Owner> updateOwnerById(@RequestBody Owner owner)throws OwnerException{
		
		return new ResponseEntity<>(ownerImp.updateOwnerById(owner),HttpStatus.OK) ;
	}
	@DeleteMapping("/deleteOwner")
	public ResponseEntity<String> removeOwner(@RequestParam Integer ownerId)throws OwnerException{
		return new ResponseEntity<>(ownerImp.removeOwnerbyId(ownerId),HttpStatus.GONE);
	}
}
