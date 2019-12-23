package com.creditcard.creditcards.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionRequestDto {
	private Long userId;
	private Integer month;
	private Integer year;
}
