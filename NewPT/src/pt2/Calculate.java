package pt2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculate extends JFrame implements ActionListener { 
	
	private JPanel panel;
	private JTextField lengthTF, widthTF;
	private JLabel resultArea, perimeter;
	
	public Calculate() {
		
    	panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0xA7CBD4));
        setTitle("Area and Perimeter of rectangle.");
        setSize(355, 260);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(panel);
        
        JLabel lengthLabel = new JLabel("Enter the Length");
        lengthLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        lengthLabel.setBounds(10, 20, 100, 25);
        panel.add(lengthLabel);
        
        lengthTF = new JTextField();
        lengthTF.setBounds(120, 20, 170, 25);
        panel.add(lengthTF);
        
        JLabel widthLabel = new JLabel("Enter the Width");
        widthLabel.setFont(new Font("SansSerif", Font.PLAIN, 13));
        widthLabel.setBounds(10, 70, 100, 25);
        panel.add(widthLabel);
        
        widthTF = new JTextField();
        widthTF.setBounds(120, 70, 170, 25);
        panel.add(widthTF);
        
        resultArea = new JLabel("Result area: ");
        resultArea.setFont(new Font("SansSerif", Font.PLAIN, 13));
        resultArea.setBounds(120,  110, 200, 25);
        panel.add(resultArea);
        
        perimeter = new JLabel("Perimeter: ");
        perimeter.setFont(new Font("SansSerif", Font.PLAIN, 13));
        perimeter.setBounds(120,  140, 200, 25);
        panel.add(perimeter);
        
        JButton calculateBTN = new JButton("Calculate");
        calculateBTN.setFont(new Font("SansSerif", Font.TRUETYPE_FONT, 13));
        calculateBTN.setBackground(Color.WHITE);
        calculateBTN.setBounds(25, 180, 100, 25);
        calculateBTN.addActionListener(this);
        panel.add(calculateBTN);
        
        JButton exitBTN = new JButton("EXIT");
        exitBTN.setFont(new Font("SansSerif", Font.TRUETYPE_FONT, 13));
        exitBTN.setBackground(Color.WHITE);
        exitBTN.setBounds(180, 180, 100, 25);
        exitBTN.addActionListener(e -> System.exit(0));
        panel.add(exitBTN);
        
        setVisible(true);		
	}
	

	public static void main(String[] args) {
		
		new Calculate();
		
	}

	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if (command.equals("Calculate")) {
			
			try {
				
				double length = Double.parseDouble(lengthTF.getText());
				double width = Double.parseDouble(widthTF.getText());
				
				double area = length * width;
				double perimeterValue = 2 * (length + width);
				
				resultArea.setText("Result area: " + area);
				perimeter.setText("Perimeter: " + perimeterValue);
				
			} catch (NumberFormatException ex) {
				
				JOptionPane.showMessageDialog(panel, "Please enter valid numbers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
