import React from 'react';
import { GoogleMap, LoadScript } from '@react-google-maps/api';

const Map = () => {
  const mapContainerStyle = {
    width: '100%',
    height: '400px'
  };

  const center = {
    lat: 40.7128,
    lng: -74.0060
  };

  return (
    <LoadScript
      googleMapsApiKey="721944720909-kf7dj5pmj5acvlh8chbldakfajo4q6n5"
    >
      <GoogleMap
        mapContainerStyle={mapContainerStyle}
        center={center}
        zoom={10}
      >
      </GoogleMap>
    </LoadScript>
  );
};

export default Map;
