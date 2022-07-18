/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.config;

import com.hackathon.gmit.database.jpa.UserJPARepository;
import com.hackathon.gmit.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserJPARepository userJPARepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Users> userOptional = userJPARepository.findByEmailAndDeleteAtNull(email);
        if (userOptional.isPresent()) {
            Users user = userOptional.get();
            return User.withUsername(user.getUsername() )
                    .password(user.getPasswordEncode())
                    .roles(user.getRole()).build();
        }
        return null;
    }
}
