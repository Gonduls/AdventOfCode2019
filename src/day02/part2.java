package day02;

import java.util.ArrayList;
import java.util.List;

public class part2 {
    public static void main(String[] args) {
        List<Integer> list;
        try {
            list = ReadF.readInCommas("src/day02/input.txt");
        }catch(Exception e){
            System.out.println("input problems, ending program");
            return;
        }
        for (int i = 0; i< 100; i++){
            for (int j = 0; j< 100; j++){
                List<Integer> test = new ArrayList<>(list);
                test.set(1, i);
                test.set(2, j);
                IntcodeManager manager = new IntcodeManager(test);
                try{
                    manager.play();
                }catch(Exception e){
                    System.out.println(e + ", ending program");
                    return;
                }
                if(test.get(0) == 19690720){
                    System.out.println("Result = " + (100 * test.get(1) + test.get(2)));
                    return;
                }
            }
        }
    }

}
