package MainLogic;

import java.net.MalformedURLException;
import java.net.URL;

public class URLParser {
    public static URL parseURL(String ref) throws MalformedURLException {
        return new URL(ref);
    }
}
