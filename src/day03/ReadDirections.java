package day03;

import org.jetbrains.annotations.NotNull;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadDirections {
    /**
     * reads list of strings divided by commas and ended by '\n' provided an open input stream, does not close input stream
     * @param fr: open FileReader
     * @return List of Strings
     * @throws Exception for file problems
     */
    static @NotNull List<String> readStringsInCommas(@NotNull FileReader fr) throws Exception{
        List<String> list = new ArrayList<>();
        char c;
        StringBuilder s = new StringBuilder();
        do{
            c = (char) fr.read();
            if(c == ',' || c == '\n'){
                //System.out.println(i);
                list.add(s.toString());
                s = new StringBuilder();
                continue;
            }
            s.append(c);

        }
        while ( c != '\n');
        return list;
    }
}
