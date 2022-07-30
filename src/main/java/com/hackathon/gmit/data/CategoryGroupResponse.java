/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
public class CategoryGroupResponse implements Serializable {
    @JsonProperty("group_id")
    Long groupId;
    @JsonProperty("category_group_name")
    String categoryGroupName;
    List<CategoryResponse> category;
}
