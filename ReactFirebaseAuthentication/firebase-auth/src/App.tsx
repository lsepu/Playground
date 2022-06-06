import {
  createUserWithEmailAndPassword,
  onAuthStateChanged,
  signInWithEmailAndPassword,
  signOut,
} from "firebase/auth";
import { useEffect, useState } from "react";
import "./App.css";
import { auth, signInWithGoogle } from "./firebase-config";

interface ICredentials {
  email: string;
  password: string;
}

function App() {
  const [user, setUser] = useState({});

  //check user login states, if it logins with other account or signs out
  useEffect(() => {
    onAuthStateChanged(auth, (currentUser: any) => {
      setUser(currentUser);
    });
  }, []);

  const [registerInput, setRegisterInput] = useState<ICredentials>({
    email: "",
    password: "",
  });

  const [loginInput, setLoginInput] = useState<ICredentials>({
    email: "",
    password: "",
  });

  const register = async () => {
    try {
      const user = await createUserWithEmailAndPassword(
        auth,
        registerInput.email.toString(),
        registerInput.password.toString()
      );
    } catch (error) {
      let message;
      if (error instanceof Error) message = error.message;
      reportError({ message });
    }
  };

  const login = async () => {
    try {
      const user = await signInWithEmailAndPassword(
        auth,
        loginInput.email.toString(),
        loginInput.password.toString()
      );
    } catch (error) {
      let message;
      if (error instanceof Error) message = error.message;
      reportError({ message });
    }
  };

  const loginWithGoogle = async () => {
    try {
      const googleUser = await signInWithGoogle();
      console.log(googleUser.user.email);

    } catch (error) {
      let message;
      if (error instanceof Error) message = error.message;
      reportError({ message });
    }
  };

  const logout = async () => {
    await signOut(auth);
  };

  return (
    <div className="App">
      <div>
        <h3>Register User </h3>
        <input
          placeholder="Email..."
          name="email"
          value={registerInput.email}
          onChange={(e) =>
            setRegisterInput({
              ...registerInput,
              [e.target.name]: [e.target.value],
            })
          }
        />
        <input
          placeholder="Password..."
          name="password"
          value={registerInput.password}
          onChange={(e) =>
            setRegisterInput({
              ...registerInput,
              [e.target.name]: [e.target.value],
            })
          }
        />

        <button onClick={register}>Create User</button>
      </div>

      <div>
        <h3>Login </h3>
        <input
          placeholder="Email..."
          name="email"
          value={loginInput.email}
          onChange={(e) =>
            setLoginInput({
              ...loginInput,
              [e.target.name]: [e.target.value],
            })
          }
        />
        <input
          placeholder="Password..."
          name="password"
          value={loginInput.password}
          onChange={(e) =>
            setLoginInput({
              ...loginInput,
              [e.target.name]: [e.target.value],
            })
          }
        />

        <button onClick={login}>Login</button>

        <button onClick={loginWithGoogle}>Login with Google</button>
      </div>

      <h4> User Logged In: </h4>
      {user ? user.email : "Not logged in"}

      <button onClick={logout}> Sign Out </button>
    </div>
  );
}

export default App;
