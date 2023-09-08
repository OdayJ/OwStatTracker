import { GiSilverBullet } from "react-icons/gi";
import { BiPlusMedical, BiSolidShield } from "react-icons/bi";
export default function ProfileHeader({ user }) {
  return (
    <div className="w-full h-4/5 bg-[#1d253a] grid grid-rows-4 grid-cols-3 place-items-center">
      <div className="row-start-2 col-start-2 row-span-2 lg:self-start 2xl:self-start flex flex-col gap-4 place-items-center ">
        <div className="bg-white w-40 h-40 xl:w-48 xl:h-48 2xl:w-60 2xl:h-60  p-1 rounded-md">
          <img src="/playericon.png" />
        </div>
        <div className="text-white font-bold uppercase md:text-xl opacity-80">
          {user}
        </div>
        <div className="text-orange-400 md:text-xl  font-medium italic ">
          "No Brainer"
        </div>
      </div>

      <div className="row-start-4 w-full h-full grid grid-rows-2 place-items-center">
        <BiSolidShield color="white" size={32} className="self-start " />
        <GiSilverBullet color="white" size={32} className="self-start " />
      </div>
      <div className="row-start-4 w-full h-full grid grid-rows-2 place-items-center">
        <GiSilverBullet color="white" size={32} className="self-start " />
        <GiSilverBullet color="white" size={32} className="self-start " />
      </div>
      <div className="row-start-4 w-full h-full grid grid-rows-2 place-items-center">
        <BiPlusMedical color="white" size={32} className="self-start " />
        <GiSilverBullet color="white" size={32} className="self-start " />
      </div>
    </div>
  );
}
