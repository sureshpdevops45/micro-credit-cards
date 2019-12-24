package com.creditcard.service;

import com.creditcard.dto.ApiResponse;
import com.creditcard.dto.OTPResponseDto;

public interface OTPService {
    public ApiResponse generateOtp(Long userId);

    public OTPResponseDto getOtp(Long userId);
}
