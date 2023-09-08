import {
  BsPlaystation,
  BsXbox,
  BsSteam,
  BsNintendoSwitch,
} from "react-icons/bs";
export default function Partners() {
  return (
    <div className="flex gap-8">
      <BsPlaystation size={48} color="white" opacity={0.7} />
      <BsXbox size={48} color="white" opacity={0.7} />
      <BsSteam size={48} color="white" opacity={0.7} />
      <BsNintendoSwitch size={48} color="white" opacity={0.7} />
    </div>
  );
}
