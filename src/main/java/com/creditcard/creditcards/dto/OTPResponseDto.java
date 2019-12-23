package com.creditcard.creditcards.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Api response.
 */
@Setter
@Getter
@NoArgsConstructor
public class OTPResponseDto {
    private Integer otpValue;
    private LocalDate date;
}
