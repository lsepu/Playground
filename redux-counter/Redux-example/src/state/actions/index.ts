import { ActionType } from "../action-types";

interface DepositAction {
    type: ActionType.DEPOSIT;
    payload: number;
  }
  
  interface WithdrawAction {
    type: ActionType.WITHDRAW;
    payload: number;
  }
  
  interface BankruptAction {
    type: ActionType.BANKRUPT;
  }

  interface fecthPosts {
    type: ActionType.FETCH_POSTS;
    payload: Object
  }
  
  export type Action = DepositAction | WithdrawAction | BankruptAction | fecthPosts;