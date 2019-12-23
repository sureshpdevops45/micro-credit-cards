package com.creditcard.creditcards.controller;

import com.creditcard.creditcards.dto.ApiResponse;
import com.creditcard.creditcards.dto.UserDto;
import com.creditcard.creditcards.dto.UserResponseDto;
import com.creditcard.creditcards.exception.CustomException;
import com.creditcard.creditcards.service.UserServiceImpl;
import com.creditcard.creditcards.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<ApiResponse> addUser(@RequestBody @Valid UserDto userDto) throws Exception {
        logger.info("Entering into addUser controller");
        ApiResponse response = new ApiResponse();
        UserResponseDto userResponseDto = userService.addUser(userDto);
        if (userResponseDto != null) {
            response.setUserResponseDto(userResponseDto);
            response.setStatusCode(Constants.SUCCESS_CODE);
            response.setMessage(Constants.USER_SUCCESS_MSG);
        } else {
            logger.error(Constants.FAILED_REGISTRATION);
            throw new CustomException(Constants.FAILED_REGISTRATION);
        }
        logger.info("existing add user " + userResponseDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
/*
    @PostMapping("/{userId}/otp/{mobileNumber}")
    public ResponseEntity<ApiResponse> generateOTP(@PathVariable("userId") Long userId,
                                                   @PathVariable("mobileNumber") Long mobileNumber) {
        logger.info("Entering into Generate Mobile Number controller");
        ApiResponse response = new ApiResponse();
        UserResponseDto userResponseDto = userService.generteOtp(userId, mobileNumber);
        if (userResponseDto != null) {
            response.setUserResponseDto(userResponseDto);
            response.setStatusCode(Constants.SUCCESS_CODE);
            response.setMessage(Constants.USER_SUCCESS_MSG);
        } else {
            logger.error(Constants.FAILED_REGISTRATION);
            throw new CustomException(Constants.FAILED_REGISTRATION);
        }
        logger.info("existing add user " + userResponseDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
*/

}
