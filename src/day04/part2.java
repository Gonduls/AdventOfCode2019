package day04;

public class part2 {
    public static void main(String[] args) {
        int result = 0;
        for(int i = 273025; i < 767253; i++){
            if(isSuitable(i))
                result ++;
        }
        System.out.println(result);

    }

    static boolean isSuitable(int num){
        if(!part1.itGrows(num))
            return false;

        String s = Integer.toString(num);
        char c = s.charAt(0);
        int counter = 1;
        for(int i = 1; i<6; i++) {
            if(counter == 2 && s.charAt(i)!= c)
                break;
            if(s.charAt(i)!= c) {
                counter = 0; // should be 1 but is taken care of right after the if statement
                c = s.charAt(i);
            }
            counter ++;
        }
        return(counter == 2);
    }
}
