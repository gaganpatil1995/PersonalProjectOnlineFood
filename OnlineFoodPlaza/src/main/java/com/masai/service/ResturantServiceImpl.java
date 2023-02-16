package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.ItemCategory;
import com.masai.entity.Items;
import com.masai.entity.Resturant;
import com.masai.repository.ItemCategoryDao;
import com.masai.repository.ItemDao;
import com.masai.repository.ResturantDao;

@Service
public class ResturantServiceImpl implements ResturantService{
  
	@Autowired
	ResturantDao resDao ;
	
	@Autowired
	ItemCategoryDao itemCatDao ;
	
	@Autowired
	ItemDao itemDao ;
	
	@Override
	public Resturant addResturant(Resturant res) {
		
		return resDao.save(res);
		
		
	}
	@Override
	public String RemoveResturant(Integer Id) {
//		Optional<Resturant> res =  resDao.findById(Id);
//		Resturant resturant =  res.get();
		
		 resDao.deleteById(Id);
		return "Resturant Deleted";
	}
	@Override
	public ItemCategory AddResturantItemCategory(Integer ResId, ItemCategory itemCat) {
    List<Items> listItems = itemCat.getItems();
		
		for(Items I :listItems) {
			I.setCategory(itemCat);
		}
		Optional<Resturant> res = resDao.findById(ResId);
		Resturant resturant = res.get();
		List<ItemCategory> listItemCategory = resturant.getListOfItemCategory();
		
		listItemCategory.add(itemCat);
		itemCatDao.save(itemCat);
		
		
		return itemCat ;
//		return null;
	}
	
	@Override
	public List<Resturant> getAllResturant() {
	
		List<Resturant> listOfRes =	resDao.findAll();
		return listOfRes;
	}
	
}
