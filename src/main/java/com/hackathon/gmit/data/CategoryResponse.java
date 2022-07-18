/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class CategoryResponse implements Serializable {
    @JsonProperty("category_id")
    Long categoryId;
    String name;
}
