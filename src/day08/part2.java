package day08;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class part2 {
    public static void main(String[] args) {
        List<Character> input;
        char[] picture  = new char[150];
        try{
            FileReader fr = new FileReader("src/day08/input.txt");
            ReadPixels instance = ReadPixels.instance(fr);
            input = instance.readC();
        }catch(Exception e){
            System.out.println(e.getStackTrace() + "\nException related to input, ending program");
            return;
        }

        // fill every char with '2', ' ' or '█' to print somewhat easily readable answer;
        for (int i = 0; i < 150; i++)
            picture[i] = input.get(i) == '2' ?  '2' : (input.get(i) == '0' ?  ' ' : '█');

        for (int i = 150; i < input.size(); i++){
            if(picture[i % 150] == '2')
                picture[i % 150] =  input.get(i) == '2' ?  '2' : (input.get(i) == '0' ?  ' ' : '█');
        }

        for (int i = 0; i <6; i++){
            System.out.println(String.valueOf(Arrays.copyOfRange(picture, i * 25, (1 + i) * 25)));
        }
    }
}
