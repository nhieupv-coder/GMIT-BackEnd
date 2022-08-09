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
@IdClass(RatingId.class)
public class Rating implements Serializable {
    @Id
    @ManyToOne (optional = false)
    @JoinColumn(name = "location_id")
    private Location location;
    private int rate;
    @Column(length = 200)
    private String comment;
    @Id
    @ManyToOne (optional = false)
    @JoinColumn(name = "user_id")
    private Users user;
    LocalDateTime commentTime;
    private LocalDateTime deleteAt;

}
