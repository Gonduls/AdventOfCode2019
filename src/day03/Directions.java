package day03;

/**
 * enum class for coefficients of movement in a 2D grid
 */
public enum Directions {
    R(1, 0), L(-1, 0), U(0, 1), D(0, -1);

    private final int coeffx;
    private final int coeffy;

    Directions(int x, int y){
        coeffx = x;
        coeffy = y;
    }

    public int[] getCoeff(){
        int[] result = {coeffx, coeffy};
        return result;
    }
}
