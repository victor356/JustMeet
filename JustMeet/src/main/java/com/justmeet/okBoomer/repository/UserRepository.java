package com.justmeet.okBoomer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.justmeet.okBoomer.model.User;

/**
 * @author  Cippitelli, Rinaldi
 *
 */

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	
}
