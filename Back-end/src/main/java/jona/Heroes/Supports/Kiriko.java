package jona.Heroes.Supports;

import jona.Heroes.HeroSpecific;

import java.sql.Time;

public class Kiriko extends HeroSpecific {
    float healingDone;
    float critHits;
    float critKills;

    public Kiriko(String heroName, float critHits, float critKills, float deaths, float dmg, float kills, float assists, float healingDone, float elimsPerLife, Time time, int gamesPlayed, int gamesWon, int gamesLost) {
        super(heroName, deaths, dmg, kills, assists, elimsPerLife, time, gamesPlayed, gamesWon, gamesLost);
        this.healingDone = healingDone;
        this.critHits = critHits;
        this.critKills = critKills;
    }

    public float getHealingDone() {
        return healingDone;
    }

    public void setHealingDone(float healingDone) {
        this.healingDone = healingDone;
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
        return "Kiriko{" +
                "healingDone=" + healingDone +
                ", critHits=" + critHits +
                ", critKills=" + critKills +
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
