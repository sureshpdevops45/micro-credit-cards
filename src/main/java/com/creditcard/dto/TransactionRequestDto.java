package com.creditcard.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionRequestDto {
	private Long userId;
	private String month;
	private Integer year;
}
