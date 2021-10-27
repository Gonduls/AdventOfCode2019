package day05;

import java.util.List;

import static day02.ReadF.readInCommas;

/*
    For actual part 1 give 1 as input, for actual part 2 give 5 as input
 */
public class part1 {
    public static void main(String[] args) {
        List<Integer> input;
        IntcodeManager2 manager;

        try{
            input = readInCommas("src/day05/input.txt");
        }catch (Exception e){
            System.out.println("input problems, ending program");
            return;
        }

        manager = new IntcodeManager2(input);
        try{
            manager.play();
        }catch(Exception e){
            System.out.println(e + ", ending program.");
        }

    }
}
