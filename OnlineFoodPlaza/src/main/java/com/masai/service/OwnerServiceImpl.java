package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Owner;
import com.masai.repository.OwnerDao;

@Service
public class OwnerServiceImpl implements OwnerService{

	@Autowired
	OwnerDao ownerDao ;
	
	@Override
	public Owner addOwner(Owner owner) {
		return ownerDao.save(owner) ; 
		
	}

	@Override
	public List<Owner> getAllOwner() {
		
		return ownerDao.findAll();
	}

}
