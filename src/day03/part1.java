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
        Point2D origin = new Point2D(0, 0);
        int minDistance = Integer.MAX_VALUE;

        FileReader fr;
        try{
            fr = new FileReader("src/day03/input.txt");
            inputA = ReadDirections.readStringsInCommas(fr);
            inputB = ReadDirections.readStringsInCommas(fr);
            fr.close();
        }catch(Exception e){
            System.out.println("input problems, ending program");
            return;
        }

        /**
         * converts input Strings to movement class
         */
        for(String s : inputA){
            movementsA.add(new Movement(s));
        }
        for(String s : inputB){
            movementsB.add(new Movement(s));
        }

        /**
         * creates lists of points then converted to hashset in pointsA
         */
        Point2D start = origin;
        for (Movement move : movementsA){
            List<Point2D> points = move.apply(start);
            start = points.get(points.size()-1);
            pointsA.addAll(points);
        }

        /**
         * finds the lowest manhattan distance intersection point between wires A and B
         */
        start = origin;
        for (Movement move: movementsB){
            List<Point2D> points = move.apply(start);
            start = points.get(points.size()-1);
            for(Point2D point: points){
                if(point.MDistance()< minDistance && pointsA.contains(point)){
                    minDistance = point.MDistance();
                }
            }
        }

        System.out.println("Result = " + minDistance);
        return;
    }
}
