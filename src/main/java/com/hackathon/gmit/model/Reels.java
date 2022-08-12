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
public class Reels implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 200)
    String titleNews;
    @Column(length = 300)
    private String imageNews;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;
    private LocalDateTime postingTime;
    private LocalDateTime deleteAt;
}