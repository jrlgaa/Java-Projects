package GUI;

import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import javax.swing.*;

public class Registration extends JFrame {

    private JPanel panel;
    private ButtonGroup genderGroup;
    private ButtonGroup strandGroup;
    private JTextField[] textFields;
    private JTextArea outputTextArea;

    public Registration() {
        panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));
        this.setTitle("Registration.");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setSize(600, 400);
        this.setResizable(false);

        JLabel[] labels = {new JLabel("First Name :"), new JLabel("Middle Name :"), new JLabel("Last Name :"), 
                            new JLabel("Gender :"), new JLabel("City :"), new JLabel("School :"), new JLabel("Strand :")};
        textFields = new JTextField[labels.length];
        for (int i = 0; i < labels.length; i++) {
            panel.add(labels[i]);
            if (i == 3) { // Gender
                JPanel genderPanel = new JPanel();
                JRadioButton maleRadioButton = new JRadioButton("Male");
                JRadioButton femaleRadioButton = new JRadioButton("Female");
                genderGroup = new ButtonGroup();
                genderGroup.add(maleRadioButton);
                genderGroup.add(femaleRadioButton);
                genderPanel.add(maleRadioButton);
                genderPanel.add(femaleRadioButton);
                panel.add(genderPanel);
            } else if (i == 6) { // Strand
                JPanel strandPanel = new JPanel();
                String[] strandOptions = {"ICT", "ABM", "EIM", "HUMS", "STEM"};
                JRadioButton[] strandRadioButtons = new JRadioButton[strandOptions.length];
                strandGroup = new ButtonGroup();
                for (int j = 0; j < strandOptions.length; j++) {
                    strandRadioButtons[j] = new JRadioButton(strandOptions[j]);
                    strandGroup.add(strandRadioButtons[j]);
                    strandPanel.add(strandRadioButtons[j]);
                }
                panel.add(strandPanel);
            } else {
                textFields[i] = new JTextField();
                panel.add(textFields[i]);
            }
        }

        JButton submitBTN = new JButton("SUBMIT");
        panel.add(submitBTN);

        JButton resetBTN = new JButton("RESET");
        panel.add(resetBTN);

        outputTextArea = new JTextArea(10, 30);
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        this.add(scrollPane, BorderLayout.SOUTH);

        submitBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder profile = new StringBuilder();
                profile.append("STUDENT PROFILE" + "\n");
                profile.append("First Name : " + textFields[0].getText() + "\n");
                profile.append("Middle Name: " + textFields[1].getText() + "\n");
                profile.append("Last Name  : " + textFields[2].getText() + "\n");
                profile.append("Gender: " + getSelectedButtonText(genderGroup) + "\n");
                profile.append("City  : " + textFields[4].getText() + "\n");
                profile.append("School: " + textFields[5].getText() + "\n");

                outputTextArea.append(profile.toString());
                outputTextArea.append("Strand: " + getSelectedButtonText(strandGroup) + "\n");

                clearFields();
            }
        });

        resetBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
                outputTextArea.setText("");
            }
        });
    }

    private String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "";
    }

    private void clearFields() {
        for (int i = 0; i < textFields.length; i++) {
            if (textFields[i] != null) {
                textFields[i].setText("");
            }
        }
        if (genderGroup != null) {
            genderGroup.clearSelection();
        }
        if (strandGroup != null) {
            strandGroup.clearSelection();
        }
    }

    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Registration registration = new Registration();
                registration.setVisible(true);
            }
        });
    }
}