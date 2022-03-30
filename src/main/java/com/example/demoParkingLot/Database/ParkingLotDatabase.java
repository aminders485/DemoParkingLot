package com.example.demoParkingLot.Database;

import POJO.VehicleCapacity;
import POJO.VehicleInfo;

public interface ParkingLotDatabase {
    VehicleCapacity getVehicleCapacity(String vehicleType);

    void createVehicleInformation(VehicleInfo vehicleInfo);

    void updateVehicleCapacity(VehicleCapacity vehicleCapacity);
}
