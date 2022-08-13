/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.controllers.user;

import com.hackathon.gmit.data.CategoryGroupResponse;
import com.hackathon.gmit.handle.GetListCategoryAndGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    GetListCategoryAndGroup getListCategoryAndGroup;

    @GetMapping("/group")
    public ResponseEntity<List<CategoryGroupResponse>> getListCategoryGroup() {
        List<CategoryGroupResponse> listResponse = getListCategoryAndGroup.getListCategoryGroup();
        return ResponseEntity.ok(listResponse);
    }

}
