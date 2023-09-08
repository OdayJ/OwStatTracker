package jona.Heroes.Damage;

import jona.Heroes.HeroSpecific;

import java.sql.Time;

public class Junkrat extends HeroSpecific {

    public Junkrat(String heroName, float deaths, float dmg, float kills, float assists, float elimsPerLife, Time time, int gamesPlayed, int gamesWon, int gamesLost) {
        super(heroName, deaths, dmg, kills, assists, elimsPerLife, time, gamesPlayed, gamesWon, gamesLost);
    }

    @Override
    public String toString() {
        return "Junkrat{" +
                "heroName='" + heroName + '\'' +
                ", heroDmg=" + heroDmg +
                ", deaths=" + deaths +
                ", kills=" + kills +
                ", assists=" + assists +
                ", elimsPerLife=" + elimsPerLife +
                ", time=" + time +
                ", gamesPlayed=" + gamesPlayed +
                ", gamesWon=" + gamesWon +
                ", gamesLost=" + gamesLost +
                '}';
    }
}
