package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.CustomerLoginSession;

@Repository
public interface CustomerLoginSessionDao extends JpaRepository<CustomerLoginSession, Integer>{

	public Optional<CustomerLoginSession> findByCustomerId(Integer customerId);
	public CustomerLoginSession findByApiKey(String apiKey);
}
