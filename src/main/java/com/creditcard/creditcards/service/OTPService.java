package com.creditcard.creditcards.service;

import com.creditcard.creditcards.dto.ApiResponse;
import com.creditcard.creditcards.dto.OTPResponseDto;

public interface OTPService {
    public ApiResponse generateOtp(Long userId);

    public OTPResponseDto getOtp(Long userId);
}
