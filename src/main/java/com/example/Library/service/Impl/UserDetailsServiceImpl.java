package com.example.Library.service.Impl;

import com.example.Library.Repository.UserRepositroy;
import com.example.Library.domain.User;
import com.example.Library.exception.UserAlreadyExistedException;
import com.example.Library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserService {

    //Which is used to fetch the user details from the database. if not it uses the cache user details

    @Autowired
    UserRepositroy userRepositroy;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepositroy.findByUsername(username);

        return user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    @Override
    public void addUser(User user) throws UserAlreadyExistedException {
        Optional<User> optionalUser=userRepositroy.findByUsername(user.getUsername());
        if(optionalUser.isEmpty()){
            user.setAuthority("USER");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepositroy.save(user);
        }else {
            throw new UserAlreadyExistedException("User already exists");
        }

    }

}
