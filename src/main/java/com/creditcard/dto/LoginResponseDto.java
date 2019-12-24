package com.creditcard.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginResponseDto {
	private Long userId;
	private String name;
	private Integer statusCode;
	private String message;
}
