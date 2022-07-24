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
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location locationId;
    private int rate;
    @Column(length = 200)
    private String comment;
    @Id
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users userId;
    private LocalDateTime deleteAt;

}
