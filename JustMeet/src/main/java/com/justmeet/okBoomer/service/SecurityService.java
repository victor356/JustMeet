package com.justmeet.okBoomer.service;

/**
 * @author  Cippitelli, Rinaldi
 *
 */


public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
