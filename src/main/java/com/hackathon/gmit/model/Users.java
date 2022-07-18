/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, length = 50)
    private String username;
    @Column(length = 500)
    private String passwordEncode;
    @Column(length = 200)
    private String fullName;
    @Column(length = 50)
    private String email;
    @Column(length = 10)
    private String role;
    @Column(length = 300)
    private String address;
    @Column(length = 100)
    private String avatar;
    private LocalDateTime deleteAt;
}
