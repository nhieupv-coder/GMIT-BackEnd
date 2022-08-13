/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class LocationSearchResponse {
    Long id;
    String title;
    @JsonProperty("number_rating")
    Double numberRating;
    @JsonProperty("image_card")
    String imageCard;
    Double distance;
}
