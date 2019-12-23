package com.creditcard.creditcards.service;

import com.creditcard.creditcards.dto.TransactionRequestDto;
import com.creditcard.creditcards.dto.TransactionResponseDto;
import com.creditcard.creditcards.exception.TransactionNotFoundException;

public interface TransactionService {

	TransactionResponseDto monthlyTransactions(TransactionRequestDto transactionRequestDto) throws TransactionNotFoundException;

}
