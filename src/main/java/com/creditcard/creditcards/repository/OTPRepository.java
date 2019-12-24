package com.creditcard.creditcards.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditcard.creditcards.entity.OTP;

@Repository
public interface OTPRepository extends JpaRepository<OTP, Long> {

    OTP findByUserUserId(Long userId);

}
