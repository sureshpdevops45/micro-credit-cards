package com.creditcard.creditcards.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	private Double amount;
	private LocalDate date;
	private String status;
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "card_id")
	private CreditCard creditCard;

}
