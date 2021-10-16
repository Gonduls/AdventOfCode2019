package day02;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Rules{
    static int a, b;

    static int Rule1(@NotNull List<Integer> list, Integer index){
        a = list.get(list.get(index + 1));
        b = list.get(list.get(index + 2));
        list.set(list.get(index + 3), a + b);
        return index + 4;
    }

    static int Rule2(@NotNull List<Integer> list, Integer index){
        a = list.get(list.get(index + 1));
        b = list.get(list.get(index + 2));
        list.set(list.get(index + 3), a * b);
        return index + 4;
    }
}

