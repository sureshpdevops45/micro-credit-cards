package com.creditcard.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDto {
	
	private Long userId;
	private String userName;
	private String password;

}
