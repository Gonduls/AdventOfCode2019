package day03;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    final int amount;
    final int[] coefficients;

    /**
     * Translates input string to direction (coefficients) and amount of movement
     * @param string
     */
    public Movement(@NotNull String string){
        amount = Integer.parseInt(string.substring(1));
        coefficients = Directions.valueOf(string.substring(0,1)).getCoeff();
    }

    /**
     * applies movement given a start, by creating list of touched 2D points
     * @param start 2D point
     * @return list of touched 2D points
     */
    public List<Point2D> apply(Point2D start){
        List<Point2D> list = new ArrayList<Point2D>();
        for(int i=1; i< amount + 1; i++){
            int x = start.getX() + i*coefficients[0];
            int y = start.getY() + i*coefficients[1];
            list.add(new Point2D(x, y));
        }
        return list;
    }
}
