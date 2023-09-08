import express from "express";
import { QList } from "../models/Qlist.js";
const router = express.Router();

// // Add a new entry o the list
// router.post("/qlist", async (req, res) => {
//   const listEntry = new QList(req.body);
//   try {
//     const response = await listEntry.save();
//     res.json(listEntry);
//   } catch (err) {
//     res.json(err);
//   }
// });

router.post("/qlist", async (req, res) => {
  // Extracting the unique field (assuming it's username) from request body
  const { username, id, platform, mode } = req.body;

  // Check if user already exists
  const existingEntry = await QList.findOne({ username, id });
  if (existingEntry) {
    return res.status(409).json(-1); // 409 Conflict
  }

  // Create a new list entry
  const listEntry = new QList(req.body);

  try {
    await listEntry.save();
    res.json(listEntry);
  } catch (err) {
    res.status(500).json(err); // 500 Internal Server Error
  }
});

// Get the qlist
router.get("/qlist", async (req, res) => {
  try {
    const qlists = await QList.find();
    res.json(qlists);
  } catch (err) {
    res.status(500).json(err);
  }
});

// Delete the qlist
router.delete("/qlist", async (req, res) => {
  try {
    await QList.deleteMany({});
    res.json({ message: "The Qlist has been cleared." });
  } catch (err) {
    res.status(500).json({ error: "Failed to clear the Qlist" });
  }
});
export { router as qlistRouter };
