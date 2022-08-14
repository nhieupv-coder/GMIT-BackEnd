/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Builder
@Getter
public class LocationResponse implements Serializable {
    Long id;
    String title;
    String address;
    @JsonProperty("open_time")
    LocalTime openTime;
    @JsonProperty("close_time")
    LocalTime closeTime;
    String description;
    @JsonProperty("image_card")
    String imageCard;
    @JsonProperty("image_description")
    String imageDescription;
    @JsonProperty("image_ad")
    String imageAd;
    Double longitude;
    Double latitude;
    List<CategoryResponse> category;
    Double distance;
}
