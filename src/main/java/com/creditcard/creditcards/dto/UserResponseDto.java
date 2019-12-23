package com.creditcard.creditcards.dto;

import lombok.Getter;
import lombok.Setter;

import lombok.ToString;

import java.time.LocalDate;

@Setter
@Getter
@ToString
public class UserResponseDto {

    private Long userId;
    private String userName;
    private String password;
}
