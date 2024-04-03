package com.example.customer.entities;
 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	private String name;
    
	@Column(unique = true)
	private String email;
	

	@Column(unique = true)
	private String mobile;
	
	private String pass;
	
    @Transient 
	private String extra;
	
}


