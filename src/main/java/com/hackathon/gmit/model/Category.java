/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150)
    private String title;
    @Column(length = 150)
    private LocalDateTime deleteAt;
    @OneToMany(mappedBy = "category")
    private List<CategoryLocation> categoryLocation;
}
