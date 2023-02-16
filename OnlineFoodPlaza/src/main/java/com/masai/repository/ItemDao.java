package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.Items;

@Repository
public interface ItemDao extends JpaRepository<Items, Integer>{

}
