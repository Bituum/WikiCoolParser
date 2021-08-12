package UI;

import MainLogic.Downloader;
import MainLogic.PageParser;
import Utils.BaseForm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainForm extends JFrame {
    private Box MainBox, firstbox, secondbox;
    private JLabel label1;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton SearchButton;
    JToolBar MenuBar;
    public MainForm(){
        super("Справка");
        Font font = new Font("sans comic", Font.BOLD, 16);
        label1 = new JLabel("Поиск");
        label1.setFont(font);
        MainBox = Box.createVerticalBox();
        firstbox = Box.createHorizontalBox();
        secondbox = Box.createHorizontalBox();
        MenuBar = new JToolBar();
        SearchButton = new JButton("найти");
        textField1 = new JTextField();
        textArea1 = new JTextArea();
        firstbox.setMaximumSize(new Dimension(1000, 30));
        firstbox.add(textField1);
        firstbox.add(Box.createHorizontalStrut(6));
        firstbox.add(SearchButton);
        secondbox.add(textArea1);
        MainBox.add(label1);
        MainBox.add(Box.createVerticalStrut(6));
        MainBox.add(firstbox);
        MainBox.add(Box.createVerticalStrut(6));
        MainBox.add(secondbox);
        setContentPane(MainBox);
        pack();
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        SearchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PageParser result = new PageParser(
                        Downloader.down(),
                        textField1.getText()
                );
                try {
                    textArea1.setText(result.strAnalyz());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }});
    }
}
