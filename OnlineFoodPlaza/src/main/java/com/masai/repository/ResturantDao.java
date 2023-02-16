package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.Resturant;

@Repository
public interface ResturantDao extends JpaRepository<Resturant, Integer>{

}
