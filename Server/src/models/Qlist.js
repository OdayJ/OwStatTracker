import mongoose from "mongoose";

const QlistSchema = new mongoose.Schema(
  {
    username: { type: String, required: true, unique: true },
    id: { type: Number, required: true, unique: true },
    platform: { type: String, required: true },
    mode: { type: String, required: true },
  },
  { versionKey: false }
);

export const QList = mongoose.model("qlist", QlistSchema);
