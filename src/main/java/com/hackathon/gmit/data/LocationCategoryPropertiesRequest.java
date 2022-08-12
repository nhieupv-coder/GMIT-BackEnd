/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.data;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocationCategoryPropertiesRequest {
    Double longitude;
    Double latitude;
    Long CategoryId;
}
