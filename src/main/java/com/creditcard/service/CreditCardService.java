package com.creditcard.service;

import com.creditcard.dto.CreditCardResponseDto;

import java.util.Optional;

public interface CreditCardService {

    public Optional<CreditCardResponseDto> getCreditCard(Long userId) throws Exception;

}

