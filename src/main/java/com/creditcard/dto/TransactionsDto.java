package com.creditcard.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class TransactionsDto {
    private Long transactionId;
    private Double amount;
    private LocalDate date;
    private String status;
    private String description;
    private Long cardId;

}
