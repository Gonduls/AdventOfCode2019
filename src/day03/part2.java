package day03;

        import java.io.FileReader;
        import java.util.HashMap;
        import java.util.List;
        import java.util.ArrayList;

public class part2 {
    public static void main(String[] args) {
        List<String> inputA;
        List<String> inputB;
        List<CardinalMovement> movementsA = new ArrayList<CardinalMovement>();
        List<CardinalMovement> movementsB = new ArrayList<CardinalMovement>();
        HashMap<Point2D, Integer> pointsA = new HashMap<Point2D, Integer>();
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
            movementsA.add(new CardinalMovement(s));
        }
        for(String s : inputB){
            movementsB.add(new CardinalMovement(s));
        }

        /**
         * creates lists of cardinal points then converted to hashmap in pointsA
         * hashmap needed to store point and its lowest step value
         */
        Point2D start = origin;
        int step = 0;
        for (CardinalMovement move : movementsA){
            List<CardinalPoint2D> points = move.apply(start, step);

            // populating hashmap only if point not present yet, to preserve lower step
            // hash map only cares about the 2D nature of a point, not its cardinal number
            for(CardinalPoint2D point : points){
                if(pointsA.containsKey(point))
                    continue;
                pointsA.put(point, point.getStep());
            }

            // initializing values for next iteration
            start = points.get(points.size()-1);
            step = points.get(points.size()-1).getStep();
        }

        /**
         * finds the lowest "combined steps" distance intersection point between wires A and B
         */
        start = origin;
        step = 0;
        for (CardinalMovement move : movementsB){
            List<CardinalPoint2D> points = move.apply(start, step);
            for(Point2D point: points){
                step += 1;
                if(pointsA.containsKey(point) && (step + pointsA.get(point))< minDistance){
                    minDistance = step + pointsA.get(point);
                }
            }

            // initializing value for next iteration
            start = points.get(points.size()-1);
        }
        System.out.println("Result = " + minDistance);
    }
}
