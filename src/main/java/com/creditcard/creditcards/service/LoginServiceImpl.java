package com.creditcard.creditcards.service;

import com.creditcard.creditcards.constant.Constant;
import com.creditcard.creditcards.dto.LoginResponseDto;
import com.creditcard.creditcards.entity.User;
import com.creditcard.creditcards.exception.UserNotFoundException;
import com.creditcard.creditcards.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginRepository loginRepository;

	@Override
	public LoginResponseDto loginUser(String userName, String password) {
        
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		Optional<User> user = loginRepository.findByUserNameAndPassword(userName,password);
				
		if (!user.isPresent()) {
			throw new UserNotFoundException(Constant.USER_NOT_FOUND);
	}else {
		loginResponseDto.setUserId(user.get().getUserId());
		loginResponseDto.setName(user.get().getName());

		return loginResponseDto;
	}
	}
}

