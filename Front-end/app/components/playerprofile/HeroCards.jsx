export default function HeroCards({ hero, category }) {
  const winrate = ((hero.games_won / hero.games_played) * 100).toFixed(1);
  const average = hero["average"];
  var image = `/Icon-${hero.name}.png`;
  if (hero.name == "soldier: 76") {
    image = "/Icon-soldier.png";
  }
  return (
    <div className="h-96 w-11/12 rounded-md shadow-sm bg-[#1d253a] grid grid-rows-3 grid-cols-3 place-items-center md:grid-cols-4 md:h-[32rem]">
      <div className="bg-[#141C2D] w-full h-full grid place-items-center rounded-t-md">
        <div className="w-16 h-16 bg-white grid place-items-center">
          <img src={image} className=" bg-blue-200  h-11/12 w-11/12" />
        </div>
      </div>
      <div className=" bg-[#141C2D] w-full h-full grid place-items-center">
        <div className="flex flex-col gap-2 text-sm text-white font-medium justify-self-start ">
          <p className="uppercase">{hero.name}</p>
          <p className="opacity-70">{category}</p>
        </div>
      </div>
      <div className=" bg-[#141C2D] w-full h-full grid place-items-center md:col-start-4 rounded-t-md">
        <div className="text-[#8FBC8F] flex flex-col gap-0 font-bold place-items-center ">
          <p className="text-white font-normal text-sm opacity-70">Winrate</p>
          <p>{winrate}%</p>
        </div>
      </div>
      <div className="bg-[#141C2D] hidden md:block md:col-start-3 w-full h-full md:row-start-1"></div>

      <div className="row-start-3 col-start-3 w-full h-full md:col-start-4 grid place-items-center">
        <button className="bg-[#f1742b] text-white rounded-md px-5 py-2 font-bold shadow-sm ">
          Extra
        </button>
      </div>

      <div className="text-white  w-full h-full grid grid-rows-2 place-items-center justify-items-start">
        <div className="opacity-85 pl-8">Eliminations</div>
        <div className="self-start pl-8">
          {average["eliminations"].toFixed(1)}
          <span className="opacity-50 text-xs "> / 10 min</span>
        </div>
      </div>
      <div className="text-white  w-full h-full grid grid-rows-2 place-items-center justify-items-start">
        <div className="opacity-85 pl-8">Deaths</div>
        <div className="self-start pl-8">
          {average["deaths"].toFixed(1)}
          <span className="opacity-50 text-xs "> / 10 min</span>
        </div>
      </div>
      <div className=" text-white  w-full h-full grid grid-rows-2 place-items-center justify-items-start">
        <div className="opacity-85 pl-8">Damage</div>
        <div className="self-start pl-8">
          {average["damage"].toFixed(1)}
          <span className="opacity-50 text-xs "> / 10 min</span>
        </div>
      </div>
      <div className=" text-white  w-full h-full grid grid-rows-2 place-items-center justify-items-start">
        <div className="opacity-85 pl-8">Assists</div>
        <div className="self-start pl-8">
          {average["assists"].toFixed(1)}
          <span className="opacity-50 text-xs "> / 10 min</span>
        </div>
      </div>
      <div className=" text-white  w-full h-full grid grid-rows-2 place-items-center justify-items-start">
        <div className="opacity-85 pl-8">Eliminations</div>
        <div className="self-start pl-8">
          {average["eliminations_per_life"].toFixed(1)}
          <span className="opacity-50 text-xs "> / life</span>
        </div>
      </div>
    </div>
  );
}
