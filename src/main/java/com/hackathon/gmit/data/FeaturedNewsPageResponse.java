/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class FeaturedNewsPageResponse {
    List<FeaturedNewsResponse> contents;
    @JsonProperty("total_page")
    int totalPage;
    @JsonProperty("total_element")
    long totalElement;
    @JsonProperty("current_page")
    int currentPage;
    int size;
}
