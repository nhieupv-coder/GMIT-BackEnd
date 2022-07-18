/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.exeption;

public class JWTInvalidException extends RuntimeException{
    public JWTInvalidException(String message) {
        super(message);
    }
}
