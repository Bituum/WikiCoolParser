import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Downloader {
    public static BufferedReader down(){
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            URLParser.parseURL("https://ru.wikipedia.org/wiki/%D0%94%D0%B6%D0%B5%D0%BA_%D0%9B%D0%BE%D0%BD%D0%B4%D0%BE%D0%BD").openStream()));
            return in;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}