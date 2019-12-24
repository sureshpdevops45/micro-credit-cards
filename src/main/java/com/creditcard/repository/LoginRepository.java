package com.creditcard.repository;

import com.creditcard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * This repository is used to get userDetails using the userName and password
 * 
 * @author Nivetha
 *
 */
@Repository
public interface LoginRepository extends JpaRepository<User,Long> {

	Optional<User> findByUserNameAndPassword(String userName, String password);

}
