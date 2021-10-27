package day06;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReadStrings {
    static List<String> readLines(String input) throws Exception{
        List<String> list = new LinkedList<>();
        File file = new File(input);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            list.add(scanner.nextLine());

        }
        scanner.close();
        return list;
    }
}
