package day07;

import java.util.*;

import static day02.ReadF.readInCommas;

public class part1 {
    public static int answer = 0;
    public static void main(String[] args) {
        // part1:
        Permutations perms = new Permutations(5);
        // part2:
        // Permutations perms = new Permutations(new int[] {5, 6, 7, 8, 9});
        Iterator<int[]> itr = perms.iterator();
        IntcodeManager3 manager;
        List<Integer> input;

        try{
            input = readInCommas("src/day07/input.txt");
        }catch (Exception e){
            System.out.println("input problems, ending program");
            return;
        }

        while(itr.hasNext()) {
            manager = new IntcodeManager3(input, itr.next());
            try {
                manager.play();
            }catch(Exception e){
                System.out.println("Everything failed, shutting down\n" + e);
            }
        }
        System.out.println("Answer: " + answer);
    }
}
