import { configureStore } from "@reduxjs/toolkit";
import customerReducer from "../features/customerSlice";
import reservationReducer from "../features/reservationSlice";

export const store = configureStore({
  reducer: {
      reservations: reservationReducer,
      customer: customerReducer
  },
});

//return the type of the root state
export type RootState = ReturnType<typeof store.getState>;

export type AppDispatch = typeof store.dispatch;
