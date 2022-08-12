/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.handle;

import com.hackathon.gmit.data.LocationPageResponse;
import com.hackathon.gmit.data.LocationCategoryPropertiesRequest;
import org.springframework.data.domain.Pageable;

public interface GetLocationsList {
    LocationPageResponse getLocationList(Pageable pageable, LocationCategoryPropertiesRequest location);
}
