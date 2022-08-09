/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class CommentRatingResponse implements Serializable {
    @JsonProperty("location_id")
    Long locationId;
    @JsonProperty("user_id")
    Long userId;
    @JsonProperty("name_user")
    String nameUser;
    String comment;
    int rating;
    @JsonProperty("comment_time")
    LocalDateTime commentTime;
}
