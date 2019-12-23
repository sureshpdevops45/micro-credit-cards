package com.creditcard.creditcards.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.creditcard.creditcards.constant.Constant;
import com.creditcard.creditcards.dto.UserLogin;
import com.creditcard.creditcards.dto.UserResponseDto;
import com.creditcard.creditcards.service.LoginService;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService userService;

	@PostMapping
	public ResponseEntity<UserResponseDto> loginUser(@RequestBody UserLogin userLogin) {
		logger.info("Inside validating user method");
		UserResponseDto	userResponseDto = userService.loginUser(userLogin.getUserName(), userLogin.getPassword());
		if (userResponseDto != null) {
			userResponseDto.setStatusCode(Constant.VALID_CREDENTIALS);
			userResponseDto.setMessage(Constant.USER_FOUND);
			return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
		} else {
			userResponseDto = new UserResponseDto();
			userResponseDto.setStatusCode(Constant.INVALID_CREDENTIALS);
			userResponseDto.setMessage(Constant.USER_NOT_FOUND);
			return new ResponseEntity<>(userResponseDto, HttpStatus.NOT_FOUND);
		}

	}
}
