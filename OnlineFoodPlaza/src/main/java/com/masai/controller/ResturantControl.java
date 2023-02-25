package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.entity.Items;
import com.masai.entity.Resturant;
import com.masai.exception.ItemsException;
import com.masai.exception.ResturantException;
import com.masai.repository.ItemCategoryDao;
import com.masai.service.ResturantServiceImpl;

@RestController
public class ResturantControl {

	@Autowired
	ResturantServiceImpl resService ;
	
	@Autowired
	ItemCategoryDao itemCatDao ;
	
	@PostMapping("/resturant")
	public ResponseEntity<Resturant> addResturant(@RequestBody Resturant res) {
	 return	new ResponseEntity<>(resService.addResturant(res),HttpStatus.OK) ;
	}
	
	@DeleteMapping("/resturant/{id}")
	public ResponseEntity<String> RemoveResturant(@PathVariable Integer id) {
		
		return new ResponseEntity<>(resService.RemoveResturant(id),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/resturant")
	public ResponseEntity<List<Resturant>> getAllResturant() throws ResturantException {
		return new ResponseEntity<>(resService.getAllResturant(),HttpStatus.FOUND );
	}
	
	@GetMapping("/getResturantById")
	public ResponseEntity<Resturant> getResturantById(@RequestParam Integer resId) throws ResturantException{
		return new ResponseEntity<>(resService.getResturantById(resId),HttpStatus.FOUND);
	}
	
	
	
	@PutMapping("/resturanItem/{id}")
	public ResponseEntity<List<Items>> addItemCategory(@PathVariable Integer id,@RequestBody Items item) throws ResturantException {
		return new ResponseEntity<>(resService.AddResturantItems(id, item) , HttpStatus.CREATED);
	}
	
	@GetMapping("/getItemsfromRes")
	public ResponseEntity<List<Items>> getAllItemsFromRestro(@RequestParam Integer resId)throws ResturantException{
		
		return new ResponseEntity<>(resService.getAllItemsFromresturant(resId),HttpStatus.FOUND);
	}
	
	@GetMapping("/getAllItems")
	public ResponseEntity<List<Items>> getAllItems()throws ItemsException{
		return new ResponseEntity<>(resService.getAllItems() ,HttpStatus.FOUND);
	}
	
	@PostMapping("/items")
	public ResponseEntity<Items> additems(@RequestBody Items item){
		return new ResponseEntity<>(resService.addItems(item),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/items")
	public ResponseEntity<Items> getItemsById(@RequestParam Integer itemId)throws ItemsException{
		return new ResponseEntity<>(resService.getItemsById(itemId),HttpStatus.CONTINUE);
	}
	@PutMapping("/items")
	public ResponseEntity<Items> updateItems(@RequestBody Items item)throws ItemsException{
		return new ResponseEntity<>(resService.updateItems(item),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("items")
	public ResponseEntity<String> deleteItemsById(@RequestParam Integer itemId)throws ItemsException{
		return new ResponseEntity<>(resService.removeItemsById(itemId),HttpStatus.GONE);
	}
	
}
