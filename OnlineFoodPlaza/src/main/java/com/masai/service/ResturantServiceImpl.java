package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Items;
import com.masai.entity.Resturant;
import com.masai.exception.ItemsException;
import com.masai.exception.ResturantException;
import com.masai.repository.ItemCategoryDao;
import com.masai.repository.ItemDao;
import com.masai.repository.ResturantDao;

@Service
public class ResturantServiceImpl implements ResturantService{
  
	@Autowired
	ResturantDao resDao ;
	

	
	@Autowired
	ItemDao itemDao ;
	
	@Override
	public Resturant addResturant(Resturant res) {
		
		return resDao.save(res);
		
		
	}
	@Override
	public String RemoveResturant(Integer Id) {
		Optional<Resturant> res =  resDao.findById(Id);
		Resturant resturant =  res.get();
		
		resDao.delete(resturant);
		return "Resturant Deleted"+" "+resturant;
	}
	
	@Override
	public List<Items> AddResturantItems(Integer ResId, Items item) throws ResturantException {
    
		Optional<Resturant> opt = resDao.findById(ResId);
		
		if(opt.isEmpty()) {
			throw new ResturantException("Resturant is  not present with given id");
		}
		Resturant resturant = opt.get() ;
		List<Items> items = resturant.getListOfItems() ;
		
		for(Items ite : items) {
			
			if(ite.getItemName().equalsIgnoreCase(item.getItemName())) {
			int quantity = item.getItemQuantity()+ ite.getItemQuantity() ;
			ite.setItemQuantity(quantity); 
			resturant.setListOfItems(items);
			itemDao.save(item) ;
			resDao.save(resturant) ;
			return items ;
			}
		}
		
		items.add(item) ;
		itemDao.save(item) ;
		resturant.setListOfItems(items);
		
		resDao.save(resturant) ;
		
		return items ;
	

	}
	
	@Override
	public List<Resturant> getAllResturant() throws ResturantException{
	
		List<Resturant> listOfRes =	resDao.findAll();
		if(listOfRes.isEmpty()) {
			throw new ResturantException("No Resturant found");
		}
		return listOfRes;
	}
	
	
	@Override
	public Resturant getResturantById(Integer resturantId) throws ResturantException {
		Optional<Resturant> opt = resDao.findById(resturantId);
		if(opt.isEmpty()) {
			throw new ResturantException("Resturant is not found with given Id");
		}
		
		return opt.get();
	}
	@Override
	public Items addItems(Items item) {
		
		return itemDao.save(item);
	}
	@Override
	public Items getItemsById(Integer itemId) throws ItemsException {
		Optional<Items> opt = itemDao.findById(itemId);
		if(opt.isEmpty()) {
			throw new ItemsException("Items is not present");
		}
		return opt.get();
	}
	@Override
	public String removeItemsById(Integer itemId) throws ItemsException {
		Optional<Items> opt = itemDao.findById(itemId);
		if(opt.isEmpty()) {
			throw new ItemsException("Item with given Id is not present");
		}
		Items item = opt.get();
		itemDao.delete(item);
		
		return "Given Item is succefully deleted"+item;
	}
	@Override
	public Items updateItems(Items item) throws ItemsException {
		Optional<Items> opt = itemDao.findById(item.getItemId());
		if(opt.isEmpty()) {
			throw new ItemsException("Item is not present");
		}
		
		itemDao.save(item);
		return item;
	}
	@Override
	public List<Items> getAllItemsFromresturant(Integer resId) throws ResturantException {
		Optional<Resturant> opt = resDao.findById(resId);
		if(opt.isEmpty()) {
			throw new ResturantException("Resturant is not present");
		}
		return opt.get().getListOfItems();
	}
	@Override
	public List<Items> getAllItems() throws ItemsException {
		List<Items> items = itemDao.findAll();
		if(items.size()==0) {
			throw new ItemsException("No Items found");
		}
		return items;
	}
	
}
