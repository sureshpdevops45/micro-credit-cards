package com.creditcard.creditcards.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Api response.
 */
@Setter
@Getter
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private int statusCode;
    private UserResponseDto userResponseDto;
}
