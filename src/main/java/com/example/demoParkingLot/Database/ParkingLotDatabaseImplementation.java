package com.example.demoParkingLot.Database;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demoParkingLot.Vehicle.VehicleType;

import POJO.VehicleCapacity;
import POJO.VehicleInfo;

@Repository
public class ParkingLotDatabaseImplementation implements ParkingLotDatabase{

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String vehicleCapacity = "Select * from vehicle_capacity where vehicletype = ?";
    private static final String countVehicleInfo = "select count(*) from vehicle_information WHERE vehiclenumber = ?";
    private static final String updateVehicleInfo = "update vehicle_information set active = ? WHERE vehiclenumber = ?";
    private static final String createVehicleInfo = "insert into vehicle_information values(?, ?, ?, ?, ?)";
    private static final String updateVehicleCapacity = "update vehicle_capacity set noofvehicles = ? where vehicletype = ?";

    @Override
    public VehicleCapacity getVehicleCapacity(String vehicleType) {

        return jdbcTemplate.queryForObject(vehicleCapacity,
                (rs, rowNum) -> new VehicleCapacity(rs.getInt("noofvehicles"), VehicleType.valueOf(rs.getString("vehicletype"))),
                new Object[]{vehicleType});
    }

    @Override
    public void createVehicleInformation(VehicleInfo vehicleInfo) {

        boolean exists = false;
        int count = jdbcTemplate.queryForObject(countVehicleInfo, Integer.class, new Object[]{vehicleInfo.getVehicleNumber()});
        exists = count > 0;
        if (exists) {
            this.jdbcTemplate.update(updateVehicleInfo,
                    vehicleInfo.getActive(), vehicleInfo.getVehicleNumber());
        } else {
            this.jdbcTemplate.update(createVehicleInfo,
                    vehicleInfo.getVehicleNumber(), vehicleInfo.getVehicleType().toString(), vehicleInfo.getActive(), LocalDateTime.now(), null);
        }
    }

    @Override
    public void updateVehicleCapacity(VehicleCapacity vehicleCapacity) {
        this.jdbcTemplate.update(updateVehicleCapacity,
                vehicleCapacity.getCounter(), vehicleCapacity.getVehicleType().toString());
    }
}
