package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Owner;
import com.masai.entity.OwnerAddress;
import com.masai.exception.OwnerException;
import com.masai.repository.OwnerDao;

@Service
public class OwnerServiceImpl implements OwnerService{

	@Autowired
	OwnerDao ownerDao ;
	
	@Override
	public Owner addOwner(Owner owner) {
		OwnerAddress add = owner.getOwnerAddress();
		add.setOwner(owner);
		
		return ownerDao.save(owner) ; 
		
	}

	@Override
	public List<Owner> getAllOwner()throws OwnerException {
		
		List<Owner> allOwner = ownerDao.findAll();
		if(allOwner.isEmpty()) {
			throw new OwnerException("No Owner Found") ;
		}
		return allOwner ;
		
	}

	@Override
	public Owner findOwnerById(Integer ownerId) throws OwnerException {
		Optional<Owner> opt = ownerDao.findById(ownerId) ;
		
		if(opt.isEmpty()) {
			throw new OwnerException("Owner is not Found") ;
		}
		
		return opt.get();
	}

	@Override
	public Owner updateOwnerById(Owner owner) throws OwnerException {
		Optional<Owner> opt = ownerDao.findById(owner.getOwnerId()) ;
		
		if(opt.isEmpty()) {
			throw new OwnerException("Owner is not Found") ;
		}
		
		return ownerDao.save(owner);
	}

	@Override
	public String removeOwnerbyId(Integer ownerId) throws OwnerException {
		
		Optional<Owner> opt  = ownerDao.findById(ownerId) ;
		
		if(opt.isEmpty()) {
			throw new OwnerException("Owner is not Found") ;
		}
		ownerDao.delete(opt.get());
		
		return "Owner with Given Id is Removed "+" "+opt.get();
	}

}
