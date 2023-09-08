package jona.Heroes.Supports;

import jona.Heroes.HeroSpecific;

import java.sql.Time;

public class Ana extends HeroSpecific {
    float healingDone;

    public Ana(String heroName, float deaths, float dmg, float kills, float assists, float healing, float elimsPerLife, Time time, int gamesPlayed, int gamesWon, int gamesLost) {
        super(heroName, deaths, dmg, kills, assists, elimsPerLife, time, gamesPlayed, gamesWon, gamesLost);
        this.healingDone = healing;
    }

    public float getHealingDone() {
        return healingDone;
    }

    public void setHealingDone(float healingDone) {
        this.healingDone = healingDone;
    }

    @Override
    public String toString() {
        return "Ana{" +
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