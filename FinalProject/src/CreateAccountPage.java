
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CreateAccountPage extends JFrame implements ActionListener {
	
    private JTextField usernameField;
    private JPasswordField passwordField;

    public CreateAccountPage() {
    	
        setTitle("Create Account");
        setBackground(Color.LIGHT_GRAY);
        setSize(300, 175);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(15, 20, 80, 25);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 170, 25);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(15, 60, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 60, 170, 25);
        panel.add(passwordField);

        JButton createButton = new JButton("Create");
        createButton.setBounds(15, 95, 125, 25);
        createButton.addActionListener(this);
        panel.add(createButton);

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(145, 95, 125, 25);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        add(panel);
        setVisible(true);
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

