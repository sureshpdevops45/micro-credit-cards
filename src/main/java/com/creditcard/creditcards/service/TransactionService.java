package com.creditcard.creditcards.service;

import java.util.List;

import com.creditcard.creditcards.dto.TransactionListResponseDto;
import com.creditcard.creditcards.dto.TransactionRequestDto;
import com.creditcard.creditcards.dto.TransactionResponseDto;

public interface TransactionService {

	TransactionResponseDto monthlyTransactions(TransactionRequestDto transactionRequestDto);

}
