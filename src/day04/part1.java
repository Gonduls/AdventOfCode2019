package day04;

public class part1 {
    public static void main(String[] args) {
        int result = 0;
        for(int i = 273025; i < 767253; i++){
            if(itGrows(i) && HasDouble(i))
                result ++;
        }
        System.out.println(result);
    }

    static boolean HasDouble(int num){
        String s = Integer.toString(num);
        for(int i = 1; i<6; i++)
            if(s.charAt(i) == s.charAt(i-1))
                return true;
        return false;
    }

    static boolean itGrows(int num){
        String s = Integer.toString(num);
        for(int i = 1; i<6; i++) {
            if (s.charAt(i) < s.charAt(i - 1))
                return false;
        }
        return true;
    }
}
