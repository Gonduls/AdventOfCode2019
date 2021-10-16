package day02;

import java.util.ArrayList;
import java.util.List;

public class part1 {
    public static void main(String[] args){
        List<Integer> list;
        IntcodeManager managee;
        try{
            list = ReadF.readInCommas("AdventOfCode2019/src/day02/input.txt");
        }catch(Exception e){
            System.out.println("input problems, ending program");
            return;
        }
        list.set(1, 12);
        list.set(2, 2);
        managee = new IntcodeManager(list);
        try{
            managee.play();
        }catch(Exception e){
            System.out.println(e + ", ending program.");
            return;
        }

        System.out.println("Result = " + list.get(0));

        return;


    }
}
