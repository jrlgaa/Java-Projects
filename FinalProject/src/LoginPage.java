
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class LoginPage extends JFrame implements ActionListener {
	
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginPage() {
    	
        setTitle("Login");
        setBackground(Color.LIGHT_GRAY);
        setSize(300, 175);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(15, 95, 125, 25);
        loginButton.addActionListener(this);
        panel.add(loginButton);

        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(145, 95, 125, 25);
        createAccountButton.addActionListener(this);
        panel.add(createAccountButton);

        add(panel);
        setVisible(true);
    }

    private boolean validateLogin(String username, char[] password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("accounts.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] credentials = line.split(",");
                if (credentials[0].equals(username) && credentials[1].equals(new String(password))) {
                    return true;
                } 
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading from accounts file: " + e.getMessage());
        }
        return false;
    }

	public void actionPerformed(ActionEvent e) {
		String username = usernameField.getText();
		char[] password = passwordField.getPassword();

		if (e.getActionCommand().equals("Login")) {
			if (validateLogin(username, password)) {
				JOptionPane.showMessageDialog(this, "Login successful!");
				dispose();
				new Registration();
			} else {

				JOptionPane.showMessageDialog(this, "Incorrect username or password.");
			}
		} else if (e.getActionCommand().equals("Create Account")) {
			new CreateAccountPage();
		}
	}
}
