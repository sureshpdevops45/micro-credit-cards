package com.creditcard.creditcards.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
	private Long userId;
	private String name;
	private Integer statusCode;
	private String message;
}
