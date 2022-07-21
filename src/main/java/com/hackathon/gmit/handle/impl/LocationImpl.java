/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.handle.impl;

import com.hackathon.gmit.data.CategoryResponse;
import com.hackathon.gmit.data.LocationPageResponse;
import com.hackathon.gmit.data.LocationResponse;
import com.hackathon.gmit.data.LocationPropertiesRequest;
import com.hackathon.gmit.database.jpa.CategoryLocationJPARepository;
import com.hackathon.gmit.database.jpa.LocationJPARepository;
import com.hackathon.gmit.handle.GetLocationsList;
import com.hackathon.gmit.model.Category;
import com.hackathon.gmit.model.CategoryLocation;
import com.hackathon.gmit.model.Location;
import com.hackathon.gmit.service.CalculatorDistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class LocationImpl implements GetLocationsList {
    @Autowired
    LocationJPARepository locationJPARepository;

    @Autowired
    CalculatorDistanceService calculatorDistanceService;

    @Autowired
    CategoryLocationJPARepository categoryLocationJPARepository;

    @Override
    public LocationPageResponse getLocationList(Pageable pageable, LocationPropertiesRequest location) {
        Page<Location> locationPageable;
        if (Objects.isNull(location.getCategoryId())) {
            locationPageable = locationJPARepository.findAllByDeleteAtNull(pageable);
        } else {
            List<CategoryLocation> listCategoryLocation =
                    categoryLocationJPARepository.getAllByCategoryId(location.getCategoryId());
            locationPageable = locationJPARepository
                    .findAllByDeleteAtNullAndCategoryLocationIn(listCategoryLocation, pageable);
        }

        List<Location> locationList = locationPageable.getContent();
        List<LocationResponse> list;
        if (Objects.isNull(location.getLatitude()) || Objects.isNull(location.getLongitude())) {
            list = locationList.stream().map(i -> LocationResponse.builder()
                    .id(i.getId())
                    .title(i.getTitle())
                    .address(i.getAddress())
                    .description(i.getDescription())
                    .distance(null).imageCard(i.getImageCard())
                    .imageDescription(i.getImageDescription())
                    .imageAd(i.getImageAd())
                    .category(getListCategory(i.getCategoryLocation()))
                    .build()).collect(Collectors.toList());
        } else {
            list = locationList.stream().map(i -> LocationResponse.builder()
                    .id(i.getId())
                    .title(i.getTitle())
                    .address(i.getAddress())
                    .description(i.getDescription())
                    .distance(calculatorDistanceService.calculatorDistance(location.getLatitude(),
                            i.getLatitude(), location.getLongitude(), i.getLongitude()))
                    .imageCard(i.getImageCard())
                    .imageDescription(i.getImageDescription())
                    .imageAd(i.getImageAd())
                    .category(getListCategory(i.getCategoryLocation()))
                    .build()).sorted(Comparator
                    .comparing(LocationResponse::getDistance)).collect(Collectors.toList());
        }
        return LocationPageResponse.builder().content(list).currentPage(locationPageable.getNumber())
                .size(locationPageable.getSize()).totalPage(locationPageable.getTotalPages()).totalElement(locationPageable.getTotalElements()).build();
    }

    private List<CategoryResponse> getListCategory(List<CategoryLocation> list) {
        List<Category> listCategory = list.stream()
                .map(CategoryLocation::getCategory).collect(Collectors.toList());
        return listCategory.stream().map(t -> CategoryResponse.builder().categoryId(t.getId())
                .name(t.getTitle()).build()).collect(Collectors.toList());
    }
}
