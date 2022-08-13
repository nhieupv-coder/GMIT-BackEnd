/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationSearchRequest {
    @JsonProperty("district_id")
    Long districtId;
    @JsonProperty("field_id")
    Long fieldId;
    Double longitude;
    Double latitude;
}
