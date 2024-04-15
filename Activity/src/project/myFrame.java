package project;

import java.awt.BorderLayout;
import javax.swing.*;

public class myFrame extends JFrame {
	
	private myButtons buttonsPanel;
	
	public myFrame() {
		
		buttonsPanel = new myButtons();
		this.add(buttonsPanel.getPanel(), BorderLayout.CENTER);
		this.setTitle("Click Button.");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(500,110);
	}
	
}
