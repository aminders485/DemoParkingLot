package POJO;

import java.time.LocalDateTime;

import com.example.demoParkingLot.Vehicle.VehicleType;

public class VehicleInfo {
    private String vehicleNumber;
    private VehicleType vehicleType;
    private Boolean active;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public VehicleInfo(String vehicleNumber, VehicleType vehicleType, Boolean active) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.active = active;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public Boolean getActive() {
        return active;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}
