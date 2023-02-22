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
	
}
