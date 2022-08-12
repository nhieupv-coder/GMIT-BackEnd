/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class NewsResponse {
    Long id;
    @JsonProperty("user_id")
    Long userId;
    String title;
    @JsonProperty("avatar_user")
    String avatarUser;
    LocalDateTime postAt;
    String imageNews;
}
