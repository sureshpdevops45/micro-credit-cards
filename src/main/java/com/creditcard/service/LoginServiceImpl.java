package com.creditcard.service;

import com.creditcard.constant.Constant;
import com.creditcard.dto.LoginResponseDto;
import com.creditcard.entity.User;
import com.creditcard.exception.UserNotFoundException;
import com.creditcard.repository.LoginRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * This API is used to login the user using the userName and password to get the
 * userDetails
 * 
 * @author Nivetha
 *
 */

@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);


	/**
	 * This will inject all the implementations in the loginService
	 */

	@Autowired
	LoginRepository loginRepository;

	/**
	 * This API is used to login the user using the userName and password to get the
	 * name and userId
	 * 
	 * @param userLogin This dto contains the userName and password to check the
	 *                  credentials
	 * 
	 * @return This returns the LoginResponseDto which includes name,userId along
	 *         with the statuscode and message
	 *         
	 * @throws UserNotFoundException occurs when user not found or given wrong credentials
	 */

	@Override
	public LoginResponseDto loginUser(String userName, String password) throws UserNotFoundException {
		logger.info("login the user");
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		Optional<User> user = loginRepository.findByUserNameAndPassword(userName, password);
		if (!user.isPresent()) {
			logger.error("If user does not exist");
			throw new UserNotFoundException(Constant.USER_NOT_FOUND);
		} else {
			loginResponseDto.setUserId(user.get().getUserId());
			loginResponseDto.setName(user.get().getName());

			return loginResponseDto;
		}
	}
}
