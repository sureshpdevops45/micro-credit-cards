package com.creditcard.creditcards.service;

import com.creditcard.creditcards.dto.CreditCardResponseDto;
import com.creditcard.creditcards.entity.CreditCard;
import com.creditcard.creditcards.entity.User;
import com.creditcard.creditcards.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    private Logger logger = LoggerFactory.getLogger(CreditCardServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<CreditCardResponseDto> getCreditCard(Long userId) throws Exception {
        CreditCardResponseDto creditCardDto = null;
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            creditCardDto = new CreditCardResponseDto();
            CreditCard creditCard = user.getCreditCard();
            BeanUtils.copyProperties(creditCard, creditCardDto);
        }
        return Optional.ofNullable(creditCardDto);
    }
}
