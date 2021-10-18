package day03;

/**
 * Class that completes 2D point by giving each point an order
 */
public class CardinalPoint2D extends Point2D{
    private int step;

    CardinalPoint2D(int x, int y, int step){
        super(x, y);
        this.step = step;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

}
