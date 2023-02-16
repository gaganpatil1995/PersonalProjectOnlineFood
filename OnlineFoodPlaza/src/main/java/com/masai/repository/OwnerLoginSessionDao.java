package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.OwnerLoginSession;

@Repository
public interface OwnerLoginSessionDao extends JpaRepository<OwnerLoginSession, Integer> {
	
	public OwnerLoginSession findByOwnerId(Integer ownerId);  
	public OwnerLoginSession findByApiKey(String apiKey);
}
