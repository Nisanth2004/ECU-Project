package com.nisanth.ecubackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockBlynkController
{
    // for testing purposes
    @GetMapping("/blynk-data-mock")
    public String getMockBlynkData(@RequestParam("virtualPin") int virtualPin) {
        // Simulate Blynk data based on the virtual pin
        if (virtualPin == 1) {
            return "{\"gpsData\":{\"latitude\":40.7128,\"longitude\":-74.0060},\"vehicleDetails\":{\"name\":\"Test Vehicle\",\"vehicleNumber\":\"1234\"}}";
        } else {
            return "Invalid virtual pin";
        }
    }
}
