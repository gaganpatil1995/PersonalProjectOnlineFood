package com.masai.service;

import java.util.List;

import com.masai.entity.ItemCategory;
import com.masai.entity.Resturant;


public interface ResturantService {
	
	public Resturant addResturant(Resturant res);
	public String RemoveResturant(Integer Id);
	public ItemCategory AddResturantItemCategory(Integer ResId,ItemCategory itemCat);
     public List<Resturant> getAllResturant();
}
