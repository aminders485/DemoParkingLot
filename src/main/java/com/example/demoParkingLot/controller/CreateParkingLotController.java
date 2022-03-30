package com.example.demoParkingLot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoParkingLot.Service.ParkingLotService;
import com.example.demoParkingLot.Service.ParkingLotServiceImpl;
import com.example.demoParkingLot.Vehicle.VehicleType;

import POJO.VehicleInfo;

@RestController
@RequestMapping("/parking/v1")
public class CreateParkingLotController {

    @Autowired
    ParkingLotService parkingLotService;

    @RequestMapping(
            method = RequestMethod.POST,
            value= "/create/{vehicle_number}")
    public String generateSpace(@PathVariable(value = "vehicle_number") String vehicleNumber,
                              @RequestParam(value = "vehicle-type") String vehicleType){

        VehicleInfo vehicleInfo = new VehicleInfo(vehicleNumber, VehicleType.valueOf(vehicleType), true);
        return parkingLotService.parkVehicles(vehicleInfo);
    }
}
