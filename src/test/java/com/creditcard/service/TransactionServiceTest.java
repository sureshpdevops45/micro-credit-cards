package com.creditcard.service;

import com.creditcard.dto.TransactionRequestDto;
import com.creditcard.entity.CreditCard;
import com.creditcard.entity.Transaction;
import com.creditcard.exception.TransactionNotFoundException;
import com.creditcard.repository.TransactionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;


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
