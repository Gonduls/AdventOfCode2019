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
            input = ReadStrings.readLines("src/day06/input.txt");
        }catch(Exception e){
            System.out.println("input problems, ending program");
            return;
        }

        // Populating hashmap
        for(String s : input){
            if(orbits.containsKey(s.substring(0,3))) {
                orbits.get(s.substring(0, 3)).add(s.substring(4));
                continue;
            }
            List<String> a = new LinkedList<>();
            a.add(s.substring(4));
            orbits.put(s.substring(0, 3), a);
        }

        // result calculated by summation of distances from every planet to COM, by using a list as a queue
        int result = 0;
        planets.add(new Planet("COM", 0)); // initializing queue

        while(!planets.isEmpty()){
            // Pop first element
            Planet planet = planets.get(0);
            planets.remove(0);

            result += planet.getDistance(); // sum distance to COM to result

            // add planets orbiting current planet at the end of the queue
            if(orbits.containsKey(planet.getName())) {
                for (String s : orbits.get(planet.getName())) {
                    planets.add(new Planet(s, planet.getDistance() + 1));
                }
            }
        }

        System.out.println("Result = " + result);
    }
}

class Planet{
    int distance;
    String name;

    Planet(String name, int distance){
        this.name = name;
        this.distance = distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
