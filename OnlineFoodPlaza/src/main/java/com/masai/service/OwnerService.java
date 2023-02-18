package com.masai.service;

import java.util.List;

import com.masai.entity.Owner;
import com.masai.exception.OwnerException;

public interface OwnerService  {

	public Owner addOwner(Owner owner) ;
	
	public List<Owner> getAllOwner()throws OwnerException ;
	
	public Owner findOwnerById(Integer ownerId)throws OwnerException ;
	
	public Owner updateOwnerById(Owner owner)throws OwnerException ;
	
	public String removeOwnerbyId(Integer ownerId)throws OwnerException ;
}
