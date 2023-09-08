"use client";
import { useState } from "react";

import Link from "next/link";
export default function Playersearch() {
  const [id, setID] = useState("");

  // Usage

  // const handleClick = async (input) => {
  //   // Assume input is something like "ABC#123"
  //   const [username, id] = input.split("#");

  //   const data = {
  //     username,
  //     id,
  //     platform: "pc",
  //     mode: "competitive",
  //   };

  //   // // First, check if the user exists in the 'users' collection
  //   // const userRes = await fetch(`/api/users/exists/${id}`);
  //   // const userExists = await userRes.json();

  //   // if (userExists === 1) {
  //   //   console.log("User already exists in 'users', skipping 'qlist' check.");
  //   //   return;
  //   // }

  //   // If the user doesn't exist in 'users', proceed to add/check in 'qlist'
  //   try {
  //     const response = await fetch("/api/qlist", {
  //       method: "POST",
  //       headers: {
  //         "Content-Type": "application/json",
  //       },
  //       body: JSON.stringify(data),
  //     });

  //     if (response.ok) {
  //       const responseData = await response.json();
  //       console.log("Data saved successfully:", responseData);
  //     } else {
  //       const responseError = await response.json();
  //       console.error("Server responded with an error:", responseError);
  //     }
  //   } catch (error) {
  //     console.error("There was an error saving the data:", error);
  //   }
  // };

  // // Send user when clicking the button
  // const handleClick = async (input) => {
  //   // Assume input is something like "ABC#123"
  //   const [username, id] = input.split("#");

  //   const data = {
  //     username,
  //     id,
  //     platform: "pc",
  //     mode: "competitive",
  //   };

  //   try {
  //     const response = await fetch("http://localhost:3001/api/qlist", {
  //       method: "POST",
  //       headers: {
  //         "Content-Type": "application/json",
  //       },
  //       body: JSON.stringify(data),
  //     });

  //     if (response.ok) {
  //       const responseData = await response.json();
  //       console.log("Data saved successfully:", responseData);
  //     } else {
  //       console.error("Server responded with an error:", response);
  //     }
  //   } catch (error) {
  //     console.error("There was an error saving the data:", error);
  //   }
  // };

  return (
    <div className="flex">
      <input
        autoComplete="off"
        spellCheck="false"
        className="placeholder:italic placeholder:text-slate-400 text-slate-500 block bg-white rounded-l-md w-60 md:w-72 lg:w-96 h-12 border border-slate-300  py-2 pl-4 pr-3 shadow-sm focus:outline-none focus:border-orange-500 focus:ring-orange-500 focus:ring-0 "
        placeholder="Enter your BattleTag#1234"
        type="text"
        name="search"
        onChange={(event) => setID(event.target.value)}
      />
      <Link
        href={{ pathname: `/player/${id}` }}
        className="text-xl text-white font-bold"
      >
        <button className="bg-[#f06414] hover:bg-[#FF7B2E]  h-12 px-4 rounded-r-md">
          GO
        </button>
      </Link>
    </div>
  );
}
