package com.creditcard.creditcards.service;

import com.creditcard.creditcards.dto.UserResponseDto;

public interface LoginService {

	UserResponseDto loginUser(String userName, String userPassword);

}
