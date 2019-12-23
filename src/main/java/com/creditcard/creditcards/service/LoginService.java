package com.creditcard.creditcards.service;

import com.creditcard.creditcards.dto.LoginResponseDto;
import com.creditcard.creditcards.exception.UserNotFoundException;

public interface LoginService {

	public LoginResponseDto loginUser(String userName, String password) throws UserNotFoundException;

}
