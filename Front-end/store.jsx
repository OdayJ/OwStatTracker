import { create } from "zustand";

export const userSideBar = create((set) => ({
  on: false,
  toggleBar: () => set((state) => ({ on: !state.on })),
}));
