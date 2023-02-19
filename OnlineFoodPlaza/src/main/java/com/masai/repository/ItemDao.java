package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.Items;

@Repository
public interface ItemDao extends JpaRepository<Items, Integer>{

	List<Items> findByItemName(String itemName);
}
