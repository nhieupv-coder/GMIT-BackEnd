/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.handle.impl;

import com.hackathon.gmit.data.*;
import com.hackathon.gmit.database.jpa.CategoryLocationJPARepository;
import com.hackathon.gmit.database.jpa.LocationJPARepository;
import com.hackathon.gmit.handle.GetLocationDetail;
import com.hackathon.gmit.handle.GetLocationsList;
import com.hackathon.gmit.model.Category;
import com.hackathon.gmit.model.CategoryLocation;
import com.hackathon.gmit.model.Location;
import com.hackathon.gmit.service.CalculatorDistanceService;
import com.hackathon.gmit.service.PathsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LocationImpl implements GetLocationsList,
        GetLocationDetail {
    @Autowired
    LocationJPARepository locationJPARepository;

    @Autowired
    CalculatorDistanceService calculatorDistanceService;

    @Autowired
    CategoryLocationJPARepository categoryLocationJPARepository;

    @Autowired
    PathsService pathsService;

    @Override
    public LocationPageResponse getLocationList(Pageable pageable, LocationCategoryPropertiesRequest location) {
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
                    .distance(null).imageCard(pathsService.toFullPath(i.getImageCard()))
                    .imageDescription(pathsService.toFullPath(i.getImageDescription()))
                    .imageAd(pathsService.toFullPath(i.getImageAd()))
                    .longitude(i.getLongitude())
                    .latitude(i.getLatitude())
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
                    .imageCard(pathsService.toFullPath(i.getImageCard()))
                    .imageDescription(pathsService.toFullPath(i.getImageDescription()))
                    .imageAd(pathsService.toFullPath(i.getImageAd()))
                    .category(getListCategory(i.getCategoryLocation()))
                    .longitude(i.getLongitude())
                    .latitude(i.getLatitude())
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

    @Override
    public LocationResponse getLocationDetail(Long id, LocationPropertiesRequest request) {

        Optional<Location> location = locationJPARepository.findById(id);
        if (location.isPresent()) {
            Location l = location.get();
            LocationResponse response = LocationResponse.builder()
                    .id(l.getId())
                    .latitude(l.getLatitude())
                    .longitude(l.getLongitude())
                    .imageCard(l.getImageCard())
                    .title(l.getTitle())
                    .address(l.getAddress())
                    .category(getListCategory(l.getCategoryLocation()))
                    .distance((Objects.isNull(request.getLatitude()) || Objects.isNull(request.getLongitude())) ? null : calculatorDistanceService.calculatorDistance(request.getLatitude(),
                            l.getLongitude(), request.getLongitude(), l.getLongitude()))
                    .description(l.getDescription())
                    .imageAd(l.getImageAd())
                    .imageDescription(l.getImageDescription())
                    .build();
            return response;
        }
        return null;
    }
}
