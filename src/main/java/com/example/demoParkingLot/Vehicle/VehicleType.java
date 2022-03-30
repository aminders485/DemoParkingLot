package com.example.demoParkingLot.Vehicle;

public enum VehicleType {
    TWO_WHEELER("twoWheeler"),
    FOUR_WHEELER("fourWheeler");

    private String type;

    VehicleType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
