package com.nisanth.ecubackend.controller;

import com.nisanth.ecubackend.entity.GPSTrackingEntity;
import com.nisanth.ecubackend.entity.VehicleDetailsEntity;
import com.nisanth.ecubackend.repository.GPSTrackingRepository;
import com.nisanth.ecubackend.repository.VehicleDetailsRepository;
import com.nisanth.ecubackend.service.BlynkDataService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BlynkDataController {

    @Autowired
    private BlynkDataService blynkDataService;

    @Autowired
    private GPSTrackingRepository gpsTrackingRepository;

    @Autowired
    private VehicleDetailsRepository vehicleDetailsRepository;

    @Scheduled(fixedRate = 5000) // Run every 5 seconds (adjust as needed)
    @GetMapping("/hello/{virtualPin}")
    public ResponseEntity<Map<String, Object>> fetchBlynkDataPeriodically(@PathVariable int virtualPin)
    {
        System.out.println("Fetching Blynk data for virtual pin: " + virtualPin);
        String blynkData = blynkDataService.getBlynkData(virtualPin);

        // Parse the Blynk data and save to database
        try {
            JSONObject jsonData = new JSONObject(blynkData);
            JSONObject gpsData = jsonData.getJSONObject("gpsData");
            JSONObject vehicleDetails = jsonData.getJSONObject("vehicleDetails");

            // Save GPS data to database
            GPSTrackingEntity gpsEntity = new GPSTrackingEntity();
            gpsEntity.setLatitude(gpsData.getDouble("latitude"));
            gpsEntity.setLongitude(gpsData.getDouble("longitude"));
            gpsTrackingRepository.save(gpsEntity);

            // Save vehicle details to database
            VehicleDetailsEntity vehicleEntity = new VehicleDetailsEntity();
            vehicleEntity.setName(vehicleDetails.getString("name"));
            vehicleEntity.setVehicleNumber(vehicleDetails.getString("vehicleNumber"));
            vehicleDetailsRepository.save(vehicleEntity);

            // Create a response JSON object
            Map<String, Object> responseData = new HashMap<>();
            responseData.put("latitude", gpsData.getDouble("latitude"));
            responseData.put("longitude", gpsData.getDouble("longitude"));
            responseData.put("name", vehicleDetails.getString("name"));
            responseData.put("vehicleNumber", vehicleDetails.getString("vehicleNumber"));

            return ResponseEntity.ok(responseData);
        } catch (JSONException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

