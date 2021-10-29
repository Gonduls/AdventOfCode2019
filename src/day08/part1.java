package day08;

import java.io.FileReader;
import java.util.List;

public class part1 {
    public static void main(String[] args) {
        List<Character> input;
        int fewestZ = Integer.MAX_VALUE;
        int answer = 0;
        try{
            FileReader fr = new FileReader("src/day08/input.txt");
            ReadPixels instance = ReadPixels.instance(fr);
            input = instance.readC();
        }catch(Exception e){
            System.out.println(e.getStackTrace() + "\nException related to input, ending program");
            return;
        }

        char[] str =  new char[150];

        // totally unnecessary usage of class, made because I didn't know what part 2 would have been
        // could just count occurrences and act upon that
        for(int i = 0; i < input.size(); i ++){ // 150 = 25 * 6 pixels in a range
            str[i % 150] = input.get(i);
            if((i+1)%150 == 0){
                Layer layer = new Layer(str);
                if(layer.countChar('0') < fewestZ){
                    fewestZ = layer.countChar('0');
                    answer = layer.countChar('1') * layer.countChar('2');
                }
            }
        }
        System.out.println(answer);
    }
}
