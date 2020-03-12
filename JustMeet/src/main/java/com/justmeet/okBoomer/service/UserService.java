package com.justmeet.okBoomer.service;

import com.justmeet.okBoomer.model.User;

/**
 * @author  Cippitelli, Rinaldi
 *
 */

public interface UserService {
    void save(User user);
	

    User findByUsername(String username);
}
