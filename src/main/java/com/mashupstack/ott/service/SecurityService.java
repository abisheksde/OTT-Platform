package com.mashupstack.ott.service;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public Boolean isBlocked(Authentication authentication){
        ///TODO: Get Current Logged in User's username
        ///TODO: Get Current Logged in User Object by username
        ///TODO: return isblocked to find the user is blocked or not
        return false;
    }

}
