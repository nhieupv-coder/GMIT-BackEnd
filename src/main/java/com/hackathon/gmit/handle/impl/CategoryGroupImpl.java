/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.handle.impl;

import com.hackathon.gmit.data.CategoryGroupResponse;
import com.hackathon.gmit.data.CategoryResponse;
import com.hackathon.gmit.database.jpa.CategoryGroupJPARepository;
import com.hackathon.gmit.handle.GetListCategoryAndGroup;
import com.hackathon.gmit.model.CategoryGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryGroupImpl implements GetListCategoryAndGroup {

    @Autowired
    CategoryGroupJPARepository categoryGroupJPARepository;

    @Override
    public List<CategoryGroupResponse> getListCategoryGroup() {
        List<CategoryGroup> categoryGroupList = categoryGroupJPARepository.findAll();
        List<CategoryGroupResponse> listResult = categoryGroupList
                .stream().map(i -> {
                            List<CategoryResponse> listCategory = i.getCategoryList().stream()
                                    .map(c -> CategoryResponse.builder()
                                            .categoryId(c.getId())
                                            .name(c.getTitle())
                                            .build()).collect(Collectors.toList());
                            return CategoryGroupResponse.builder()
                                    .groupId(i.getId())
                                    .categoryGroupName(i.getCategoryGroupName())
                                    .category(listCategory)
                                    .build();
                        }
                ).collect(Collectors.toList());
        return listResult;
    }
}
