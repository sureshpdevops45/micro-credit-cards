package com.creditcard.creditcards.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OTPResponseDto {
    private Integer otpValue;
    private LocalDate date;
}
