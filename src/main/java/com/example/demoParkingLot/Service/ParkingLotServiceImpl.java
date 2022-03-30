package com.example.demoParkingLot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demoParkingLot.Database.ParkingLotDatabase;
import com.example.demoParkingLot.Service.VehicleService.VehicleService;
import com.example.demoParkingLot.Vehicle.VehicleType;

import POJO.VehicleCapacity;
import POJO.VehicleInfo;

@Service("publicservice")
public class ParkingLotServiceImpl implements ParkingLotService {

    @Autowired
    @Qualifier("fourWheelerVehicleImpl")
    VehicleService fourWheelerVehicleImpl;

    @Autowired
    @Qualifier("twoWheelerVehicleImpl")
    VehicleService twoWheelerVehicleImpl;

    @Autowired
    ParkingLotDatabase parkingLotDatabase;

    @Override
    public String parkVehicles(VehicleInfo vehicleInfo) {

        VehicleService vehicleService = getInstance(vehicleInfo.getVehicleType().toString());

        VehicleCapacity vehicleCapacity = parkingLotDatabase.getVehicleCapacity(vehicleInfo.getVehicleType().toString());

        Boolean isParkingSpaceAvailable = vehicleService.isParkingSpaceAvailable(vehicleCapacity);

        if (!isParkingSpaceAvailable) {
            return "No Parking Space Available";
        } else {
            parkingLotDatabase.createVehicleInformation(vehicleInfo);
            vehicleCapacity.setCounter(vehicleCapacity.getCounter() + 1);
            vehicleService.updateParkingSpace(vehicleCapacity);
        }
        return "Vehicle Parked Succesfully";
    }

    private VehicleService getInstance(String vehicleType){
        return vehicleType.equals(VehicleType.FOUR_WHEELER.toString()) ? fourWheelerVehicleImpl : twoWheelerVehicleImpl ;
    }
}
