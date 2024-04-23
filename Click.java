package Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Click implements ActionListener {
    private int clicks = 0;
    private JLabel label = new JLabel("Click Count:  0     ");
    private JFrame frame = new JFrame();
    private JButton resetButton;

    public Click() {
        JButton button = new JButton("Click Me!");
        button.addActionListener(this);
        
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        panel.add(resetButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Click and Reset Button.");
        frame.pack();
        frame.setSize(500, 250);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Click Me!")) {
            clicks++;
            label.setText("Click Counts:  " + clicks);
        } else if (e.getActionCommand().equals("Reset")) {
            clicks = 0;
            label.setText("Click Count: " + clicks);
        }
    }

    public static void main(String[] args) {
        new Click();
    }
}
