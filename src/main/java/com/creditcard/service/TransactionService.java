package com.creditcard.service;

import com.creditcard.dto.TransactionRequestDto;
import com.creditcard.dto.TransactionResponseDto;
import com.creditcard.dto.TransactionsDto;
import com.creditcard.exception.TransactionNotFoundException;

public interface TransactionService {

    TransactionResponseDto monthlyTransactions(TransactionRequestDto transactionRequestDto) throws TransactionNotFoundException;

    TransactionsDto addTransactions(TransactionsDto transactionsDto);
}
