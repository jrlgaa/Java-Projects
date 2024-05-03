package GUI;

import java.awt.event.*;
import javax.swing.*;

public class GuiCalacu extends JFrame implements ActionListener {
    
    private JPanel panel;
    private JTextField num1Field, num2Field;
    private JLabel resultLabel;
    private JRadioButton addRadioButton, subtractRadioButton, multiplyRadioButton, divideRadioButton;
    private ButtonGroup operationGroup;

    public GuiCalacu() {

        panel = new JPanel();
        panel.setLayout(null);
        setTitle("Performance Task 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(300, 200);
        add(panel);
        
        JLabel num1 = new JLabel("Number 1:");
        num1.setBounds(10, 10, 75, 25);
        panel.add(num1);
        
        num1Field = new JTextField();
        num1Field.setBounds(90, 10, 175, 25);
        panel.add(num1Field);
        
        JLabel num2 = new JLabel("Number 2:");
        num2.setBounds(10, 40, 75, 25);
        panel.add(num2);
        
        num2Field = new JTextField();
        num2Field.setBounds(90, 40, 175, 25);
        panel.add(num2Field);
        
        JLabel operationLabel = new JLabel("OPERATION:");
        operationLabel.setBounds(10, 70, 80, 25);
        panel.add(operationLabel);

        addRadioButton = new JRadioButton("+");
        addRadioButton.setBounds(90, 70, 40, 25);
        panel.add(addRadioButton);
        
        subtractRadioButton = new JRadioButton("-");
        subtractRadioButton.setBounds(140, 70, 40, 25);
        panel.add(subtractRadioButton);
        
        multiplyRadioButton = new JRadioButton("*");
        multiplyRadioButton.setBounds(190, 70, 40, 25);
        panel.add(multiplyRadioButton);
        
        divideRadioButton = new JRadioButton("/");
        divideRadioButton.setBounds(240, 70, 40, 25);
        panel.add(divideRadioButton);
        
        operationGroup = new ButtonGroup();
        operationGroup.add(addRadioButton);
        operationGroup.add(subtractRadioButton);
        operationGroup.add(multiplyRadioButton);
        operationGroup.add(divideRadioButton);
        
        JButton calculateButton = new JButton("COMPUTE");
        calculateButton.setBounds(10, 130, 110, 25);
        panel.add(calculateButton);
        calculateButton.addActionListener(this);
        
        JButton clearButton = new JButton("CLEAR");
        clearButton.setBounds(150, 130, 110, 25);
        panel.add(clearButton);
        clearButton.addActionListener(this);

        resultLabel = new JLabel("RESULT: ");
        resultLabel.setBounds(10, 100, 360, 25);
        panel.add(resultLabel);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new GuiCalacu();
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.equals("Calculate")) {
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
                        JOptionPane.showMessageDialog(panel, "Division by zero error.");
                        return;
                    }
                    result = num1 / num2;
                } else {
                    JOptionPane.showMessageDialog(panel, "Select operation.");
                    return;
                }
                
                resultLabel.setText("RESULT: " + result);
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(panel, "Invalid Input");
            }
        } else if (command.equals("Clear")) {
            num1Field.setText("");
            num2Field.setText("");
            resultLabel.setText("RESULT: ");
            operationGroup.clearSelection();
        }
    }
}
