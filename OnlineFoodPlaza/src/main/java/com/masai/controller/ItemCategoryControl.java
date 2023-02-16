package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.ItemCategory;
import com.masai.entity.Items;
import com.masai.service.ItemCategoryServiceImpl;

@RestController
public class ItemCategoryControl {
     
	@Autowired
	private ItemCategoryServiceImpl itemService ;
	
	@PostMapping("/Item")
	public  Items itemAddHandler(@RequestBody Items item) {
		
	  return itemService.addItem(item);
		
	}
	@PostMapping("/Itembyid/{catid}")
	public  Items itembycatidAddHandler(@RequestBody Items item,@PathVariable("catid") Integer catid ) {
		
	  return itemService.addItembycatid(item, catid);
		
	}
	@GetMapping("/ItemCategory")
	public List<ItemCategory> getAllItemCategory(){
		return itemService.getAllItemCategory();
	}
	
	/*{
   "categoryName":"Starter",
   "items":[
       {
        "itemName":"chilly Panner"
       },
       {
           "itemName":"chilly chicken"
       },
       {
           "itemName":"Harra kabab"
       }

   ]
}*/
	@PostMapping("/ItemCat")
	public ItemCategory itemCategoryhandler(@RequestBody ItemCategory itemcat) {
		return itemService.addItemCategory(itemcat);
	}
}
