package com.creditcard.service;

import com.creditcard.dto.LoginResponseDto;
import com.creditcard.exception.UserNotFoundException;

public interface LoginService {

	public LoginResponseDto loginUser(String userName, String password) throws UserNotFoundException;

}
