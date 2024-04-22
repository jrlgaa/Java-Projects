package Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickMe implements ActionListener {
    private int clicks = 0;
    private JLabel label;
    private JFrame frame = new JFrame();

    public ClickMe() {
        JButton button = new JButton("Click Me!");
        button.addActionListener(this);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clicks = 0;
                label.setText("Click Count: " + clicks);
            }
        });

        label = new JLabel("Click Count:  0     ");
        label.setBounds(10, 10, 200, 20); 

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(label);
        panel.add(resetButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI Button.");
        frame.pack();
        frame.setSize(500, 250);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        clicks++;
        label.setText("Click Count:  " + clicks);
    }

    public static void main(String[] args) {
        new ClickMe();
    }
}

