package com.creditcard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


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
