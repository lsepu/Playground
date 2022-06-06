import { initializeApp } from "firebase/app";
import { getAuth, GoogleAuthProvider, signInWithPopup } from "firebase/auth";

const firebaseConfig = {
  apiKey: "AIzaSyCQqxCInxPRI4gxZ2T5lwdX1ApC6C6p290",
  authDomain: "fir-auth-tutorial-ee902.firebaseapp.com",
  projectId: "fir-auth-tutorial-ee902",
  storageBucket: "fir-auth-tutorial-ee902.appspot.com",
  messagingSenderId: "994890660146",
  appId: "1:994890660146:web:620c36e0aa25dac83c7f2b"

};


const app = initializeApp(firebaseConfig);

export const auth = getAuth(app);

const provider = new GoogleAuthProvider();

export const signInWithGoogle = () => signInWithPopup(auth, provider);

/*
export const signInWithGoogle = () => {
    signInWithPopup(auth, provider).then((result) => {
        const name = result.user.displayName;
        const email = result.user.email;
        const profilePic = result.user.photoURL;
    }).catch((error) => {
        console.log(error);
    })
} */

