package com.creditcard.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

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
