package day03;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that completes 2D movement by giving each point their cardinal number
 */
public class CardinalMovement extends Movement{
    public CardinalMovement(@NotNull String string){
        super(string);
    }

    /**
     * extends 2d movement by also setting step in which 2D point is reached
     * @param start like super
     * @param step  at the start of movement
     * @return List of cardinal 2D points
     */
    public List<CardinalPoint2D> apply(Point2D start, int step){
        List<CardinalPoint2D> list = new ArrayList<CardinalPoint2D>();
        for(int i=1; i< super.amount + 1; i++){
            int x = start.getX() + i*super.coefficients[0];
            int y = start.getY() + i*super.coefficients[1];
            list.add(new CardinalPoint2D(x, y, step + i));
        }
        return list;
    }
}
