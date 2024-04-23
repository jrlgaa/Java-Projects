import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyGUI implements ActionListener {

    private int clickCounts = 0;
    private JLabel label = new JLabel("Click Count: 0");
    private JFrame frame = new JFrame();

    MyGUI() {
        JButton button = new JButton("Click Me!");
        button.addActionListener(this);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickCounts = 0;
                label.setText("Click Count: " + clickCounts);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.add(button);
        panel.add(Box.createRigidArea(new Dimension(20, 0))); 
        panel.add(resetButton);
        panel.add(Box.createRigidArea(new Dimension(20, 0))); 
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Click Counter.");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        clickCounts++;
        label.setText("Click Counts: " + clickCounts);
    }

    public static void main(String[] args) {
        new MyGUI();
    }
}
