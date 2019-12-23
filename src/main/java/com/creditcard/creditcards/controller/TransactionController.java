package com.creditcard.creditcards.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.creditcards.dto.TransactionRequestDto;
import com.creditcard.creditcards.dto.TransactionResponseDto;
import com.creditcard.creditcards.service.TransactionService;

@RestController
@RequestMapping("/transactions")
@CrossOrigin
public class TransactionController {
	
	//private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
	
	@Autowired 
	TransactionService transactionService;
	
	public TransactionResponseDto monthlyTransactions(@RequestBody TransactionRequestDto transactionRequestDto) {
		//logger.info("to get Monthly transactions");
		return transactionService.monthlyTransactions(transactionRequestDto);
	}


}

	

