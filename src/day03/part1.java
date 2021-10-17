package day03;

import java.io.FileReader;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class part1 {
    public static void main(String[] args) {
        List<String> inputA;
        List<String> inputB;
        List<Movement> movementsA = new ArrayList<Movement>();
        List<Movement> movementsB = new ArrayList<Movement>();
        HashSet<Point2D> pointsA = new HashSet<Point2D>();

        FileReader fr;
        try{
            fr = new FileReader("AdventOfCode2019/src/day03/input.txt");
            inputA = ReadDirections.readInCommas(fr);
            inputB = ReadDirections.readInCommas(fr);
            fr.close();
        }catch(Exception e){
            System.out.println("input problems, ending program");
            return;
        }

        for(String s : inputA){
            movementsA.add(new Movement(s));
        }
        for(String s : inputB){
            movementsB.add(new Movement(s));
        }

        return;

    }
}
