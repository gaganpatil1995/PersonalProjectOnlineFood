package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.ItemCategory;
import com.masai.entity.Items;
import com.masai.repository.ItemCategoryDao;
import com.masai.repository.ItemDao;

@Service
public class ItemCategoryServiceImpl implements ItemCategoryService{
     
	@Autowired
	private ItemDao itemDao ;
	
	@Autowired
	private ItemCategoryDao catDao ;

	@Override
	public Items addItem(Items item) {
//		Optional<ItemCategory> cat = catDao.findById(catid);
//	      ItemCategory list = cat.get();
//	      
//	      ItemCategory itemcat = cat.get();
//	      item.setCategory(itemcat);
//	      list.getItems().add(item);
//	ItemCategory itemcat =	item.getCategory();
//	Optional<ItemCategory> cat=catDao.findById(itemcat.getCatId());
//	 ItemCategory list = cat.get() ;
//	 list.getItems().add(item);
		itemDao.save(item) ;
		return item;
	 
//	      return "Item Added"+item ; 
	}

	@Override
	public ItemCategory addItemCategory(ItemCategory itemcat) {
	   List<Items> items = itemcat.getItems();
	   for(Items i :items) {
//		   i.setCategory(itemcat);
	   }
	   
		return catDao.save(itemcat) ;
	}

	@Override
	public Items addItembycatid(Items item, Integer catid) {
		Optional<ItemCategory> itemcat1 =  catDao.findById(catid);
		ItemCategory itemcat = itemcat1.get();
		itemcat.getItems().add(item);
//		item.setCategory(itemcat);
		return itemDao.save(item);
	}

	@Override
	public List<ItemCategory> getAllItemCategory() {
		return catDao.findAll();
		
//		return null;
	}




}

	
	

//
//	@Override
//	public Item updateItem(Item item) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Item viewItem(Item item) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Item removeItem(Item item) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Item> viewAllItems(Category cat) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Item> viewAllItemsByRestaurent(Restaurant res) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Item> viewAllItemsByName(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}



