package GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class myCalculator extends JFrame implements ActionListener {
    
    private JPanel panel;
    private JTextField num1Field, num2Field;
    private JLabel resultLabel;
    private JRadioButton addRadioButton, subtractRadioButton, multiplyRadioButton, divideRadioButton;
    private ButtonGroup operationGroup;

    public myCalculator() {

        panel = new JPanel();
        panel.setLayout(null);
        setTitle("Performance Task 2");
        panel.setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(300, 200);
        setLocationRelativeTo(null);
        add(panel);
        
        JLabel num1 = new JLabel("Number 1");
        num1.setFont(new Font("SansSerif",Font.TRUETYPE_FONT, 13));
        num1.setBounds(10, 10, 75, 25);
        panel.add(num1);
        
        num1Field = new JTextField();
        num1Field.setBounds(90, 10, 175, 25);
        panel.add(num1Field);
        
        JLabel num2 = new JLabel("Number 2");
        num2.setFont(new Font("SansSerif",Font.TRUETYPE_FONT, 13));
        num2.setBounds(10, 40, 75, 25);
        panel.add(num2);
        
        num2Field = new JTextField();
        num2Field.setBounds(90, 40, 175, 25);
        panel.add(num2Field);
        
        JLabel operationLabel = new JLabel("OPERATION");
        operationLabel.setFont(new Font("SansSerif",Font.TRUETYPE_FONT, 12));
        operationLabel.setBounds(10, 70, 80, 25);
        panel.add(operationLabel);

        addRadioButton = new JRadioButton(" +");
        addRadioButton.setFont(new Font("SansSerif",Font.TRUETYPE_FONT, 15));
        addRadioButton.setBackground(Color.WHITE);
        addRadioButton.setBounds(90, 70, 40, 25);
        panel.add(addRadioButton);
        
        subtractRadioButton = new JRadioButton(" -");
        subtractRadioButton.setFont(new Font("SansSerif",Font.TRUETYPE_FONT, 17));
        subtractRadioButton.setBackground(Color.WHITE);
        subtractRadioButton.setBounds(140, 70, 40, 25);
        panel.add(subtractRadioButton);
        
        multiplyRadioButton = new JRadioButton(" *");
        multiplyRadioButton.setFont(new Font("SansSerif",Font.TRUETYPE_FONT, 15));
        multiplyRadioButton.setBackground(Color.WHITE);
        multiplyRadioButton.setBounds(190, 70, 40, 25);
        panel.add(multiplyRadioButton);
        
        divideRadioButton = new JRadioButton(" /");
        divideRadioButton.setFont(new Font("SansSerif",Font.TRUETYPE_FONT, 13));
        divideRadioButton.setBackground(Color.WHITE);
        divideRadioButton.setBounds(235, 70, 40, 25);
        panel.add(divideRadioButton);
        
        operationGroup = new ButtonGroup();
        operationGroup.add(subtractRadioButton);
        operationGroup.add(multiplyRadioButton);
        operationGroup.add(divideRadioButton);
        operationGroup.add(addRadioButton);
        
        JButton calculateButton = new JButton("COMPUTE");
        calculateButton.setFont(new Font("SansSerif",Font.TRUETYPE_FONT, 13));
        calculateButton.setBackground(new Color(0xA8CEED));
        calculateButton.setBounds(10, 130, 110, 25);
        panel.add(calculateButton);
        calculateButton.addActionListener(this);
        
        JButton clearButton = new JButton("CLEAR");
        clearButton.setFont(new Font("SansSerif",Font.TRUETYPE_FONT, 13));
        clearButton.setBackground(new Color(0x64A2FA));
        clearButton.setBounds(150, 130, 110, 25);
        panel.add(clearButton);
        clearButton.addActionListener(this);

        resultLabel = new JLabel("RESULT : ");
        resultLabel.setFont(new Font("SansSerif",Font.TRUETYPE_FONT, 12));
        resultLabel.setBounds(10, 100, 270, 25);
        panel.add(resultLabel);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new myCalculator();
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.equals("COMPUTE")) {
            try {
                double num1 = Double.parseDouble(num1Field.getText());
                double num2 = Double.parseDouble(num2Field.getText());
                double result;
                
                if (addRadioButton.isSelected()) {
                    result = num1 + num2;
                } else if (subtractRadioButton.isSelected()) {
                    result = num1 - num2;
                } else if (multiplyRadioButton.isSelected()) {
                    result = num1 * num2;
                } else if (divideRadioButton.isSelected()) {
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(panel, "Can't divide by zero.");
                        return;
                    }
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(panel, "Select operation.");
                    return;
                }
                
                resultLabel.setText("RESULT: " + result);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(panel, "Invalid Input.");
            }
        } else if (command.equals("CLEAR")) {
            num1Field.setText("");
            num2Field.setText("");
            resultLabel.setText("RESULT: ");
            operationGroup.clearSelection();
        }
    }
}