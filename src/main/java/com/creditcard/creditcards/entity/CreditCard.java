package com.creditcard.creditcards.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

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
