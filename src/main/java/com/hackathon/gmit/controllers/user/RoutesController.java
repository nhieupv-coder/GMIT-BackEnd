/*
 * Copyright Pham Van Nhieu and has some source refer on internet
 */

package com.hackathon.gmit.controllers.user;

import com.hackathon.gmit.data.RoutesRequest;
import com.hackathon.gmit.data.VehicleResponse;
import com.hackathon.gmit.handle.GetListVehicle;
import com.hackathon.gmit.handle.InsertRoutes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/routes-location")
@Validated
@CrossOrigin("*")
public class RoutesController {
    @Autowired
    InsertRoutes insertRoutes;

    @Autowired
    GetListVehicle getListVehicle;


    @PostMapping()
    public ResponseEntity<Void> insertRoutes(@RequestBody List<@Valid RoutesRequest> request) {
        insertRoutes.insert(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/vehicle")
    public ResponseEntity<List<VehicleResponse>> getListVehicle() {
        List<VehicleResponse> vehicleResponses = getListVehicle.getListVehicle();
        return ResponseEntity.ok(vehicleResponses);
    }
}
