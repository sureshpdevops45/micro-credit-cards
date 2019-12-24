package com.creditcard.service;


import com.creditcard.controller.UserController;
import com.creditcard.dto.UserDto;
import com.creditcard.dto.UserResponseDto;
import com.creditcard.entity.CreditCard;
import com.creditcard.entity.User;
import com.creditcard.exception.CustomException;
import com.creditcard.repository.CreditCardRepository;
import com.creditcard.repository.UserRepository;
import com.creditcard.util.Constants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Period;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Value("${creditcard.limit.increase}")
    Integer creditCardLimit;

    @Value("${registration.age.limit}")
    Integer ageLimit;


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreditCardRepository creditCardRepository;

    @Transactional
    @Override
    public UserResponseDto addUser(UserDto userDto) throws Exception {
        logger.info("adding User service ");
        UserResponseDto userResponseDto = new UserResponseDto();
        int years = Period.between(userDto.getDob(), LocalDate.now()).getYears();
        if (years >= ageLimit) {
            User user = new User();
            CreditCard creditCard = new CreditCard();
            userDto.setPassword(Constants.generateRandomNumbers(StringUtils.EMPTY, 11));
            Long creditCardNumber = Long.parseLong(Constants.generateRandomNumbers(Constants.CREDIT_CARD_STARTING_NUMBER, 17));
            Integer ccvNumber = Integer.parseInt(Constants.generateRandomNumbers(StringUtils.EMPTY, 4));
            Double limit = userDto.getSalary() + (userDto.getSalary() * creditCardLimit / 100);
            Double balance = new Double(limit);
            LocalDate expireDate = LocalDate.now().plusYears(5);

            setCreditCardValues(creditCard, creditCardNumber, ccvNumber, limit, balance, expireDate);

            logger.info("adding User service " + creditCard);

            BeanUtils.copyProperties(userDto, user);
            try {
                creditCard = creditCardRepository.save(creditCard);
                user.setCreditCard(creditCard);
                user = userRepository.save(user);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
                throw new Exception("User Name already exists");
            }

            BeanUtils.copyProperties(user, userResponseDto);
        } else {
            throw new CustomException("You should have completed 18 years for do registration");
        }
        return userResponseDto;
    }

    private void setCreditCardValues(CreditCard creditCard, Long creditCardNumber, Integer ccvNumber, Double limit, Double balance, LocalDate expireDate) {
        creditCard.setBalance(balance);
        creditCard.setCardlimit(limit);
        creditCard.setCardNumber(creditCardNumber);
        creditCard.setCvv(ccvNumber);
        creditCard.setExpiryDate(expireDate);
    }


}
