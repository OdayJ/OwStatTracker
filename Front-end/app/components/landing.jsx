import Playersearch from "./playersearch";
import Partners from "./partners";

export default function Landing() {
  return (
    <div className="relative h-screen bg-body bg-cover bg-no-repeat bg-center">
      <div className="absolute inset-0 bg-black opacity-50"></div>
      <div className="absolute grid grid-rows-6 h-screen w-full place-items-center ">
        <div className="row-start-2 grid place-items-center">
          <img src="/ow2.png" className="w-3/4 lg:w-1/2"></img>
        </div>

        <div className="row-start-3 h-full w-full grid justify-items-center lg:place-items-center ">
          <Playersearch />
        </div>
        <div className="row-start-4 row-span-2 w-full h-full grid justify-items-center ">
          <img src="ad.jpeg" className="w-3/4  md:w-2/4 lg:w-1/4 " />
        </div>
        <div className=" row-start-6  text-center self-start ">
          <Partners />
        </div>
      </div>
    </div>
  );
}
