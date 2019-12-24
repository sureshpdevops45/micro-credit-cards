package com.creditcard.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "creditcard")
@Data
@ToString
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cardId;
	private Long cardNumber;
	private Double cardlimit;
	private double balance;
	private Integer cvv;
	private LocalDate expiryDate;

	 

}
