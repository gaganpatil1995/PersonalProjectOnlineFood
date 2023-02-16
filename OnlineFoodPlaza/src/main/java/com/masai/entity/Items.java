package com.masai.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemId ;
	private String itemName ;
	private Integer itemQuantity;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JsonIgnore
	private ItemCategory category ;
	
	private Integer itemCost ;
     
	
	
	
}
