package POJO;

import com.example.demoParkingLot.Vehicle.VehicleType;

public class VehicleCapacity {

    private int counter;

    private VehicleType vehicleType;

    public VehicleCapacity(int counter, VehicleType vehicleType) {
        this.counter = counter;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    }


