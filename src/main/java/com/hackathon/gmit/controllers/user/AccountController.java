/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.controllers.user;

import com.hackathon.gmit.data.UserRequest;
import com.hackathon.gmit.handle.CreateAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/user")
public class AccountController {
    @Autowired
    CreateAccount createAccount;

    @PostMapping("/account")
    public ResponseEntity<Void> createAccount(@Validated @RequestBody UserRequest user) {
        createAccount.createAccount(user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @GetMapping("check-login")
    public ResponseEntity<String>  checkLogin(){
        return ResponseEntity.ok("Login check success");
    }

    @PostMapping("/token")
    public ResponseEntity<Map<String, String> > getUserDetailsAfterLogin(Principal user, HttpServletResponse res) {
        Map<String, String> response = new HashMap<>();
        response.put("token", res.getHeader("token"));
        response.put("expiration", res.getHeader("expiration"));
        return ResponseEntity.ok(response);
    }
}
