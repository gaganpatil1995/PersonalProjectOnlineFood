package com.masai.service;

import java.util.List;

import com.masai.entity.Items;
import com.masai.entity.Resturant;
import com.masai.exception.ItemsException;
import com.masai.exception.ResturantException;


public interface ResturantService {
	
	public Resturant addResturant(Resturant res);
	public String RemoveResturant(Integer Id)throws ResturantException;
    public List<Resturant> getAllResturant() throws ResturantException;
    public Resturant getResturantById(Integer resturantId)throws ResturantException ;
    
    public List<Items> AddResturantItems(Integer ResId,Items item) throws ResturantException;
    public List<Items> getAllItemsFromresturant(Integer resId) throws ResturantException ;
    public List<Items> getAllItems()throws ItemsException;
    public Items addItems(Items item);
    public Items getItemsById(Integer itemId)throws ItemsException ;
    public Items updateItems(Items item)throws ItemsException ; 
    public String removeItemsById(Integer itemId)throws ItemsException ;
    
}
