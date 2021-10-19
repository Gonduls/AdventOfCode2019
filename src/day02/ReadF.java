package day02;

import org.jetbrains.annotations.NotNull;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;

/**
 * Gives lists of input numbers
 */
public class ReadF {
    /**
     * Reads series of numbers divided by commas, ended in \n
     * @param input is string with path to input file
     * @return returns integer list through an arraylist
     * @throws Exception for file problems
     */
    public static @NotNull List<Integer> readInCommas(String input) throws Exception{
        List<Integer> list = new ArrayList<Integer>();
        char c;
        int i = 0;
        boolean negative = false;
        FileReader fr = new FileReader(input);
        do{
            c = (char) fr.read();
            if(c == ',' || c == '\n'){
                //System.out.println(i);
                if(negative){
                    i = - i;
                    negative = false;
                }
                list.add(i);
                i = 0;
                continue;
            }
            if(c == '-') {
                negative = true;
                continue;
            }
            i = i*10 + c - '0';

        }
        while ( c != '\n');
        fr.close();
        return list;
    }
}
