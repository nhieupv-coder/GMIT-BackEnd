/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.service;

import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.Random;
import java.util.regex.Pattern;

@Service
public class UserAccountService {
    public String generateUsername(String fullName) {
        String[] arrayFullname = fullName.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        Random generator = new Random();
        for (int i = 0; i < arrayFullname.length; i++) {
            if (i == (arrayFullname.length - 1)) {
                stringBuffer.append(arrayFullname[i]);
                int number1 = (int) Math.floor(Math.random() * (100 - 1 + 1) + 1);
                stringBuffer.append(number1);
            } else {
                stringBuffer.append(arrayFullname[i].charAt(0));
            }
        }
        return stringBuffer.toString();
    }
    public String covertToString(String value) {
        try {
            String temp = Normalizer.normalize(value, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            return pattern.matcher(temp).replaceAll("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
