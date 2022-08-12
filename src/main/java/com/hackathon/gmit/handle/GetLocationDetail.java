/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.handle;

import com.hackathon.gmit.data.LocationPropertiesRequest;
import com.hackathon.gmit.data.LocationResponse;

public interface GetLocationDetail {
    LocationResponse getLocationDetail(Long id, LocationPropertiesRequest locationPropertiesRequest);
}
