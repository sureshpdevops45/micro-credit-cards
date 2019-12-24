package com.creditcard.repository;

import com.creditcard.entity.OTP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OTPRepository extends JpaRepository<OTP, Long> {

    OTP findByUserUserId(Long userId);

}
