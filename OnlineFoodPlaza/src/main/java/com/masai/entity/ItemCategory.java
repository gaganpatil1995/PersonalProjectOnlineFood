package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data// @Setter  @Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class ItemCategory {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer catId ;
	String categoryName ;
	
//	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	List<Items> items = new ArrayList<>() ;

	
	
}
