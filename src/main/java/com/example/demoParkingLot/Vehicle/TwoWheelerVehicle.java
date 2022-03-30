package com.example.demoParkingLot.Vehicle;

import org.springframework.stereotype.Component;

@Component("twowheeler")
public class TwoWheelerVehicle implements Vehicle{

    private  String vehicleNumber;
    private String vehicleType;


    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        vehicleType = vehicleType;
    }

    @Override
    public void setVehicleInfo(String vehicleInfo) {

    }
}
