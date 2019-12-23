package com.creditcard.creditcards.dto;

import lombok.Getter;
import lombok.Setter;

import lombok.ToString;

import java.time.LocalDate;

@Setter
public class LoginResponseDto {
	private Long userId;
	private String name;
	private Integer statusCode;
	private String message;
}
