package com.creditcard.repository;

import com.creditcard.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * This repository is used to find the transactions details at the particular
 * month
 * 
 * @author Nivetha
 *
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

	List<Transaction> findAllByCreditCardCardIdAndDateBetween(Long cardId, LocalDate startDate, LocalDate endDate);

}
