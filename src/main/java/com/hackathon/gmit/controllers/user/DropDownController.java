/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.controllers.user;

import com.hackathon.gmit.data.CategoryDistrictsResponse;
import com.hackathon.gmit.handle.GetListDistrict;
import com.hackathon.gmit.handle.GetListFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drop-down")
@CrossOrigin("*")
public class DropDownController {
    @Autowired
    GetListFields getListFields;

    @Autowired
    GetListDistrict getListDistrict;

    @GetMapping("/routes")
    ResponseEntity<CategoryDistrictsResponse> getDropDownRoutes(){
        CategoryDistrictsResponse categoryDistrictsResponse = CategoryDistrictsResponse
                .builder().districts(getListDistrict.getListDistrict())
                .fields(getListFields.getListFields()).build();
        return ResponseEntity.ok(categoryDistrictsResponse);
    }
}
