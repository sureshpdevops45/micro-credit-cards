package com.creditcard.creditcards.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditcard.creditcards.entity.User;

@Repository
public interface LoginRepository extends JpaRepository<User,Long> {

	Optional<User> findByUserNameAndPassword(String userName, String password);

}
