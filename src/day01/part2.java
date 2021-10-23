package day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class part2 {
    public static void main(String[] args) {
        int result = 0;
        try {
            File input = new File("src/day01/input.txt");
            Scanner scanner = new Scanner(input);
            while(scanner.hasNextInt()){
                //System.out.println( scanner.nextInt());
                result += totalFuel(scanner.nextInt());
            }
            scanner.close();

        } catch(FileNotFoundException e) {
            System.out.println("Unable to open file.");
            //e.printStackTrace();
        }

        System.out.println(result);
    }

    static private int totalFuel(int x){ // had to be static in order to be accessible from static main
        if (x<6)
            return 0;
        int result = x/3 -2;
        return(result + totalFuel(result));
    }
}
