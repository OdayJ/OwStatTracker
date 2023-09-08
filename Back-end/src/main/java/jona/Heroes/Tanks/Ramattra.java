package jona.Heroes.Tanks;

import jona.Heroes.HeroSpecific;

import java.sql.Time;

public class Ramattra extends HeroSpecific {
    float critHits;
    float critKills;

    public Ramattra(String heroName, float critHits, float critKills, float deaths, float dmg, float kills, float assists, float elimsPerLife, Time time, int gamesPlayed, int gamesWon, int gamesLost) {
        super(heroName, deaths, dmg, kills, assists, elimsPerLife, time, gamesPlayed, gamesWon, gamesLost);
        this.critHits = critHits;
        this.critKills = critKills;
    }

    public float getCritHits() {
        return critHits;
    }

    public void setCritHits(float critHits) {
        this.critHits = critHits;
    }

    public float getCritKills() {
        return critKills;
    }

    public void setCritKills(float critKills) {
        this.critKills = critKills;
    }

    @Override
    public String toString() {
        return "Ramattra{" +
                "critHits=" + critHits +
                ", critKills=" + critKills +
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
