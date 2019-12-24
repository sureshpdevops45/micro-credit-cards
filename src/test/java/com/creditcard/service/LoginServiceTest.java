package com.creditcard.service;

import com.creditcard.constant.Constant;
import com.creditcard.dto.LoginResponseDto;
import com.creditcard.dto.UserLogin;
import com.creditcard.entity.User;
import com.creditcard.exception.UserNotFoundException;
import com.creditcard.repository.LoginRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.Silent.class)
public class LoginServiceTest {
	
	@InjectMocks
	LoginServiceImpl loginServiceImpl;
	
	@Mock
	LoginRepository loginRepository;
	
	@Test
	public void testLoginUser() throws UserNotFoundException {
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage(Constant.USER_FOUND);
		loginResponseDto.setName("nivi");
		loginResponseDto.setStatusCode(200);
		loginResponseDto.setUserId(1L);
		User user=new User();
		user.setName("nivi");
		user.setUserId(1L);
		UserLogin userLogin=new UserLogin();
		userLogin.setPassword("123");
		userLogin.setUserName("nivi");
		Mockito.when(loginRepository.findByUserNameAndPassword("nivi", "123")).thenReturn(Optional.of(user));
//		LoginResponseDto response=loginServiceImpl.loginUser("nivi", "nnnn");
//		assertEquals(Constant.USER_FOUND, response.getMessage());
	}
    
	@Test
	public void testLoginUserForUserNotFound() throws UserNotFoundException {
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage(Constant.USER_NOT_FOUND);
		loginResponseDto.setName("nivi");
		loginResponseDto.setStatusCode(200);
		loginResponseDto.setUserId(1L);
		User user=new User();
		user.setName("nivi");
		user.setUserId(1L);
		UserLogin userLogin=new UserLogin();
		userLogin.setPassword("123");
		userLogin.setUserName("nivi");
		Mockito.when(loginRepository.findByUserNameAndPassword("nivi", "123")).thenReturn(Optional.of(user));
		
		
	}

}
