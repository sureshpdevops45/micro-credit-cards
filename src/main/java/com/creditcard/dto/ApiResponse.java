package com.creditcard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private int statusCode;
    private UserResponseDto userResponseDto;
}
