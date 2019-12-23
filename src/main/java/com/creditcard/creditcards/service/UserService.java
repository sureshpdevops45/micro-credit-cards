package com.creditcard.creditcards.service;

import com.creditcard.creditcards.dto.UserDto;
import com.creditcard.creditcards.dto.UserResponseDto;

public interface UserService {

	public UserResponseDto addUser(UserDto userDto) throws Exception;

}
