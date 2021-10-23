package day01;

import java.io.File;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

public class part1 {
    public static void main(String[] args) {
        int result = 0;
        try {
            File input = new File("src/day01/input.txt");
            Scanner scanner = new Scanner(input);
            while(scanner.hasNextInt()){
                //System.out.println( scanner.nextInt());
                result += scanner.nextInt() / 3 - 2;
            }
            scanner.close();

        } catch(FileNotFoundException e) {
            System.out.println("Unable to open file.");
            //e.printStackTrace();
        }

        System.out.println(result);
    }
}
