package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class myButtons implements ActionListener {
	
	private int clickCount = 0;
	private JLabel label;
	private JButton button;
	private JButton resetButton;
	private JPanel panel;
	
	public myButtons() {
		
        label = new JLabel(" Number of Click:    0");
		button = new JButton("Click Me!");
		button.addActionListener(this);
		
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickCount = 0;
				label.setText(" Number of Count: " + clickCount);
			}
		});

		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(1, 1));
		panel.add(button);
		panel.add(resetButton);
		panel.add(label);

	}
	
	public JPanel getPanel() {
		return panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		clickCount ++;
		label.setText(" Number of Counts: " + clickCount);

	}
	

}
