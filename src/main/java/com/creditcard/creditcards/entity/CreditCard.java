package com.creditcard.creditcards.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.Data;
import lombok.ToString;


@Entity
@Table(name="creditcard")
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
