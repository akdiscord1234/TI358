import java.awt.*;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;


public class Calculator extends JPanel {

    private double result;
    private double currentInput;
    private char lastOperator;
    private boolean isNewEntry = false;


    private JButton Cbtn, MultiplyBtn, DivideBtn, AddBtn, SubtractBtn, EqualsBtn;
    private ArrayList<JButton> number = new ArrayList<JButton>();
    private JTextField outputField;


    public Calculator() {

        super();

        result = 0;
        currentInput = 0;
        lastOperator = ' ';
        isNewEntry = true;


        //layout setup for window
        this.setLayout(new GridLayout(0, 1));

        //create internal panels
        JPanel outputPanel = new JPanel();
        JPanel inputPanel = new JPanel();


        inputPanel.setLayout(new GridLayout(0, 3)); //layout setup for inputPanel
        outputPanel.setLayout(new FlowLayout()); //layout setup for outputPanel



        //initialize and add buttons to inputPanel

        //clear
        Cbtn = new JButton("C");
        Cbtn.addActionListener(new CbtnListener());
        inputPanel.add(Cbtn);
        //multliply
        MultiplyBtn = new JButton("*");
        MultiplyBtn.addActionListener(new MultiplybtnListener());
        inputPanel.add(MultiplyBtn);

        AddBtn = new JButton("+");
        AddBtn.addActionListener(new AddbtnListener());
        inputPanel.add(AddBtn);

        SubtractBtn = new JButton("-");
        SubtractBtn.addActionListener(new SubtractbtnListener());
        inputPanel.add(SubtractBtn);

        DivideBtn = new JButton("/");
        DivideBtn.addActionListener(new DividebtnListener());
        inputPanel.add(DivideBtn);

        for (int i = 0; i <= 9; i++) {
            number.add(new JButton(Integer.toString(i)));
            number.get(i).addActionListener(new NumberBtnListener(i));
            inputPanel.add(number.get(i));
        }

        EqualsBtn = new JButton("=");
        EqualsBtn.addActionListener(new EqualsBtnListener());
        inputPanel.add(EqualsBtn);



        //output screen configuration
        outputField = new JTextField("0", 20);
        outputField.setEditable(false);
        outputPanel.add(outputField);


        this.add(outputPanel);
        this.add(inputPanel);

    }

    private void calculate(double number) {
        if (lastOperator == '+') {
            result += number;
        }
        else if (lastOperator == '-') {
            result -= number;
        }
        else if (lastOperator == '*') {
            result *= number;
        }
        else if (lastOperator == '/') {

            if (number != 0) {
                result /= number;
            }
            else {
                outputField.setText("DIVIDE BY ZERO ERROR");
                return;
            }
        }
        else {
            result = number;
        }
        outputField.setText(Double.toString(result));
    }

    private class CbtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CBtnFunction();
        }
    }

    private void CBtnFunction () {
        result = 0;
        currentInput = 0;
        lastOperator = ' ';
        isNewEntry = true;

        outputField.setText("MEMORY CLEARED");
    }


    private class AddbtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            AddBtnFunction();
        }
    }

    private void AddBtnFunction() {
        if (!isNewEntry) {
            calculate(currentInput);
        }

        lastOperator = '+';
        isNewEntry = true;
    }


    private class SubtractbtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            SubtractBtnFunction();

        }
    }

    private void SubtractBtnFunction() {
        if (!isNewEntry) {
            calculate(currentInput);
        }
        lastOperator = '-';
        isNewEntry = true;
    }

    private class MultiplybtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            MultiplyBtnFunction();
        }
    }

    private void MultiplyBtnFunction () {
        if (!isNewEntry) {
            calculate(currentInput);
        }
        lastOperator = '*';
        isNewEntry = true;
    }

    private class DividebtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            DivideBtnFunction();

        }
    }

    private void DivideBtnFunction() {
        if (!isNewEntry) {
            calculate(currentInput);
        }
        lastOperator = '/';
        isNewEntry = true;
    }

    private class NumberBtnListener implements ActionListener {

        private int number;

        public NumberBtnListener (int num) {
            this.number = num;
        }

        public void actionPerformed(ActionEvent e) {
            NumberBtnFunction(number);
        }


    }

    private void NumberBtnFunction(int number) {
        if (isNewEntry) {
            currentInput = number;
            isNewEntry = false;
        }
        else {
            currentInput = (currentInput * 10) + number;
        }
        outputField.setText(Double.toString(currentInput));
    }

    private class EqualsBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            EqualsBtn();

        }
    }

    public void EqualsBtn() {
        calculate(currentInput);
        lastOperator = ' ';
        isNewEntry = true;

    }




    public void keyPressed(KeyEvent e) {
        char command = e.getKeyChar();

        if (command == 'c' || command == 'C') {
            CBtnFunction();
        }
        else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            EqualsBtn();
        }
        else if (command == '1') {
            NumberBtnFunction(1);
        }
        else if (command == '2') {
            NumberBtnFunction(2);
        }
        else if (command == '3') {
            NumberBtnFunction(3);
        }
        else if (command == '4') {
            NumberBtnFunction(4);
        }
        else if (command == '5') {
            NumberBtnFunction(5);
        }
        else if (command == '6') {
            NumberBtnFunction(6);
        }
        else if (command == '7') {
            NumberBtnFunction(7);
        }
        else if (command == '8') {
            NumberBtnFunction(8);
        }
        else if (command == '9') {
            NumberBtnFunction(9);
        }
        else if (command == '0') {
            NumberBtnFunction(0);
        }
        else if (command == '*') {
            MultiplyBtnFunction();
        }
        else if (command == '/') {
            DivideBtnFunction();
        }
        else if (command == '+') {
            AddBtnFunction();
        }
        else if (command == '-') {
            SubtractBtnFunction();
        }
        else {
            return;
        }
        System.out.println(command);
    }


    public void keyReleased(KeyEvent e) {

    }


    public void keyTyped(KeyEvent e) {

    }



    public static void main(String[] args) {


        JFrame frame = new JFrame("Calculator");

        Calculator calc = new Calculator();
        frame.add(calc);

        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, screen.width/3, screen.height/2);
        frame.setVisible(true);


    }
}