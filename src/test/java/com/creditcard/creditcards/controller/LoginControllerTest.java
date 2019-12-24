package com.creditcard.creditcards.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import com.creditcard.creditcards.constant.Constant;
import com.creditcard.creditcards.dto.LoginResponseDto;
import com.creditcard.creditcards.dto.UserLogin;
import com.creditcard.creditcards.exception.UserNotFoundException;
import com.creditcard.creditcards.service.LoginService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginControllerTest {

	@InjectMocks
	LoginController loginController;
	
	@Mock
	LoginService loginService;
	
	LoginResponseDto loginResponseDto=new LoginResponseDto();
	UserLogin userLogin=new UserLogin();
	
	@Test
	public void testLoginUser() throws UserNotFoundException {
		userLogin.setPassword("nnnn");
		userLogin.setUserName("nivi");
		loginResponseDto.setMessage(Constant.USER_FOUND);
		Mockito.when(loginService.loginUser("nivi", "nnnn")).thenReturn(loginResponseDto);
		ResponseEntity<LoginResponseDto> response=loginController.loginUser(userLogin);
		assertEquals(Constant.USER_FOUND, response.getBody().getMessage());
	}
	
	@Test
	public void testLoginUserNegative() throws UserNotFoundException {
		Mockito.when(loginService.loginUser("nivi", "nnnn")).thenReturn(null);
		ResponseEntity<LoginResponseDto> response=loginController.loginUser(userLogin);
		assertEquals(Constant.USER_NOT_FOUND, response.getBody().getMessage());
		
	}
}
