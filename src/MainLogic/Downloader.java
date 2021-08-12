package MainLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Downloader {
    public static BufferedReader down(String CurrentName){
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            URLParser.parseURL("https://ru.wikipedia.org/wiki/" + CurrentName).openStream()));
            return in;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}