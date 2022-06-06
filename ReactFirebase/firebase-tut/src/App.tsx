import { useEffect, useState } from "react";
import "./App.css";
import { db } from "./firebase-config";
import { collection, getDocs, addDoc, updateDoc, deleteDoc, doc } from "firebase/firestore";

interface IState {
  name: string;
  age: number;
  id: string;
}

interface INewUser {
  name: string;
  age: number;
}

function App() {
  const [input, setInput] = useState<INewUser>({
    name: "",
    age: 0,
  });
  const [users, setUsers] = useState<IState[]>();
  //get the collection by passing the db and collection name
  const usersCollectionRef = collection(db, "users");

  useEffect(() => {
    const getUsers = async () => {
      //return all documents inside the collection
      const data = await getDocs(usersCollectionRef);

      const dataRetrieved: IState[] = data.docs.map((doc) => ({
        name: doc.data().name,
        age: doc.data().age,
        id: doc.id,
      }));

      setUsers(dataRetrieved);
    };

    getUsers();
  }, []);

  const createUser = async () => {
    const newUser = {
      name: input.name,
      age: input.age,
    };

    const newuser = await addDoc(usersCollectionRef, newUser);

    //update front automatically
    const usersWithNewUser = [...users, { ...newUser, id: newuser.id }];
    setUsers(usersWithNewUser);

    setInput({
      name: "",
      age: 0,
    });
  };

  const updateUser = async (id: string, age: number) => {
    //get which user I want to update
    const userDoc = doc(db, "users", id);
    const newFields = {age: age + 1};
    await updateDoc(userDoc, newFields);

    //todo: update front automatically


  };

  const deleteUser = async(id: string) => {
    //get which user I want to delete
    const userDoc = doc(db, "users", id);
    await deleteDoc(userDoc);

    //todo: update front automatically

  }

  return (
    <div className="App">
      <input
        placeholder="Name..."
        name="name"
        value={input.name}
        onChange={(e) =>
          setInput({ ...input, [e.target.name]: [e.target.value] })
        }
      />
      <input
        type="number"
        placeholder="Age..."
        name="age"
        value={input.age}
        onChange={(e) =>
          setInput({ ...input, [e.target.name]: [e.target.value] })
        }
      />
      <button onClick={createUser}> Create User </button>

      {users?.map((user) => (
        <div>
          <h1>Name: {user.name}</h1>
          <h1>Age: {user.age}</h1>
          <button onClick={() => updateUser(user.id, user.age)}>
            Increase Age
          </button>
          <button onClick={() => deleteUser(user.id)}>Delete user</button>
        </div>
      ))}
    </div>
  );
}

export default App;
