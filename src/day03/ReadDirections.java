package day03;

import org.jetbrains.annotations.NotNull;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadDirections {
    static @NotNull List<String> readInCommas(FileReader fr) throws Exception{
        List<String> list = new ArrayList<String>();
        char c;
        String s = new String();
        do{
            c = (char) fr.read();
            if(c == ',' || c == '\n'){
                //System.out.println(i);
                list.add(s);
                s = new String();
                continue;
            }
            s += c;

        }
        while ( c != '\n');
        return list;
    }
}
