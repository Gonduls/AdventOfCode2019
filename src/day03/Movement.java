package day03;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Movement {
    //private final char direction;
    private final int amount;
    private final int[] coefficients;

    public Movement(@NotNull String string){
        //direction = string.charAt(0);
        amount = Integer.parseInt(string.substring(1));
        coefficients = Directions.valueOf(string.substring(0,1)).getCoeff();
        //System.out.println("Movement = "+ direction + " " + amount);
    }

    public List<Point2D> apply(Point2D start){
        List<Point2D> list = new ArrayList<Point2D>();
        for(int i=1; i< amount + 1; i++){
            int x = start.getX() + i*coefficients[0];
            int y = start.getX() + i*coefficients[1];
            list.add(new Point2D(x, y));
        }
        return list;
    }
}
