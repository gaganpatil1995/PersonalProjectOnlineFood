package com.masai.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
public class CustomerLoginSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer loginId ;
    
    private Integer customerId ;
    
    private String apiKey ;
    
    private LocalDateTime date ;
	
}
