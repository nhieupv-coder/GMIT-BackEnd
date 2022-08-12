/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.handle.impl;

import com.hackathon.gmit.data.UserRequest;
import com.hackathon.gmit.database.jpa.UserJPARepository;
import com.hackathon.gmit.domain.Role;
import com.hackathon.gmit.handle.CreateAccount;
import com.hackathon.gmit.model.Users;
import com.hackathon.gmit.service.UserAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class AccountImpl implements CreateAccount {
    @Autowired
    UserJPARepository userJPARepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UserAccountService userAccountService;

    @Override
    public void createAccount(UserRequest user) {
        String passwordEncode = encoder.encode(user.getPassword());
        Users userRegister = new Users();
        BeanUtils.copyProperties(user, userRegister);
        while (true) {
            String nameLowercase = userAccountService.covertToString(user.getFullName());
            String uName = userAccountService.generateUsername(nameLowercase);
            try {
                Optional<Users> userCheck = userJPARepository.findByUsernameAndDeleteAtNull(uName);
                if (userCheck.isEmpty()) {
                    userRegister.setUsername(uName);
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }

        userRegister.setPasswordEncode(passwordEncode);
        userRegister.setRole(Role.USER.asRole());
        userJPARepository.save(userRegister);
    }
}
