package com.creditcard.creditcards.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionResponseDto {
	private Integer statuscode;
	private String message;
	private List<TransactionListResponseDto> transactionListResponseDto;

}
