package com.creditcard.creditcards.service;

import com.creditcard.creditcards.dto.LoginResponseDto;

public interface LoginService {

	LoginResponseDto loginUser(String userName, String userPassword);

}
