import mongoose from "mongoose";

const UserSchema = new mongoose.Schema({
  username: { type: String, required: true, unique: true },
  id: Number,
  validated: String,
  current: mongoose.Schema.Types.Mixed,
});

export const UserModel = mongoose.model("users", UserSchema);
