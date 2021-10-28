package day05;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Scanner;

public class Rules2 extends day02.Rules{
    static int a, b, c;

    static public int Rule1(@NotNull List<Integer> list, Integer index){
        a = setA(list, index);
        b = setB(list, index);
        list.set(list.get(index + 3), a + b);
        return index + 4;
    }

    static public int Rule2(@NotNull List<Integer> list, Integer index){
        a = setA(list, index);
        b = setB(list, index);
        list.set(list.get(index + 3), a * b);
        return index + 4;
    }

    static public int Rule3(@NotNull List<Integer> list, Integer index){
        System.out.println("Insert input number: ");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();
        list.set(list.get(index + 1), answer);
        return index + 2;
    }

    static public int Rule4(@NotNull List<Integer> list, Integer index){
        System.out.println("Output number: " + setA(list, index));
        return index + 2;
    }

    static public int Rule5(@NotNull List<Integer> list, Integer index){
        a = setA(list, index);
        b = setB(list, index);
        if(a != 0)
            return b;
        return index + 3;
    }

    static public int Rule6(@NotNull List<Integer> list, Integer index){
        a = setA(list, index);
        b = setB(list, index);
        if(a == 0)
            return b;
        return index + 3;
    }

    static public int Rule7(@NotNull List<Integer> list, Integer index){
        a = setA(list, index);
        b = setB(list, index);
        c = setC(list, index);
        list.set(c, 0);
        if(a < b)
            list.set(c, 1);
        return index + 4;
    }

    static public int Rule8(@NotNull List<Integer> list, Integer index){
        a = setA(list, index);
        b = setB(list, index);
        c = setC(list, index);
        list.set(c, 0);
        if(a == b)
            list.set(c, 1);
        return index + 4;
    }

    static public int setA(@NotNull List<Integer> list, Integer index){
        int command = list.get(index);
        command = command/100;
        if(command % 10 == 1)
            return list.get(index + 1);
        return(list.get(list.get(index + 1)));
    }
    static public int setB(@NotNull List<Integer> list, Integer index){
        int command = list.get(index);
        command = command/1000;
        if(command % 10 == 1)
            return list.get(index + 2);
        return(list.get(list.get(index + 2)));
    }
    static public int setC(@NotNull List<Integer> list, Integer index){
        return list.get(index + 3);
    }

}
