package day06;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class part2 {
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

        Count count = new Count(orbits);
        count.run();
        System.out.println("Result = " + SharedTotal.answer);
        System.out.println("\tSan = " + SharedTotal.FoundSAN + "\tYOU = " + SharedTotal.FoundYOU);
        //429 too high
    }
}
