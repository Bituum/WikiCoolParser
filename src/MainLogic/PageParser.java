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
    private List<String> titleList;
    public PageParser(BufferedReader in) {
        this.in = in;
        this.WantedStr = WantedStr;
    }
    private BufferedReader in;
    private String WantedStr;
    private String StrDetect = "th scope=\"row\" class=\"plainlist\"";
    private List<String> KeyList = new ArrayList<>();;
    private List<String> ValueList = new ArrayList<>();;
    private List<List<String>> FinallyResult = new ArrayList<>();;
    public List<List<String>> strAnalyz() throws IOException {
        String tmp;
        char[] array;
        while((tmp = in.readLine()) != null){
            if(tmp.contains(StrDetect) && !tmp.contains("<a href=")){
                List<String> checkingbox = new ArrayList<>();
                List<String> list = new ArrayList<>();
                for(int i = tmp.indexOf('>') + 1; i< tmp.indexOf('/')-1; i++)
                {
                    checkingbox.add(String.valueOf(tmp.toCharArray()[i]));
                }
                String test = checkingbox.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining());
                KeyList.add(test);
                in.readLine();
                tmp =  in.readLine();
                array = tmp.toCharArray();
                for (int i = tmp.indexOf("title") + 7; i<tmp.length() && array[i] != '"' && array[i] != '»'; i++){
                    if((array[i]>='A' && array[i]<='Z') || (array[i]>='a' && array[i]<='z'))
                    {
                        break;
                    }
                    list.add(String.valueOf(array[i]));
                }
                ValueList.add(list.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining()));
            }
        }
        FinallyResult.add(KeyList);
        FinallyResult.add(ValueList);
        return FinallyResult;
    }

}
