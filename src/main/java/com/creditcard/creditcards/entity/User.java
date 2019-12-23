package com.creditcard.creditcards.entity;

import java.time.LocalDate;


import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String name;
	private String userName;
	private String password;
	private Double salary;
	private Long mobileNumber;
	private LocalDate dateOfBirth;
	private String address;
	@OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "card_id")
	private CreditCard creditCard;
	 
}
