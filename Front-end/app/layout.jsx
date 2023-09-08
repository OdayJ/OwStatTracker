import Hydrate from "./components/Hydrate";
import Nav from "./components/nav";
import "./globals.css";
import { Inter } from "next/font/google";

const inter = Inter({ subsets: ["latin"] });

export const metadata = {
  title: "OverTuff",
  description: "Generated by noja Ltd.",
};

export default function RootLayout({ children }) {
  return (
    <html lang="en">
      <body className={inter.className}>
        <Hydrate>
          <Nav />
          {children}
        </Hydrate>
      </body>
    </html>
  );
}