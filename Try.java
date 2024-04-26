package GUI;

import javax.swing.*;

public class Try extends JFrame {
	
    private JTextField Quarter3;
    private JTextField Quarter4;
    private JButton compute;
    private JButton clear;
    private JLabel result;
    private JPanel panel;

    public Try() {
    	
    	// Panel And Frame.
    	panel = new JPanel();
    	this.add(panel);
    	panel.setLayout(null);
        this.setTitle("Average");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300,200);
        this.setResizable(false);
        this.setVisible(true);
        
        
        // TextLabel and TextFeild for 3rd Quarter.
        JLabel label1 = new JLabel("3rd Quarter");
        label1.setBounds(10, 20, 80, 25);
        Quarter3 = new JTextField();
        Quarter3.setBounds(100, 20, 170, 25);
        panel.add(label1);
        panel.add(Quarter3);
        
        // TextLabel and TextFeild for 4th Quarter.
        JLabel label2 = new JLabel("4th Quarter");
        label2.setBounds(10, 50, 80, 25);
        Quarter4 = new JTextField();
        Quarter4.setBounds(100, 50, 170, 25);
        panel.add(label2);
        panel.add(Quarter4);
        
        // TextLabel for Average and Result.
        JLabel label3 = new JLabel("AVERAGE:  ");
        label3.setBounds(100, 80, 170, 25);
        result = new JLabel(); 
        result.setBounds(170, 80, 170, 25);
        panel.add(label3);
        panel.add(result);
        
        // Creating buttons for computing and clearing, setting their bounds.
        // Adding action listeners to execute corresponding methods.
        compute = new JButton("COMPUTE");
        compute.setBounds(50, 110, 95, 25);
        compute.addActionListener(e -> computeAverage());
        panel.add(compute);
        clear = new JButton("CLEAR");
        clear.setBounds(165, 110, 75, 25);
        clear.addActionListener(e -> clearFields());
        panel.add(clear);


    }

    private void computeAverage() {
    	
        try {
            // Parsing the text from Quarter3 field to a double
            double num1 = Double.parseDouble(Quarter3.getText());
            
            // Parsing the text from Quarter4 field to a double
            double num2 = Double.parseDouble(Quarter4.getText());
            
            // Calculating the average of the two numbers
            double average = (num1 + num2) / 2;
            
            // Displaying the average in the result text field
            result.setText("" + average);
        } catch (NumberFormatException ex) {
            // Showing an error message if invalid numbers are entered
            JOptionPane.showMessageDialog(this, "Enter Valid Numbers ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

 
    // Clears the Quarter3, Quarter4, and result text fields.
    private void clearFields() {
    	
        Quarter3.setText("");
        Quarter4.setText("");
        result.setText("");
    }

    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(Try::new);
    }
}