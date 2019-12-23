package com.creditcard.creditcards.service;

import com.creditcard.creditcards.dto.LoginResponseDto;
import com.creditcard.creditcards.dto.UserResponseDto;

public interface LoginService {

	public LoginResponseDto loginUser(String userName, String password);

}
