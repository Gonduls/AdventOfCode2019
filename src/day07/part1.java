package day07;

import java.util.*;

public class part1 {
    public static void main(String[] args) {
        Permutations perms = new Permutations(5);
        Iterator itr = perms.iterator();
        int[] temp;
        int i = 0;
        while(itr.hasNext()) {
            temp = (int[]) itr.next();
            System.out.println(Arrays.toString(temp));
            i++;
        }
        System.out.println(i);
    }
}
