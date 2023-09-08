package jona.Utils;

import jona.Heroes.HeroSpecific;

import java.util.ArrayList;
import java.util.Arrays;

public class Characters {
    static ArrayList<String> supports;
    static ArrayList<String> damage;
    static ArrayList<String> tanks;

    public static String heroClassCheck(String name){
        for (String heroName : supports){
            if (name.equals(heroName))
                return "supports";
        }

        for (String heroName : damage){
            if (name.equals(heroName))
                return "damage";
        }

        for (String heroName : tanks){
            if (name.equals(heroName))
                return "tanks";
        }

        return null;
    }

    public static void fillArrays(){
        supports = new ArrayList<>(Arrays.asList("illari", "ana", "baptiste", "brigitte", "kiriko", "lifeweaver", "lúcio", "mercy", "moira", "zenyatta"));
        damage = new ArrayList<>(Arrays.asList("ashe", "bastion", "cassidy", "echo", "genji", "hanzo", "junkrat", "mei", "pharah", "reaper", "sojourn", "soldier: 76", "sombra", "symmetra", "torbjörn", "tracer", "widowmaker"));
        tanks = new ArrayList<>(Arrays.asList("d.va", "doomfist", "junker queen", "orisa", "ramattra", "reinhardt", "roadhog", "sigma", "winston", "wrecking ball", "zarya"));
    }
}
