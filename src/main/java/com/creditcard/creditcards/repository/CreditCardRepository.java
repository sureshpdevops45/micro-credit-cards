package com.creditcard.creditcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditcard.creditcards.entity.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {
	
}
