package jona.Heroes.Supports;

import jona.Heroes.HeroSpecific;

import java.sql.Time;

public class Mercy extends HeroSpecific {

    float healingDone;

    public Mercy(String heroName, float deaths, float dmg, float kills, float assists, float healing, float elimsPerLife, Time time, int gamesPlayed, int gamesWon, int gamesLost) {
        super(heroName, deaths, dmg, kills, assists, elimsPerLife, time, gamesPlayed, gamesWon, gamesLost);
        healingDone = healing;
    }

    public float getHealingDone() {
        return healingDone;
    }

    public void setHealingDone(float healingDone) {
        this.healingDone = healingDone;
    }

    @Override
    public String toString() {
        return "Mercy{" +
                "healingDone=" + healingDone +
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
