package com.masai.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Resturant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private	Integer resturantId ;
	private String managerName ;
	private String contactNo ;
	
	private String resturantName ;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address ;
	
	@OneToMany
	private List<Items> listOfItems ;
	
}
