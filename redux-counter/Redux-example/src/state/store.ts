import { configureStore } from "@reduxjs/toolkit";
import reducers from "./reducers";

//thunk is automatically added
export const store = configureStore({
  reducer: reducers,
});
