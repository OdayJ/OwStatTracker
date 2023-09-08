import { AnimatePresence, motion } from "framer-motion";
import { userSideBar } from "@/store";
import { AiOutlineClose } from "react-icons/ai";
export default function SideBar() {
  const toggleSideBar = userSideBar((state) => state.toggleBar);
  return (
    <motion.div
      animate={{ opacity: 1 }}
      initial={{ opacity: 0 }}
      exit={{ opacity: 0 }}
      onClick={toggleSideBar}
      className="fixed w-full h-screen top-0 left-0 bg-black/25"
    >
      <motion.div
        className="bg-[#ebeff4] absolute left-0 top-0 w-3/4 overflow-y-scroll h-screen grid grid-rows-4 place-items-center"
        layout
        onClick={(e) => e.stopPropagation()}
        animate={{ opacity: 1 }}
        initial={{ opacity: 0 }}
        exit={{ opacity: 0 }}
      >
        <div
          className="absolute top-0 left-0 pt-5 pl-5 cursor-pointer"
          onClick={toggleSideBar}
        >
          <AiOutlineClose size={32} color="#333e48" />
        </div>
        <img src="./logo2.png" width={128} />
        <button className="bg-[#f06414] hover:bg-[#FF7B2E] px-4 text-xl text-white font-bold ">
          About us
        </button>
      </motion.div>
    </motion.div>
  );
}
