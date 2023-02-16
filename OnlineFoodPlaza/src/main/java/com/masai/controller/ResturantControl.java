package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.ItemCategory;
import com.masai.entity.Resturant;
import com.masai.repository.ItemCategoryDao;
import com.masai.service.ResturantServiceImpl;

@RestController
public class ResturantControl {

	@Autowired
	ResturantServiceImpl resService ;
	
	@Autowired
	ItemCategoryDao itemCatDao ;
	
	@GetMapping("/resturant")
	public List<Resturant> getAllResturant() {
		return resService.getAllResturant();
	}
	
	@PostMapping("/resturant")
	public Resturant addResturant(@RequestBody Resturant res) {
	 return	resService.addResturant(res) ;
	}
	@DeleteMapping("/resturant/{id}")
	public String RemoveResturant(@PathVariable Integer id) {
		
		return resService.RemoveResturant(id);
	}
	@PutMapping("/resturanItem/{id}")
	public ItemCategory addItemCategory(@PathVariable Integer id,@RequestBody ItemCategory itemCat) {
		return resService.AddResturantItemCategory(id, itemCat);
	}
}
