import dotenv from "dotenv";
import express from "express";
import cors from "cors";
import mongoose from "mongoose";

import { userRouter } from "./routes/users.js";
import { qlistRouter } from "./routes/qlist.js";

dotenv.config();

const app = express();

app.use(express.json());
app.use(cors());

app.use("/api", userRouter);
app.use("/api", qlistRouter);

mongoose.connect(process.env.DATABASE_URL);

app.listen(3001, () => console.log("Server is Running..."));
