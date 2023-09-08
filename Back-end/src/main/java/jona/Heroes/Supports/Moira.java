package jona.Heroes.Supports;

import jona.Heroes.HeroSpecific;

import java.sql.Time;

public class Moira extends HeroSpecific {
    float healingDone;


    public Moira(String heroName, float deaths, float dmg, float kills, float assists, float healingDone, float elimsPerLife, Time time, int gamesPlayed, int gamesWon, int gamesLost) {
        super(heroName, deaths, dmg, kills, assists, elimsPerLife, time, gamesPlayed, gamesWon, gamesLost);
        this.healingDone = healingDone;
    }

    public float getHealingDone() {
        return healingDone;
    }

    public void setHealingDone(float healingDone) {
        this.healingDone = healingDone;
    }

    @Override
    public String toString() {
        return "Moira{" +
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
