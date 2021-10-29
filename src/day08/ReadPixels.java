package day08;

import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

// somewhat implementing Singleton pattern
public class ReadPixels {
    private static ReadPixels instance;
    private static FileReader fr;
    private List<Character> list = new LinkedList<>();

    private ReadPixels(FileReader fr){
        this.fr = fr;
    }
    public static ReadPixels instance(FileReader fr){
        if(instance == null)
            instance = new ReadPixels(fr);
        return instance;
    }

    public List<Character> readC() throws Exception{
        char c = (char) fr.read();
        while ( c != '\n'){
            list.add(c);
            c = (char) fr.read();
        }
        return list;
    }

}
