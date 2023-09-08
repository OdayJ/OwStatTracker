package jona.Heroes.Tanks;

import jona.Heroes.HeroSpecific;

import java.sql.Time;

public class WreckingBall extends HeroSpecific {
    float critHits;

    public WreckingBall(String heroName, float critHits, float deaths, float dmg, float kills, float assists, float elimsPerLife, Time time, int gamesPlayed, int gamesWon, int gamesLost) {
        super(heroName, deaths, dmg, kills, assists, elimsPerLife, time, gamesPlayed, gamesWon, gamesLost);
        this.critHits = critHits;
    }

    @Override
    public String toString() {
        return "WreckingBall{" +
                "critHits=" + critHits +
                ", heroName='" + heroName + '\'' +
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
