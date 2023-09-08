package jona.Selenium;

import jona.Heroes.HeroSpecific;
import jona.MongoDB.MongoConnection;
import jona.Utils.Characters;

import java.sql.Date;
import java.util.ArrayList;

public class Runner {
    static ConnManager manager;
    static MongoConnection mongoConnection;

    public Runner(String playerName, int hashCode, String platform, String mode, String mongoUrl){
        String playerUrl = "https://overwatch.blizzard.com/career/" + playerName + "-" + String.valueOf(hashCode) + "/";
        manager = new ConnManager(playerUrl, platform.toLowerCase(), mode.toLowerCase());
        mongoConnection = new MongoConnection(mongoUrl, playerName, hashCode);
        Characters.fillArrays();

        getInformationFromWeb();
    }

    public void getInformationFromWeb(){
        manager.startConnection();
        manager.standBy(15);
        //boolean validated = manager.validateCompPage();
        boolean validated = true;

        if (validated){
            ArrayList<String> heroList = manager.getListOfChampions();
            ArrayList<HeroSpecific> supportList = new ArrayList<>();
            ArrayList<HeroSpecific> damageList = new ArrayList<>();
            ArrayList<HeroSpecific> tankList = new ArrayList<>();
            for (String name : heroList){
                String heroClass = Characters.heroClassCheck(name.toLowerCase());

                if (heroClass.equals("supports")){
                    System.out.println("Support: " + name);
                    HeroSpecific hero = manager.getHero(name.toLowerCase(), heroClass);
                    if (hero != null)
                        supportList.add(hero);
                } else if (heroClass.equals("damage")){
                    System.out.println("Dps: " + name);
                    HeroSpecific hero = manager.getHero(name.toLowerCase(), heroClass);
                    if (hero != null)
                        damageList.add(hero);
                } else if (heroClass.equals("tanks")){
                    System.out.println("Tank: " + name);
                    HeroSpecific hero = manager.getHero(name.toLowerCase(), heroClass);
                    if (hero != null)
                        tankList.add(hero);
                } else {
                    System.out.println("Problem occurred, class was not found!");
                }
            }
            manager.standBy(5);
            mongoConnection.createDocuments("supports", supportList);
            mongoConnection.createDocuments("damage", damageList);
            mongoConnection.createDocuments("tanks", tankList);
        }

        manager.endConnection();
    }
}