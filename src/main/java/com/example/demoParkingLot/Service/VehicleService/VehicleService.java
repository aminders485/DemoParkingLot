package com.example.demoParkingLot.Service.VehicleService;

import POJO.VehicleCapacity;

public interface VehicleService {

    Boolean isParkingSpaceAvailable(VehicleCapacity vehicleCapacity);

    void updateParkingSpace(VehicleCapacity vehicleCapacity);
}
