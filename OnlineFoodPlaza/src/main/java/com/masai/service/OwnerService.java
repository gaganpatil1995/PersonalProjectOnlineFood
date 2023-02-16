package com.masai.service;

import java.util.List;

import com.masai.entity.Owner;

public interface OwnerService  {

	public Owner addOwner(Owner owner) ;
	
	public List<Owner> getAllOwner() ;
}
