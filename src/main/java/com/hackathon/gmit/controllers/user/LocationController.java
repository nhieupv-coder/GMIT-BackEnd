/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.controllers.user;

import com.hackathon.gmit.data.LocationCategoryPropertiesRequest;
import com.hackathon.gmit.data.LocationPageResponse;
import com.hackathon.gmit.data.LocationPropertiesRequest;
import com.hackathon.gmit.data.LocationResponse;
import com.hackathon.gmit.handle.GetLocationDetail;
import com.hackathon.gmit.handle.GetLocationsList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    GetLocationsList getLocationsList;

    @Autowired
    GetLocationDetail getLocationDetail;

    @GetMapping
    public ResponseEntity<LocationPageResponse> getListLocation(@PageableDefault(page = 0, size = 10) Pageable pageable,
                                                                LocationCategoryPropertiesRequest request) {
        LocationPageResponse locationResponse = getLocationsList.getLocationList(pageable, request);
        return ResponseEntity.ok(locationResponse);
    }

    @GetMapping("{id}")
    public ResponseEntity<LocationResponse> getLocationDetail(@PathVariable Long id,
                                                              LocationPropertiesRequest
                                                                      locationPropertiesRequest) {
        LocationResponse response = getLocationDetail.getLocationDetail(id, locationPropertiesRequest);
        return ResponseEntity.ok(response);
    }
}
