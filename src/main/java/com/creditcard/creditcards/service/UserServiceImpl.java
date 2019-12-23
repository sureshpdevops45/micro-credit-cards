package com.creditcard.creditcards.service;

import com.creditcard.creditcards.controller.UserController;
import com.creditcard.creditcards.dto.UserDto;
import com.creditcard.creditcards.dto.UserResponseDto;
import com.creditcard.creditcards.entity.CreditCard;
import com.creditcard.creditcards.entity.User;
import com.creditcard.creditcards.repository.CreditCardRepository;
import com.creditcard.creditcards.repository.UserRepository;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    private Random random = new Random(System.currentTimeMillis());

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Transactional
    public UserResponseDto addUser(UserDto userDto) {
        logger.info("adding User service ");
        User user = new User();
        CreditCard creditCard = new CreditCard();

        Long creditCardNumber = Long.parseLong(generateRandomNumbers("1001", 16));
        Integer ccvNumber = Integer.parseInt(generateRandomNumbers(StringUtils.EMPTY, 3));
        Double limit = userDto.getSalary() + (userDto.getSalary() * 20 / 100);
        Double balance = new Double(limit);
        LocalDate expireDate = LocalDate.now().plusYears(5);

        creditCard.setBalance(balance);
        creditCard.setCardlimit(limit);
        creditCard.setCardNumber(creditCardNumber);
        creditCard.setCvv(ccvNumber);
        creditCard.setExpiryDate(expireDate);

        logger.info("adding User service " + creditCard);

        BeanUtils.copyProperties(userDto, user);
        creditCard = creditCardRepository.save(creditCard);
        user.setCreditCard(creditCard);
        user = userRepository.save(user);
        UserResponseDto userResponseDto = new UserResponseDto();
        BeanUtils.copyProperties(user, userResponseDto);
        return userResponseDto;
    }

    private String generateRandomNumbers(String startingDigit, int length) {
        StringBuilder builder = new StringBuilder(startingDigit);
        int randomNumberLength = length - (startingDigit.length() + 1);
        for (int i = 0; i < randomNumberLength; i++) {
            int digit = this.random.nextInt(10);
            builder.append(digit);
        }
        return builder.toString();
    }

//    public void generateOtp(Long userId, Long mobileNumber) {
//        /*
//        id
//otp_value
//date
//status
//mobile_number
//         */
//
//        int otpNumber = Integer.parseInt(generateRandomNumbers(StringUtils.EMPTY, 4));
//
//    }

}
