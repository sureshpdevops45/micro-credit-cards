package com.creditcard.creditcards.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class CreditCardResponseDto {
    private Long cardId;
    private Long cardNumber;
    private Double cardlimit;
    private double balance;
    private Integer cvv;
    private LocalDate expiryDate;
}
