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


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class OwnerLoginSession {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ownerLoginId ;
	
	private Integer ownerId ;
	private LocalDateTime date ;
	private String apiKey ;
}
