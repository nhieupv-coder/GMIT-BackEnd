/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.handle.impl;

import com.hackathon.gmit.data.RoutesRequest;
import com.hackathon.gmit.database.jpa.LocationJPARepository;
import com.hackathon.gmit.database.jpa.RoutesJPARepository;
import com.hackathon.gmit.database.jpa.UserJPARepository;
import com.hackathon.gmit.database.jpa.VehicleJPARepository;
import com.hackathon.gmit.handle.InsertRoutes;
import com.hackathon.gmit.model.Routes;
import com.hackathon.gmit.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoutesImpl implements InsertRoutes {
    @Autowired
    RoutesJPARepository jpaRepository;

    @Autowired
    UserJPARepository userJPARepository;

    @Autowired
    LocationJPARepository locationJPARepository;

    @Autowired
    VehicleJPARepository vehicleJPARepository;

    @Override
    public void insert(List<RoutesRequest> params) {
        for (RoutesRequest r: params) {
            Vehicle vehicle = vehicleJPARepository.getReferenceById(r.getVehicle());
            Routes route = new Routes();
            route.setRoutesDate(r.getRoutesDate());
            route.setStartTime(r.getStartTime());
            route.setEndTime(r.getEndTime());
            route.setLocation(locationJPARepository.getReferenceById(r.getLocationId()));
            route.setUser(userJPARepository.getReferenceById(r.getLocationId()));
            route.setVehicle(vehicle);
            jpaRepository.save(route);
        }
    }
}
