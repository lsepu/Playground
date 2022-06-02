import { useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";
import { bindActionCreators } from "redux";
import "./App.css";
import { actionCreators, State } from "./state";
import { fetchPosts } from "./state/action-creators";

function App() {
  const dispatch = useDispatch();

  const { depositMoney, withdrawMoney, bankruptMoney } = bindActionCreators(
    actionCreators,
    dispatch
  );

  //testing thunk
  useEffect(() => {
    dispatch(fetchPosts());
  }, []);

  const amount = useSelector((state: State) => state.bank);

  return (
    <div className="App">
      <h1>{amount}</h1>
      <button onClick={() => depositMoney(1000)}>Deposit</button>
      <button onClick={() => withdrawMoney(500)}>Withdraw</button>
      <button onClick={() => bankruptMoney()}>Bankrupt</button>

    </div>
  );
}

export default App;
