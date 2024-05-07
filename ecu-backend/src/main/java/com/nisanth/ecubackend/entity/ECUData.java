package com.nisanth.ecubackend.entity;

public class ECUData {
    private GPSTrackingEntity gpsData;
    private VehicleDetailsEntity vehicleDetails;

    public GPSTrackingEntity getGpsData() {
        return gpsData;
    }

    public void setGpsData(GPSTrackingEntity gpsData) {
        this.gpsData = gpsData;
    }

    public VehicleDetailsEntity getVehicleDetails() {
        return vehicleDetails;
    }

    public void setVehicleDetails(VehicleDetailsEntity vehicleDetails) {
        this.vehicleDetails = vehicleDetails;
    }
}

