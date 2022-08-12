/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class FeaturedNews implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    String titleNews;
    @Column(length = 3000)
    String description;
    @Column(length = 300)
    private String imageCardNews;
    @Column(length = 300)
    private String imageLarge;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;
    private int priority;
    private LocalDateTime postingTime;
    private LocalDateTime deleteAt;
}