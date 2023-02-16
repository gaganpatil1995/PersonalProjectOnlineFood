package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ownerId;
	private String name ;
	private Integer age ;
	private String email ;
	private String password ;
	private String mobileNo ;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	List<Resturant> resturantId = new ArrayList<>() ; 
	
	@OneToOne(cascade = CascadeType.ALL)
	Address address ;
}
