package jona.Heroes.Supports;

import jona.Heroes.HeroSpecific;

import java.sql.Time;

public class Baptiste extends HeroSpecific {
    float healingDone;
    float critKills;
    float critHits;

    public Baptiste(String heroName, float critHits, float critKills, float deaths, float dmg, float kills, float assists, float healing, float elimsPerLife, Time time, int gamesPlayed, int gamesWon, int gamesLost) {
        super(heroName, deaths, dmg, kills, assists, elimsPerLife, time, gamesPlayed, gamesWon, gamesLost);
        healingDone = healing;
        this.critKills = critKills;
        this.critHits = critHits;
    }

    public float getHealingDone() {
        return healingDone;
    }

    public void setHealingDone(float healingDone) {
        this.healingDone = healingDone;
    }

    public float getCritKills() {
        return critKills;
    }

    public void setCritKills(float critKills) {
        this.critKills = critKills;
    }

    public float getCritHits() {
        return critHits;
    }

    public void setCritHits(float critHits) {
        this.critHits = critHits;
    }

    @Override
    public String toString() {
        return "Baptiste{" +
                "healingDone=" + healingDone +
                ", critKills=" + critKills +
                ", critHits=" + critHits +
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
