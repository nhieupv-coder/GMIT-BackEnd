/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ApiError {

    private HttpStatus status;
    private int errorCount;
    private Error error;
}
