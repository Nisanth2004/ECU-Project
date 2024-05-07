import React, { useState, useEffect } from 'react';
import axios from 'axios';

const Home = () => {
    const [gpsData, setGpsData] = useState(null);
    const [vehicleDetails, setVehicleDetails] = useState(null);
    const [map, setMap] = useState(null);

    useEffect(() => {
        axios.get('http://localhost:8080/hello/1')
            .then(response => {
                const { latitude, longitude, name, vehicleNumber } = response.data;
                setGpsData({ latitude, longitude });
                setVehicleDetails({ name, vehicleNumber });
    
                if (latitude && longitude) {
                    // Initialize the map
                    const googleMap = new window.google.maps.Map(document.getElementById('map'), {
                        center: { lat: latitude, lng: longitude },
                        zoom: 10 // Adjust the zoom level as needed
                    });
                    // Add marker for GPS location
                    const marker = new window.google.maps.Marker({
                        position: { lat: latitude, lng: longitude },
                        map: googleMap,
                        title: 'GPS Location'
                    });
                    // Set the map
                    setMap(googleMap);
                }
            })
            .catch(error => {
                console.error('Error fetching data: ', error);
                console.log("Nisanth");
            });
    }, []);
    

    return (
        <div>
            <h1>Notifications</h1>
            {gpsData && (
                <div>
                    <h2>GPS Location</h2>
                    <p>Latitude: {gpsData.latitude}</p>
                    <p>Longitude: {gpsData.longitude}</p>
                    <div id="map" style={{ width: '100%', height: '400px' }}></div>
                </div>
            )}
            {vehicleDetails && (
                <div>
                    <h2>Vehicle Details</h2>
                    <p>Name: {vehicleDetails.name}</p>
                    <p>Vehicle Number: {vehicleDetails.vehicleNumber}</p>
                </div>
            )}
        </div>
    );
};

export default Home;
