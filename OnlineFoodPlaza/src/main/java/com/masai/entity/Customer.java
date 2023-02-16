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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	private String firstName;
	private String lastName;
	private Integer age;
	private String gender;
	private String mobileNumber;
	private String password ;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetail = new ArrayList<>() ;
	
	private String email;
//	/**
//	 * @param customerId
//	 * @param firstName
//	 * @param lastName
//	 * @param age
//	 * @param gender
//	 * @param mobileNumber
//	 * @param address
//	 * @param email
//	 */
	
	
	
	
}
