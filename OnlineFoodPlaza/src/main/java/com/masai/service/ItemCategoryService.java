package com.masai.service;

import java.util.List;

import com.masai.entity.ItemCategory;
import com.masai.entity.Items;


public interface ItemCategoryService {
     public Items addItem(Items item);
     public Items addItembycatid(Items item,Integer catid);
     public ItemCategory addItemCategory(ItemCategory itemcat);
     public List<ItemCategory> getAllItemCategory();
//     public Item updateItem(Item item);
//     public Item viewItem(Item item);
//     public Item removeItem(Item item);
//     public List<Item> viewAllItems(Category cat);
//     public List<Item> viewAllItemsByRestaurent(Restaurant res);
//     public List<Item> viewAllItemsByName(String name);
     
}
