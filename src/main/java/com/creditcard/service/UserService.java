package com.creditcard.service;

import com.creditcard.dto.UserDto;
import com.creditcard.dto.UserResponseDto;

public interface UserService {

	public UserResponseDto addUser(UserDto userDto) throws Exception;

}
