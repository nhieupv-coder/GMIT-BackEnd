/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.data;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FeaturedNewsResponse {
    Long id;
    String image;
    String title;
    String rangeTimePost;
}
