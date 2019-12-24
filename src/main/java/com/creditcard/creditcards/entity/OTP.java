package com.creditcard.creditcards.entity;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "otp")
@Data
@ToString
public class OTP {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long otpId;
	private Integer otpValue;
	private LocalDate date;
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
}
