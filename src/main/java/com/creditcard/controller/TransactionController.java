package com.creditcard.controller;

import com.creditcard.dto.TransactionRequestDto;
import com.creditcard.dto.TransactionResponseDto;
import com.creditcard.dto.TransactionsDto;
import com.creditcard.exception.TransactionNotFoundException;
import com.creditcard.service.TransactionService;
import com.creditcard.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * This API is used to get the monthly transactions of the user by
 * giving the userId
 *
 * @author Nivetha
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
     * @return This returns the transactionResponseDto which includes the transactionId,
     * amount,status,description along with the statusCode and message
     * @throws TransactionNotFoundException occurs when transaction not found for the user
     */

    @PostMapping("/{userId}/reports")
    public TransactionResponseDto monthlyTransactions(@PathVariable("userId") Long userId,
		@RequestBody TransactionRequestDto transactionRequestDto) throws TransactionNotFoundException {
    	transactionRequestDto.setUserId(userId);
        logger.info("to get Monthly transactions");
        return transactionService.monthlyTransactions(transactionRequestDto);
    }

	/**
	 * adding transactions
	 * @param transactionsDto as input to method
	 * @return {@Code ResponseEntity} as response
	 */
	@PostMapping
    public ResponseEntity<TransactionResponseDto> addTransactions(@RequestBody TransactionsDto transactionsDto) {
		TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
    	transactionsDto = transactionService.addTransactions(transactionsDto);
        if (transactionsDto != null) {
            transactionResponseDto.setTransactionsDto(transactionsDto);
            transactionResponseDto.setMessage(Constants.SUCCESS);
            transactionResponseDto.setStatuscode(Constants.SUCCESS_CODE);
        } else {
            transactionResponseDto.setMessage(Constants.FAILED_MSG);
            transactionResponseDto.setStatuscode(Constants.FAIL_CODE);
        }
        return new ResponseEntity<>(transactionResponseDto, HttpStatus.OK);
    }


}

	

