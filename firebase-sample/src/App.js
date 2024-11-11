// src/App.js
import React, { useEffect, useState } from "react";
import { collection, getDocs } from "firebase/firestore";
import { db } from "./firebase"; // Import the Firestore database instance

function App() {
  const [data, setData] = useState([]);

  // Function to fetch data from Firestore
  const fetchData = async () => {
    try {
      const querySnapshot = await getDocs(collection(db, "first collection"));
      const fetchedData = querySnapshot.docs.map((doc) => ({
        id: doc.id,
        ...doc.data(),
      }));
      setData(fetchedData);
    } catch (error) {
      console.error("Error fetching data: ", error);
    }
  };

  // Fetch data when the component mounts
  useEffect(() => {
    fetchData();
  }, []);

  return (
    <div>
      <h1>Data from Firebase</h1>
      {data.map((item) => (
        <div key={item.id}>
          <h3>Name: {item.name}</h3>
          <p>Age: {item.age}</p>
          {/* Add other fields here as needed */}
        </div>
      ))}
    </div>
  );
}

export default App;
