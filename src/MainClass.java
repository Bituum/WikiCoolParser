import java.io.IOException;

public class MainClass {
    public static void main(String[] args) throws IOException {
        PageParser result = new PageParser(
                Downloader.down(),
                "Место рождения"
        );
        System.out.println(result.strAnalyz());
    }
}
