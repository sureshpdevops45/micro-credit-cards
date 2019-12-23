package com.creditcard.creditcards.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
	
	private Long userId;
	private String name;
	private String userName;
	private String password;
	private Double salary;
	private Long mobileNumber;
	private LocalDate dateOfBirth;
	private String address;
	
	@OneToOne
	@JoinColumn(name = "cardId")
	private CreditCard creditCard;
}
