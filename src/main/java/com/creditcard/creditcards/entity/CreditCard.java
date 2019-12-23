package com.creditcard.creditcards.entity;

import java.time.LocalDate;

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
@Table(name = "creditcard")
@Data
public class CreditCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cardId;

	private Long cardNumber;
	private Double cardlimit;
	private double balance;
	private Integer cvv;
	private LocalDate expiryDate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

}
