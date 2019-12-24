package com.creditcard.creditcards.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.creditcard.creditcards.dto.TransactionRequestDto;
import com.creditcard.creditcards.entity.CreditCard;
import com.creditcard.creditcards.entity.Transaction;
import com.creditcard.creditcards.exception.TransactionNotFoundException;
import com.creditcard.creditcards.repository.TransactionRepository;


@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionServiceTest {

	@InjectMocks
	TransactionServiceImpl transactionService;

	@Mock
	TransactionRepository transactionRepository;
   
	@Test
	public void testMonthlyTransactions() throws TransactionNotFoundException {

		TransactionRequestDto transactionRequestDto = new TransactionRequestDto();
		transactionRequestDto.setUserId(1L);
		transactionRequestDto.setMonth("01");
		transactionRequestDto.setYear(2019);
		CreditCard creditCard=new CreditCard();
		creditCard.setCardId(2L);
		List<Transaction> transactions = new ArrayList<>();
	    Mockito.when(transactionRepository.findAllByCreditCardCardIdAndDateBetween
	    		(Mockito.any() , Mockito.any(),Mockito.any())).thenReturn(transactions);
		Transaction transaction = new Transaction();
		transaction.setAmount(20000.00);
		transaction.setCreditCard(creditCard);
		transaction.setDescription("purchase");
		transaction.setStatus("success");
		transaction.setTransactionId(1L);
		transactions.add(transaction);
		}

}
