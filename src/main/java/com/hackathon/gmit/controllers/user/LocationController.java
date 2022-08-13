/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.controllers.user;

import com.hackathon.gmit.data.*;
import com.hackathon.gmit.handle.GetLocationDetail;
import com.hackathon.gmit.handle.GetLocationsList;
import com.hackathon.gmit.handle.SearchLocationByDistrictIdAndFieldsId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
@CrossOrigin("*")
public class LocationController {
    @Autowired
    GetLocationsList getLocationsList;

    @Autowired
    GetLocationDetail getLocationDetail;

    @Autowired
    SearchLocationByDistrictIdAndFieldsId searchLocationByDistrictIdAndFieldsId;

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

    @GetMapping("/search")
    public ResponseEntity<LocationSearchPageResponse> searchLocation(@PageableDefault(page = 0,size = 10) Pageable pageable,
                                                                     LocationSearchRequest request){
        LocationSearchPageResponse locationSearchResponse = searchLocationByDistrictIdAndFieldsId.search(request,pageable);
      return  ResponseEntity.ok(locationSearchResponse);
    }

}
