import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;


public class Main extends JPanel implements ActionListener{

    private int lastSavedVal = 0;

    public void ACbtnAction(ActionEvent e) {


    }

    public ActionExamplePanel() {
        super();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        JPanel outputScreen = new JPanel();
        JPanel inputPanel = new JPanel();

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setLayout(new GridLayout(2, 1));

        outputScreen.setBackground(Color.WHITE); // hex value for color
        frame.add(outputScreen);
        outputScreen.setLayout(new FlowLayout());
        inputPanel.setLayout(new GridLayout(0, 3));
        frame.add(inputPanel);


        //INPUT PANEL BUTTONS

        JButton CBtn = new JButton("C");
        inputPanel.add(CBtn);
        //*, /, -, +

        JButton Multiplybtn = new JButton("*");
        inputPanel.add(Multiplybtn);

        JButton Dividebtn = new JButton("/");
        inputPanel.add(Dividebtn);

        JButton Addbtn = new JButton("+");
        inputPanel.add(Addbtn);

        JButton Subtractbtn = new JButton("-");
        inputPanel.add(Subtractbtn);


        //buttons 1-9
        ArrayList<JButton> buttons = new ArrayList<>();

        for (int i = 0; i <= 9; i++) {
            JButton newButton = new JButton(Integer.toString(i));
            buttons.add(newButton);
            inputPanel.add(buttons.get(i));
        }

        JButton Periodbtn = new JButton(".");
        inputPanel.add(Periodbtn);

        JButton Squarebtn = new JButton("x^2");
        inputPanel.add(Periodbtn);

        JButton SquareRootbtn = new JButton("√");
        inputPanel.add(SquareRootbtn);



        //OUTPUT PANEL FIELD

        JTextField outputField = new JTextField(screen.width/10);
        //outputField.setEditable(true);
        outputScreen.add(outputField);

        //INPUT PANEL FUNCTIONALITY




        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, screen.width/3, screen.height/2);
        frame.setVisible(true);
    }
}