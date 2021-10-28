package day07;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Rules3 extends day05.Rules2{
    public static int Rule3(@NotNull List<Integer> list, int index, int input){
        list.set(list.get(index + 1), input);
        return index + 2;
    }

    public static int Rule4(@NotNull List<Integer> list, int index, int[] output){
        output[0] = setA(list, index);
        return index + 2;
    }
}
