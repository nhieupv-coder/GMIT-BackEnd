/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.data;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CategoryDistrictsResponse {
    List<FieldsResponse> fields;
    List<DistrictResponse> districts;
}
