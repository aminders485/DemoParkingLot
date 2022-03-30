package com.example.demoParkingLot.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoParkingLot.Service.ParkingLotService;
import com.example.demoParkingLot.Vehicle.VehicleType;

import POJO.VehicleInfo;

@RestController
@RequestMapping("/parking/v1")
public class CreatePrivateParkingLotController {

    @Autowired
    ParkingLotService parkingLotService;

    @RequestMapping(
            method = RequestMethod.POST,
            value= "/private/{vehicle_num}")
    public String generateSpace(@PathVariable(value = "vehicle_num") String vehicleNumber,
                              @RequestParam(value = "vehicle-type") String vehicleType,
                                @RequestParam(value="example") String example){

        String abc = example;
        VehicleInfo vehicleInfo = new VehicleInfo(vehicleNumber, VehicleType.valueOf(vehicleType), true);
        return parkingLotService.parkVehicles(vehicleInfo);
    }
}
