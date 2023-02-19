package com.masai.service;

import java.util.List;

import com.masai.entity.Items;
import com.masai.entity.Resturant;
import com.masai.exception.ItemsException;
import com.masai.exception.ResturantException;


public interface ResturantService {
	
	public Resturant addResturant(Resturant res);
	public String RemoveResturant(Integer Id)throws ResturantException;
	public List<Items> AddResturantItems(Integer ResId,Items item) throws ResturantException;
     public List<Resturant> getAllResturant() throws ResturantException;
    
     public Resturant getResturantById(Integer resturantId)throws ResturantException ;
}
