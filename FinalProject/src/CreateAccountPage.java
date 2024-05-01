
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CreateAccountPage extends JFrame implements ActionListener {
	
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel panel;
    public CreateAccountPage() {
    	
    	
    	ImageIcon icon = new ImageIcon("C:\\Users\\lenovo\\eclipse-workspace\\FinalProject\\src\\innovation.png");
    	this.setIconImage(icon.getImage());
    	panel = new JPanel();
    	panel.setLayout(null);
        panel.setBackground(new Color(0xBCD3F5));        
        this.setTitle("Create Account");
        this.setSize(300, 175);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(panel);
        this.setVisible(true);
         
    

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("SansSerif", Font.TRUETYPE_FONT, 14));
        usernameLabel.setBounds(15, 20, 80, 25);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 170, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("SansSerif", Font.TRUETYPE_FONT, 14));
        passwordLabel.setBounds(15, 60, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 60, 170, 25);
        panel.add(passwordField);

        JButton createButton = new JButton("Create");
        createButton.setBackground(new Color(0x5BA6E3));
        createButton.setFont(new Font("SansSerif", Font.BOLD, 12));
        createButton.setBounds(15, 95, 125, 25);
        createButton.addActionListener(this);
        panel.add(createButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground(new Color(0x5BA6E3));
        cancelButton.setFont(new Font("SansSerif", Font.BOLD, 12));
        cancelButton.setBounds(145, 95, 125, 25);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);


    }

    private void createAccount(String username, String password) {
        try (FileWriter fw = new FileWriter("accounts.txt", true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(username + "," + password);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to accounts file: " + e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Create")) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Enter Username and Password.", "Invalid input",
                                              JOptionPane.PLAIN_MESSAGE);
                return;
            }
            
            
            createAccount(username, password);
            JOptionPane.showMessageDialog(this, "Account created successfully!");
            dispose();
        } else if (e.getActionCommand().equals("Cancel")) {
            dispose();
        }
    }
}

