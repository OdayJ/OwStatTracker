import HeroCards from "@/app/components/playerprofile/HeroCards";
import ProfileHeader from "@/app/components/playerprofile/header";

const fetchStats = async (params) => {
  const processedId = params.split("%23")[1];
  const processUser = params.split("%23")[0];
  const res = await fetch(`http://localhost:3001/api/${processedId}/stats`);
  const data = await res.json();

  if (data == -1) {
    const data = {
      username: processUser,
      id: processedId,
      platform: "pc",
      mode: "competitive",
    };

    try {
      const response = await fetch("http://localhost:3001/api/qlist", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
      });
    } catch (error) {
      console.error("There was an error saving the data:", error);
    }
  }
  return data;
};

export default async function Player({ params }) {
  const stats = await fetchStats(params.id);
  const latestData = Object.values(stats?.current ?? {})[0] ?? null;

  const allHeroes = [];
  if (latestData?.supports) {
    Object.values(latestData.supports).forEach((hero) => {
      allHeroes.push({ ...hero, category: "Support" });
    });
  }
  if (latestData?.damage) {
    Object.values(latestData.damage).forEach((hero) => {
      allHeroes.push({ ...hero, category: "Damage" });
    });
  }
  if (latestData?.tanks) {
    Object.values(latestData.tanks).forEach((hero) => {
      allHeroes.push({ ...hero, category: "Tank" });
    });
  }
  allHeroes.sort((a, b) => (b["games_played"] || 0) - (a["games_played"] || 0));

  return (
    <>
      {!(stats == -1) && (
        <div className="w-full h-screen">
          <ProfileHeader user={stats.username} />

          <div className="mt-8 flex gap-8 flex-col place-items-center lg:grid lg:grid-cols-2">
            {allHeroes.map((hero, index) => (
              <HeroCards key={index} hero={hero} category={hero.category} />
            ))}
          </div>
        </div>
      )}
    </>
  );
}
