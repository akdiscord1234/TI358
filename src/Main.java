import java.awt.*;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("FRAME TITLE");
        JPanel outputScreen = new JPanel();
        JPanel inputPanel = new JPanel();

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setLayout(new GridLayout(2, 1));

        outputScreen.setBackground(Color.WHITE);
        frame.add(outputScreen);
        inputPanel.setLayout(new GridLayout(4, 3));
        frame.add(inputPanel);


        //adding components

        JButton oneBtn = new JButton("1");




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, screen.width/3, screen.height/2);
        frame.setVisible(true);
    }
}