package day08;

// totally not necessary class to complete day 8, created not knowing what part2 would ask
public class Layer {
    private final char[] pixels;

    public Layer(char[] pixels){
        this.pixels = pixels;
    }

    public int countChar(char c){
        int result = 0;
        for (char pixel : pixels)
            result += pixel == c ? 1 : 0;

        return result;
    }
}
