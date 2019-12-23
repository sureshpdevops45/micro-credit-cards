package com.creditcard.creditcards.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {
	private Long userId;
	private String name;
	private Integer statusCode;
	private String message;
}
