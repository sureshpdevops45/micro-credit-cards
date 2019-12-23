package com.creditcard.creditcards.service;

import com.creditcard.creditcards.dto.LoginResponseDto;

public interface LoginService {

	public LoginResponseDto loginUser(String userName, String password);

}
