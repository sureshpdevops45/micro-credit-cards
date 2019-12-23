package com.creditcard.creditcards.service;

import com.creditcard.creditcards.dto.CreditCardResponseDto;

import java.util.Optional;

public interface CreditCardService {

    public Optional<CreditCardResponseDto> getCreditCard(Long userId) throws Exception;

}

