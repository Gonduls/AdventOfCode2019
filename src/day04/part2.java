package day04;

import java.util.List;

public class part2 {
    public static void main(String[] args) {
        int result = 0;
        for(int i = 273025; i < 767253; i++){
            if(part1.itGrows(i) && isSuitable(i))
                result ++;
        }
        System.out.println(result);

    }

    static boolean isSuitable(int num){
        String s = Integer.toString(num);
        char c = s.charAt(0);
        int counter = 1;
        for(int i = 1; i<6; i++) {
            if(counter == 2 && s.charAt(i)!= c)
                break;
            if(s.charAt(i)!= c) {
                counter = 0;
                c = s.charAt(i);
            }
            counter ++;
        }
        if(counter == 2)
            return true;
        return false;
    }
}
