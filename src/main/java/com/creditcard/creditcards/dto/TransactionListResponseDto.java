package com.creditcard.creditcards.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TransactionListResponseDto {
	
    private Long transactionId;
	private Double amount;
	private LocalDate date;
	private String status;
	private String description;
	

}
