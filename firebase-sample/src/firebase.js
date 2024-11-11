// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
import { getFirestore } from "firebase/firestore";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyBM4FZD6QcdDaUndGPkUU0AIJSV5NNq9bc",
  authDomain: "sample-6c88d.firebaseapp.com",
  projectId: "sample-6c88d",
  storageBucket: "sample-6c88d.firebasestorage.app",
  messagingSenderId: "849231396885",
  appId: "1:849231396885:web:ef760be994aff9b1274e1c",
  measurementId: "G-7DGNSBHRS6"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
const analytics = getAnalytics(app);
const db = getFirestore(app);
export { db };
