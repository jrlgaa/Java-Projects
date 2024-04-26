import javax.swing.*;

public class Average extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton compute;
    private JButton clear;
    private JLabel result;

    public Average() {
        setTitle("ADDITION");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel p1 = new JPanel();
        JLabel l1 = new JLabel("NUMBER 1: ");
        textField1 = new JTextField(20);
        p1.add(l1);
        p1.add(textField1);
        add(p1);

        JPanel p2 = new JPanel();
        JLabel l2 = new JLabel("NUMBER 2: ");
        textField2 = new JTextField(20);
        p2.add(l2);
        p2.add(textField2);
        add(p2);

        JPanel p4 = new JPanel();
        JLabel l3 = new JLabel("Result: ");
        result = new JLabel(); // Initialize result JLabel
        p4.add(l3);
        p4.add(result);
        add(p4);

        JPanel panel3 = new JPanel();
        compute = new JButton("Add");
        compute.addActionListener(e -> computeAverage());
        panel3.add(compute); 
        clear = new JButton("Clear");
        clear.addActionListener(e -> clearFields());
        panel3.add(clear);
        add(panel3);

        setSize(400,200);
        setVisible(true);
    }

    private void computeAverage() {
        try {
            double num1 = Double.parseDouble(textField1.getText());
            double num2 = Double.parseDouble(textField2.getText());
            double average = (num1 + num2);
            result.setText(" " + average);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Enter Valid Numbers ", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        textField1.setText("");
        textField2.setText("");
        result.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Average::new);
    }
}