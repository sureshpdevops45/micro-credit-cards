package com.creditcard.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TransactionResponseDto {
	private Integer statuscode;
	private String message;
	private List<TransactionListResponseDto> transactionListResponseDto;
    private TransactionsDto transactionsDto;
}
