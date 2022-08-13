/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.handle.impl;

import com.hackathon.gmit.data.DistrictResponse;
import com.hackathon.gmit.database.jpa.DistrictsJPARepository;
import com.hackathon.gmit.handle.GetListDistrict;
import com.hackathon.gmit.model.Districts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DistrictsImpl implements GetListDistrict {
    @Autowired
    DistrictsJPARepository districtsJPARepository;

    @Override
    public List<DistrictResponse> getListDistrict() {
        List<Districts> listDistrict = districtsJPARepository.findAll();
        List<DistrictResponse> listResponse = listDistrict.stream()
                .map(i -> DistrictResponse
                        .builder()
                        .districtName(i.getTitle())
                        .id(i.getId()).build())
                .collect(Collectors.toList());
        return listResponse;
    }
}
