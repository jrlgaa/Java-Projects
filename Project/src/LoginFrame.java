
import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
	
    private JTextField usernameField = new JTextField(20);
    private JPasswordField passwordField = new JPasswordField(20);
    private JButton loginButton = new JButton("Login");
    private JButton registerButton = new JButton("Register");
    private UserManager userManager = new UserManager();

    public LoginFrame() {
    	
    	super("Login or Register");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null); 
        setResizable(false);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 650, 600);
        panel.setBackground(new Color(0x709CC2));
        
        JLabel gameTitle = new JLabel("WELCOME TO SNAKE GAME");
        gameTitle.setBounds(5, 30, 480, 100);
        gameTitle.setFont(new Font("SansSerif", Font.ITALIC, 24)); 
        gameTitle.setHorizontalAlignment(JLabel.CENTER); 
        panel.add(gameTitle);

        
        JLabel userNameLabel = new JLabel("Username");
        userNameLabel.setFont(new Font("SansSerif", Font.TRUETYPE_FONT, 13));
        userNameLabel.setBounds(100, 150, 100, 25);
        usernameField.setBounds(180, 150, 200, 25);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("SansSerif", Font.TRUETYPE_FONT, 13));
        passwordLabel.setBounds(100, 200, 100, 25);
        passwordField.setBounds(180, 200, 200, 25);
        
        JLabel or = new JLabel("-OR-");
        or.setFont(new Font("SansSerif", Font.TRUETYPE_FONT, 13));
        or.setBounds(228, 250, 95, 25);
        panel.add(or);

        loginButton.setBounds(100, 250, 95, 25);
        loginButton.setFont(new Font("SansSerif", Font.TRUETYPE_FONT, 13));
        registerButton.setBounds(285, 250, 95, 25);
        registerButton.setFont(new Font("SansSerif", Font.TRUETYPE_FONT, 13));

        panel.add(userNameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(registerButton);

        this.add(panel);
        
        loginButton.addActionListener(e -> login());
        registerButton.addActionListener(e -> register());

        this.setVisible(true);
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (userManager.loginUser(username, password)) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
            EventQueue.invokeLater(() -> {
                JFrame frame = new GameFrame();
                frame.setVisible(true);
            });
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials!");
        }
    }

    private void register() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (userManager.registerUser(username, password)) {
            JOptionPane.showMessageDialog(this, "Registration Successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Username already exists!");
        }
    }
}
