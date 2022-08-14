///*
// * Copyright Pham Van Nhieu and has some source refer on internet
// */
//
//package com.hackathon.gmit.handle.impl;
//
//import com.hackathon.gmit.data.VehicleResponse;
//import com.hackathon.gmit.database.jpa.VehicleJPARepository;
//import com.hackathon.gmit.handle.GetListVehicle;
//import com.hackathon.gmit.model.Vehicle;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class VehicleImpl implements GetListVehicle {
//
//    @Autowired
//    VehicleJPARepository vehicleJPARepository;
//
//    @Override
//    public List<VehicleResponse> getListVehicle() {
//        List<Vehicle> vehicles = vehicleJPARepository.findAll();
//        return vehicles.stream().map(i->VehicleResponse.builder()
//                .id(i.getId())
//                .title(i.getVehicleTitle()).build())
//                .collect(Collectors.toList());
//    }
//}
