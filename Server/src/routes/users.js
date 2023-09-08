import express from "express";
import mongoose from "mongoose";
import { UserModel } from "../models/Users.js";

const router = express.Router();

router.get("/:id/stats", async (req, res) => {
  const start = Date.now();

  try {
    const id = req.params.id;
    const latest = await UserModel.findOne({ id }, "updated");
    if (!latest) {
      return res.status(404).json(-1);
    }
    const date = latest.get("updated");
    const user = await UserModel.findOne({ id }, `username id current.${date}`);
    if (!user) {
      return res.status(404).json(-1);
    }
    res.json(user);
  } catch (err) {
    res.status(500).json({ message: "Internal Server Error", error: err });
  }
  console.log(`Execution time: ${Date.now() - start}ms`);
});

router.get("/exists/:id", async (req, res) => {
  try {
    const id = req.params.id;
    const user = await UserModel.findOne({ id });

    if (!user) {
      return res.status(404).json(-1);
    }

    res.status(200).json(1);
  } catch (err) {
    console.error("Error:", err);
    res.status(500).json(-1);
  }
});

export { router as userRouter };
