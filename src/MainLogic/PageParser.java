package MainLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PageParser {
    List<String> titleList;
    public PageParser(BufferedReader in, String WantedStr) {
        this.in = in;
        this.WantedStr = WantedStr;
    }
    private BufferedReader in;
    private String WantedStr;
    public String strAnalyz() throws IOException {

        String tmp;
        char[] array;
        List<String> list = new ArrayList<>();
        while((tmp = in.readLine()) != null){
            if(tmp.contains(WantedStr)){
                in.readLine();
                tmp =  in.readLine();
                array = tmp.toCharArray();
                String finaleStr;
                for (int i = tmp.indexOf("title") + 7; array[i]!='"'; i++){
                    list.add(String.valueOf(array[i]));
                }
                return list.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining());
            }
        }
        return null;
    }

}
