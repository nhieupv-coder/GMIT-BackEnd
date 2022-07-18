/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String title;
    @Column(length = 300)
    private String address;
    private double longitude;
    private double latitude;
    @Column(length = 3000)
    private String description;
    @Column(length = 100)
    private String imageCard;
    @Column(length = 100)
    private String imageDescription;
    @Column(length = 100)
    private String imageAd;
    private LocalDateTime deleteAt;
    @OneToMany(mappedBy = "location")
    private List<CategoryLocation> categoryLocation;
}
