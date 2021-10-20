package day06;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class part1 {
    public static void main(String[] args) {
        List<String> input;
        HashMap<String, List<String>> orbits = new HashMap<>();
        List<Planet> planets = new LinkedList<>();
        try{
            input = ReadStrings.readLines("AdventOfCode2019/src/day06/input.txt");
        }catch(Exception e){
            System.out.println("input problems, ending program");
            return;
        }
        for(String s : input){
            if(orbits.containsKey(s.substring(0,3))) {
                orbits.get(s.substring(0, 3)).add(s.substring(4));
                continue;
            }
            List<String> a = new LinkedList<>();
            a.add(s.substring(4));
            orbits.put(s.substring(0, 3), a);
        }
        int result = 0;
        planets.add(new Planet("COM", 0));
        while(!planets.isEmpty()){
            Planet planet = planets.get(0);
            planets.remove(0);
            result += planet.getLevel();
            if(orbits.containsKey(planet.getName())) {
                for (String s : orbits.get(planet.getName())) {
                    planets.add(new Planet(s, planet.getLevel() + 1));
                }
            }
        }

        System.out.println("Result = " + result);
    }
}

class Planet{
    int level;
    String name;

    Planet(String name, int level){
        this.name = name;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}
