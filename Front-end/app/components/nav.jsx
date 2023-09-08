"use client";
import { userSideBar } from "@/store";
import { AnimatePresence, motion } from "framer-motion";
import Image from "next/image";
import Link from "next/link";
import { AiOutlineMenu, AiOutlineUser } from "react-icons/ai";
import SideBar from "./sidebar";
export default function Nav() {
  const sideBar = userSideBar((state) => state.on);
  const toggleSideBar = userSideBar((state) => state.toggleBar);

  return (
    <div className="grid place-items-center">
      <div className="h-20 w-full top-0 fixed z-50 bg-[#ebeff4] grid grid-cols-5 place-items-center lg:rounded lg:w-11/12 lg:my-8">
        <AiOutlineMenu
          color="#333E48"
          size={28}
          className="cursor-pointer lg:hidden"
          onClick={toggleSideBar}
        />
        <Link
          className="h-20 pl-4 pr-4 col-start-1 place-self-start hidden bg-white lg:block"
          href={"/"}
        >
          <img className=" h-full rounded-l-md " src="/logo2.png " />
        </Link>
        <img className="h-14 col-start-3 lg:hidden" src="/logo.png " />
        <AiOutlineUser
          color="#333E48"
          size={28}
          className="col-start-5 cursor-pointer lg:hidden"
        />
        <Link
          href={"/dashboard"}
          className=" col-start-5 justify-self-end text-lg text-white font-bold  hidden lg:block"
        >
          <button className="bg-[#f06414] hover:bg-[#f1742b] mr-4 px-3 py-2 rounded-md">
            About us
          </button>
        </Link>
        <AnimatePresence>{sideBar && <SideBar />}</AnimatePresence>
      </div>
    </div>
  );
}
