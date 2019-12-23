package com.creditcard.creditcards.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.creditcard.creditcards.constant.Constant;
import com.creditcard.creditcards.dto.UserResponseDto;
import com.creditcard.creditcards.entity.User;
import com.creditcard.creditcards.exception.UserNotFoundException;
import com.creditcard.creditcards.repository.LoginRepository;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepository;

	@Override
	public UserResponseDto loginUser(String userName, String password) {
        
		UserResponseDto userResponseDto = new UserResponseDto();
		Optional<User> user = loginRepository.findByUserNameAndPassword(userName,password);
				
		if (!user.isPresent()) {
			throw new UserNotFoundException(Constant.USER_NOT_FOUND);
	}else {
		userResponseDto.setUserId(user.get().getUserId());
		userResponseDto.setName(user.get().getName());

		return userResponseDto;
	}
	}
}

