package day06;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class part2 {
    public static void main(String[] args) {
        List<String> input;
        HashMap<String, List<String>> orbits = new HashMap<>();

        try{
            input = ReadStrings.readLines("src/day06/input.txt");
        }catch(Exception e){
            System.out.println("input problems, ending program");
            return;
        }

        // populating hashmap
        for(String s : input){
            if(orbits.containsKey(s.substring(0,3))) {
                orbits.get(s.substring(0, 3)).add(s.substring(4));
                continue;
            }
            List<String> a = new LinkedList<>();
            a.add(s.substring(4));
            orbits.put(s.substring(0, 3), a);
        }

        // Thread operations
        Count count = new Count(orbits);
        count.start();
        try{
            count.join();
        }catch(InterruptedException e){
            System.out.println("Error in joining thread in main\n" + e);
            return;
        }

        // Result sits in shared between threads static class
        System.out.println("Result = " + SharedTotal.answer);
    }
}
