package day02;

import java.util.List;

public class part1 {
    public static void main(String[] args){
        List<Integer> list;
        IntcodeManager manager;
        try{
            list = ReadF.readInCommas("src/day02/input.txt");
        }catch(Exception e){
            System.out.println("input problems, ending program");
            return;
        }
        list.set(1, 12);
        list.set(2, 2);
        manager = new IntcodeManager(list);
        try{
            manager.play();
        }catch(Exception e){
            System.out.println(e + ", ending program.");
            return;
        }

        System.out.println("Result = " + list.get(0));

        return;


    }
}
