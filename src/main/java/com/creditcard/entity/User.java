package com.creditcard.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="user")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String name;
	@Column(unique = true)
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
