package com.creditcard.creditcards.controller;

import com.creditcard.creditcards.dto.LoginResponseDto;
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
	public ResponseEntity<LoginResponseDto> loginUser(@RequestBody UserLogin userLogin) {
		logger.info("Inside validating user method");
		LoginResponseDto loginResponseDto = userService.loginUser(userLogin.getUserName(), userLogin.getPassword());
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
