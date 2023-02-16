package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.entity.ItemCategory;

@Repository
public interface ItemCategoryDao extends JpaRepository<ItemCategory, Integer> {

}
