package com.creditcard.creditcards.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.creditcards.dto.TransactionRequestDto;
import com.creditcard.creditcards.dto.TransactionResponseDto;
import com.creditcard.creditcards.exception.TransactionNotFoundException;
import com.creditcard.creditcards.service.TransactionService;


/**
 * This API is used to get the monthly transactions of the user by
 * giving the userId
 * @author Nivetha
 *
 */
@RestController
@RequestMapping("/transactions")
@CrossOrigin
public class TransactionController {
	
	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	/**
	 * This will inject all the implementations in the transactionService
	 */
	
	@Autowired 
	TransactionService transactionService;
	
	/**
	 * This API is used to get the monthly transactions for the user by giving the userId
	 * 
	 * @param transactionRequestDto This dto contains the userId,month and the year
	 * 
	 * @return This returns the transactionResponseDto which includes the transactionId,
	 * amount,status,description along with the statusCode and message
	 * 
	 * @throws TransactionNotFoundException occurs when transaction not found for the user
	 */
	
	@GetMapping
	public TransactionResponseDto monthlyTransactions(@RequestBody TransactionRequestDto transactionRequestDto) throws TransactionNotFoundException {
		logger.info("to get Monthly transactions");
		return transactionService.monthlyTransactions(transactionRequestDto);
	}


}

	

