
import { initializeApp } from "firebase/app";
import { getFirestore } from "@firebase/firestore";

const firebaseConfig = {
    apiKey: "AIzaSyBHL5ap2YfYTOs7aVn3tckxD8d6v92aa7w",
    authDomain: "fir-tutorial-cb66d.firebaseapp.com",
    projectId: "fir-tutorial-cb66d",
    storageBucket: "fir-tutorial-cb66d.appspot.com",
    messagingSenderId: "1004470705533",
    appId: "1:1004470705533:web:01fde7200740d223868014"
  
  };
  
  const app = initializeApp(firebaseConfig);

  export const db = getFirestore();