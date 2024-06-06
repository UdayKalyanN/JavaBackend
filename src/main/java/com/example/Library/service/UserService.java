package com.example.Library.service;

import com.example.Library.domain.User;
import com.example.Library.exception.UserAlreadyExistedException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;



public interface UserService extends UserDetailsService {

    public void addUser(User user) throws UserAlreadyExistedException;
}
