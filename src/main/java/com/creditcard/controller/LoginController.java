package com.creditcard.controller;

import com.creditcard.constant.Constant;
import com.creditcard.dto.LoginResponseDto;
import com.creditcard.dto.UserLogin;
import com.creditcard.exception.UserNotFoundException;
import com.creditcard.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * This API is used to login the user using the userName and password
 * to get the userDetails
 * 
 * @author Nivetha
 *
 */

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	/**
	 * This will inject all the implementations in the loginService
	 */

	@Autowired
	LoginService loginService;
	
	/**
	 * This API is used to login the user using the userName and password 
	 * to get the name and userId
	 * 
	 * @param userLogin This dto contains the userName and password to check the credentials
	 * 
	 * @return This returns the LoginResponseDto which includes name,userId 
	 * along with the statuscode and message
	 * 
	 * @throws UserNotFoundException occurs when user not found
	 */

	@PostMapping
	public ResponseEntity<LoginResponseDto> loginUser(@RequestBody UserLogin userLogin) throws UserNotFoundException {
		logger.info("Inside validating user method");
		LoginResponseDto loginResponseDto = loginService.loginUser(userLogin.getUserName(), userLogin.getPassword());
		if (loginResponseDto != null) {
			loginResponseDto.setStatusCode(Constant.VALID_CREDENTIALS);
			loginResponseDto.setMessage(Constant.USER_FOUND);
			return new ResponseEntity<>(loginResponseDto, HttpStatus.OK);
		} else {
			loginResponseDto = new LoginResponseDto();
			loginResponseDto.setStatusCode(Constant.INVALID_CREDENTIALS);
			loginResponseDto.setMessage(Constant.USER_NOT_FOUND);
			return new ResponseEntity<>(loginResponseDto, HttpStatus.NOT_FOUND);
		}

	}
}
