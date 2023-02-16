package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.Owner;

@Repository
public interface OwnerDao extends JpaRepository<Owner, Integer>{

	public Optional<Owner> findByMobileNo(String mobileNo);
	
}
