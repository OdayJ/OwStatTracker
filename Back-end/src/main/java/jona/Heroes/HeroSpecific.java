package jona.Heroes;

import java.sql.Time;

public class HeroSpecific {
    protected String heroName;
    protected float heroDmg;
    protected float deaths;
    protected float kills;
    protected float assists;
    protected float elimsPerLife;
    protected Time time;
    protected int gamesPlayed;
    protected int gamesWon;
    protected int gamesLost;

    public HeroSpecific(String heroName, float deaths, float dmg, float kills, float assists, float elimsPerLife, Time time, int gamesPlayed, int gamesWon, int gamesLost){
        this.heroName = heroName;
        this.heroDmg = dmg;
        this.deaths = deaths;
        this.kills = kills;
        this.assists = assists;
        this.elimsPerLife = elimsPerLife;
        this.time = time;
        this.gamesPlayed = gamesPlayed;
        this.gamesWon = gamesWon;
        this.gamesLost = gamesLost;
    }

    public float getHeroDmg() {
        return heroDmg;
    }

    public void setHeroDmg(float heroDmg) {
        this.heroDmg = heroDmg;
    }

    public float getDeaths() {
        return deaths;
    }

    public float getElimsPerLife() {
        return elimsPerLife;
    }

    public void setElimsPerLife(float elimsPerLife) {
        this.elimsPerLife = elimsPerLife;
    }

    public void setDeaths(float deaths) {
        this.deaths = deaths;
    }

    public float getKills() {
        return kills;
    }

    public void setKills(float kills) {
        this.kills = kills;
    }

    public float getAssists() {
        return assists;
    }

    public void setAssists(float assists) {
        this.assists = assists;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }
}
