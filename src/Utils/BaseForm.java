package Utils;

import javax.swing.*;
import java.awt.*;

public abstract class BaseForm extends JFrame {
    public BaseForm()
    {
        setTitle("Search");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 600));
        setLocation(
                Toolkit.getDefaultToolkit().getScreenSize().width / 2 - getWidth()/2,
                Toolkit.getDefaultToolkit().getScreenSize().height / 2 - getHeight()/2
        );
        setVisible(true);
    }
    public abstract int getHeight();
    public abstract int getWidth();
}
