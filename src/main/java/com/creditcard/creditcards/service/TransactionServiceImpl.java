package com.creditcard.creditcards.service;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.creditcards.constant.Constant;
import com.creditcard.creditcards.dto.TransactionListResponseDto;
import com.creditcard.creditcards.dto.TransactionRequestDto;
import com.creditcard.creditcards.dto.TransactionResponseDto;
import com.creditcard.creditcards.entity.Transaction;
import com.creditcard.creditcards.entity.User;
import com.creditcard.creditcards.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public TransactionResponseDto monthlyTransactions(TransactionRequestDto transactionRequestDto) {
		String month = String.format("%02d", transactionRequestDto.getMonth());
		Integer year = transactionRequestDto.getYear();
		LocalDate endDate = Year.parse(transactionRequestDto.getYear().toString()).atMonth(transactionRequestDto.getMonth()).atEndOfMonth();
		LocalDate startDate = LocalDate.parse(year+"-"+month+"-"+"01");

		User user = new User();
		user.setUserId(transactionRequestDto.getUserId());
		User userId=null;
		
//		List<Transaction> transactions = transactionRepository.getAllByUserAndTransactionDateBetween(userId,
//				startDate, endDate);
//		List<TransactionListResponseDto> transactionListResponseDtoList = new ArrayList<>();
//		transactions.forEach(transaction -> {
//			TransactionListResponseDto transactionListResponseDto = new TransactionListResponseDto();
//			transactionListResponseDto.setAmount(transaction.getAmount());
//			transactionListResponseDto.setDate(transaction.getDate());
//			transactionListResponseDto.setDescription(transaction.getDescription());
//			transactionListResponseDto.setStatus(transaction.getStatus());
//			transactionListResponseDto.setTransactionId(transaction.getTransactionId());
//			transactionListResponseDtoList.add(transactionListResponseDto);
//		});
//		TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
//		transactionResponseDto.setTransactionListResponseDto(transactionListResponseDtoList);
//		transactionResponseDto.setStatuscode(Constant.ACCEPTED);
//		transactionResponseDto.setMessage(Constant.SUCCESS);

//		return transactionResponseDto;
		return null;
	}

}



	
