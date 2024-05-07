package com.nisanth.ecubackend.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class BlynkDataService
{
    //@Value("${blynk.token}")
    private String blynkToken="";

    public String getBlynkData(int virtualPin) {
        try {
            // Create the URL for the GET request
            String url = "http://blynk-cloud.com/" + blynkToken + "/get/V" + virtualPin;

            // Send the GET request
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");

            // Read the response
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the JSON response
            JSONObject jsonResponse = new JSONObject(response.toString());

            // Return the JSON response as a string
            return jsonResponse.toString();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            return "Error fetching data from Blynk";
        }
    }
}
