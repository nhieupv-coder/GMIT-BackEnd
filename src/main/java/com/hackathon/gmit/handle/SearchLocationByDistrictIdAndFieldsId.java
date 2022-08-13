/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.handle;

import com.hackathon.gmit.data.LocationSearchPageResponse;
import com.hackathon.gmit.data.LocationSearchRequest;
import org.springframework.data.domain.Pageable;

public interface SearchLocationByDistrictIdAndFieldsId {
    LocationSearchPageResponse search(LocationSearchRequest request, Pageable pageable);
}
