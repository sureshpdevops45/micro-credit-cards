package com.creditcard.creditcards.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class LoginResponseDto {

    private Long userId;
    private String name;
    private String message;
    private Integer statusCode;
}
