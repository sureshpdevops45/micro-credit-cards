package com.creditcard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
public class OTPResponseDto {
    private Integer otpValue;
    private LocalDate date;
}
