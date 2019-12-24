package com.creditcard.creditcards.controller;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.creditcard.creditcards.constant.Constant;
import com.creditcard.creditcards.dto.ApiResponse;
import com.creditcard.creditcards.dto.UserDto;
import com.creditcard.creditcards.dto.UserResponseDto;
import com.creditcard.creditcards.service.UserService;
import com.creditcard.creditcards.util.Constants;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserControllerTest {
	
	@InjectMocks 
	UserController userController;
	
	@Mock
	UserService userService;
	
	
	@Test
	public void testAddUser() throws Exception {
		UserDto userDto=new UserDto();
		userDto.setAddress("vellore");
		userDto.setCreditCardId(1L);
		userDto.setMobileNumber(9898989898L);
		userDto.setName("nivi");
		userDto.setPassword("mmmm");
		userDto.setSalary(29999.99);
		userDto.setUserId(2L);
		userDto.setUserName("abcd");
		userDto.setDob(LocalDate.of(2019, 9, 9));
		
		ApiResponse responses=new ApiResponse();
		UserResponseDto response =new UserResponseDto();
		
		response.setPassword("dddd");
		response.setUserId(1L);
		response.setUserName("Nivi");
		responses.setMessage(Constants.USER_SUCCESS_MSG);
		responses.setStatusCode(Constants.SUCCESS_CODE);
		responses.setUserResponseDto(response);
		
		Mockito.when(userService.addUser(userDto)).thenReturn(response);
//		ResponseEntity<ApiResponse> responses1=userController.addUser(userDto);
//		assertEquals(Constants.SUCCESS_CODE, responses1.getBody().getStatusCode());
//		assertEquals(Constants.USER_SUCCESS_MSG, responses1.getBody().getMessage());
		
		
	}

}
