package com.creditcard.controller;

import com.creditcard.dto.*;
import com.creditcard.exception.CustomException;
import com.creditcard.service.CreditCardServiceImpl;
import com.creditcard.service.OTPServiceImpl;
import com.creditcard.service.UserServiceImpl;
import com.creditcard.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

/**
 * @author Mahendran
 * User Controller
 */
@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private OTPServiceImpl otpService;
    @Autowired
    private CreditCardServiceImpl creditCardService;

    /**
     * add user
     *
     * @param userDto as input
     * @return {@Code ResponseEntity} as response
     * @throws Exception as output
     */
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

    /**
     * Generate OTP
     *
     * @param userId get user ID
     * @return {@Code ResponseEntity} as ApiResponse
     */
    @PostMapping("/{userId}/otp")
    public ResponseEntity<ApiResponse> generateOTP(@PathVariable("userId") Long userId) {
        logger.info("Entering into Generate Mobile Number controller");
        ApiResponse response = otpService.generateOtp(userId);
        if (response != null) {
            response.setStatusCode(Constants.SUCCESS_CODE);
            response.setMessage(Constants.USER_SUCCESS_MSG);
        } else {
            logger.error(Constants.FAILED_REGISTRATION);
            throw new CustomException(Constants.FAILED_REGISTRATION);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * get OTP of user
     *
     * @param userId as input
     * @return {@Code ResponseEntity} response
     */
    @GetMapping("/{userId}/otp")
    public ResponseEntity<OTPResponseDto> getOTP(@PathVariable("userId") Long userId) {
        logger.info("Entering into Generate Mobile Number controller");
        OTPResponseDto response = otpService.getOtp(userId);
        if (response == null) {
            logger.error(Constants.FAILED_REGISTRATION);
            throw new CustomException(Constants.FAILED_REGISTRATION);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * get credit cards
     *
     * @param userId passing user id
     * @return {@Code ResponseEntity} returns the response
     * @throws Exception
     */
    @GetMapping("/{userId}/creditcard")
    public ResponseEntity<CreditCardResponseDto> getCreditCards(@PathVariable("userId") Long userId) throws Exception {
        logger.info("Entering into getCreditCards controller");
        CreditCardResponseDto creditCardResponseDto = new CreditCardResponseDto();
        Optional<CreditCardResponseDto> creditCardResponseDtoOptional = creditCardService.getCreditCard(userId);
        if (creditCardResponseDtoOptional.isPresent()) {
            creditCardResponseDto = creditCardResponseDtoOptional.get();
        } else {
            throw new Exception("No more credit card is linked");
        }
        return new ResponseEntity<>(creditCardResponseDto, HttpStatus.OK);
    }
}
