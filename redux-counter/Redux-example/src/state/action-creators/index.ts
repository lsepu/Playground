import { ActionType } from "../action-types";
import { Dispatch } from "redux";
import { Action } from "../actions";
import Axios from "axios";

export const depositMoney = (amount: number) => {
  return (dispatch: Dispatch<Action>) => {
    dispatch({
      type: ActionType.DEPOSIT,
      payload: amount,
    });
  };
};

export const withdrawMoney = (amount: number) => {
  return (dispatch: Dispatch<Action>) => {
    dispatch({
      type: ActionType.WITHDRAW,
      payload: amount,
    });
  };
};

export const bankruptMoney = () => {
  return (dispatch: Dispatch<Action>) => {
    dispatch({
      type: ActionType.BANKRUPT,
    });
  };
};



//thunk example, thunk allow us to return functions with our action creators
// export const fecthPosts = async () => {
//   const response = await Axios.get(
//     "https://jsonplaceholder.typicode.com/posts"
//   );

//   return {
//     type: ActionType.FETCH_POSTS,
//     payload: response.data,
//   };
// };

//thunk example, thunk allow us to return functions with our action creators
export const fetchPosts = () => {
//TODO: change any
    return async (dispatch: Dispatch<Action>, getState: any) => {
        const response = await Axios.get("https://jsonplaceholder.typicode.com/posts");
        dispatch({
            type: ActionType.FETCH_POSTS,
            payload: response.data
        })
    }
}