import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Registration extends JFrame {

    private JPanel panel;
    private JTextArea outputTextArea;
    private static JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup genderGroup;
    private static JRadioButton ictRadioButton;
    private static JRadioButton abmRadioButton;
    private static JRadioButton eimRadioButton;
    private static JRadioButton humsRadioButton;
    private static JRadioButton stemRadioButton;
    private ButtonGroup strandGroup;

    public Registration() {
        panel = new JPanel();
        panel.setLayout(null);
        this.setTitle("ENROLLEMENT FORM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setResizable(false);
        this.setSize(450, 650);
        this.setVisible(true);

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        scrollPane.setBounds(30, 280, 370, 270);
        panel.add(scrollPane);
        
        JLabel GenderLabel = new JLabel("Select Gender :");
        GenderLabel.setBounds(10, 110, 100, 25);
        panel.add(GenderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBounds(100, 110, 80, 25);
        panel.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBounds(200, 110, 80, 25);
        panel.add(femaleRadioButton);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JLabel strandLabel = new JLabel("Select Strand :");
        strandLabel.setBounds(10, 210, 100, 25);
        panel.add(strandLabel);

        ictRadioButton = new JRadioButton("ICT");
        ictRadioButton.setBounds(100, 210, 60, 25);
        panel.add(ictRadioButton);

        abmRadioButton = new JRadioButton("ABM");
        abmRadioButton.setBounds(160, 210, 60, 25);
        panel.add(abmRadioButton);

        eimRadioButton = new JRadioButton("EIM");
        eimRadioButton.setBounds(220, 210, 60, 25);
        panel.add(eimRadioButton);

        humsRadioButton = new JRadioButton("HUMS");
        humsRadioButton.setBounds(280, 210, 70, 25);
        panel.add(humsRadioButton);

        stemRadioButton = new JRadioButton("STEM");
        stemRadioButton.setBounds(350, 210, 70, 25);
        panel.add(stemRadioButton);

        strandGroup = new ButtonGroup();
        strandGroup.add(ictRadioButton);
        strandGroup.add(abmRadioButton);
        strandGroup.add(eimRadioButton);
        strandGroup.add(humsRadioButton);
        strandGroup.add(stemRadioButton);
    }

    public static void main(String[] args) {
        Registration registration = new Registration();

        JLabel FNlabel = new JLabel("First Name :");
        FNlabel.setBounds(10, 20, 80, 25);
        registration.panel.add(FNlabel);
        JTextField fnTF = new JTextField();
        fnTF.setBounds(100, 20, 170, 25);
        registration.panel.add(fnTF);

        JLabel MNlabel = new JLabel("Middle Name :");
        MNlabel.setBounds(10, 50, 80, 25);
        registration.panel.add(MNlabel);
        JTextField mnTF = new JTextField();
        mnTF.setBounds(100, 50, 170, 25);
        registration.panel.add(mnTF);

        JLabel LNlabel = new JLabel("Last Name :");
        LNlabel.setBounds(10, 80, 80, 25);
        registration.panel.add(LNlabel);
        JTextField lnTF = new JTextField();
        lnTF.setBounds(100, 80, 170, 25);
        registration.panel.add(lnTF);
        
        JLabel citylabel = new JLabel("City :");
        citylabel.setBounds(10, 140, 80, 25);
        registration.panel.add(citylabel);
        JTextField cityTF = new JTextField();
        cityTF.setBounds(100, 140, 170, 25);
        registration.panel.add(cityTF);

        JLabel sclabel = new JLabel("School :");
        sclabel.setBounds(10, 170, 80, 25);
        registration.panel.add(sclabel);
        JTextField scTF = new JTextField();
        scTF.setBounds(100, 170, 170, 25);
        registration.panel.add(scTF);
        
        JButton submitBTN = new JButton("SUBMIT");
        submitBTN.setBounds(100, 250, 80, 25);
        registration.panel.add(submitBTN);

        submitBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
     
                String firstName = fnTF.getText();
                String middleName = mnTF.getText();
                String lastName = lnTF.getText();
                String gender = maleRadioButton.isSelected() ? "Male" : "Female";
                String City = cityTF.getText();
                String School = scTF.getText();
                String strand = "";
                if (ictRadioButton.isSelected()) {
                    strand = "ICT";
                } else if (abmRadioButton.isSelected()) {
                    strand = "ABM";
                } else if (eimRadioButton.isSelected()) {
                    strand = "EIM";
                } else if (humsRadioButton.isSelected()) {
                    strand = "HUMS";
                } else if (stemRadioButton.isSelected()) {
                    strand = "STEM";
                }
                
                registration.outputTextArea.append("---------------------------------STUDENT PROFILE------------------------------" + "\n\n");
                registration.outputTextArea.append("First Name : " + firstName + "\n");
                registration.outputTextArea.append("Middle Name: " + middleName + "\n");
                registration.outputTextArea.append("Last Name  : " + lastName + "\n");
                registration.outputTextArea.append("Gender: " + gender + "\n");
                registration.outputTextArea.append("City  : " + City + "\n");
                registration.outputTextArea.append("School: " + School + "\n");
                registration.outputTextArea.append("Strand: " + strand + "\n");

       
                fnTF.setText("");
                mnTF.setText("");
                lnTF.setText("");
                cityTF.setText("");
                scTF.setText("");
                registration.genderGroup.clearSelection();
                registration.strandGroup.clearSelection();
     
            }
        });

        JButton resetBTN = new JButton("RESET");
        resetBTN.setBounds(200, 250, 80, 25);
        registration.panel.add(resetBTN);

        resetBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fnTF.setText("");
                mnTF.setText("");
                lnTF.setText("");
                cityTF.setText("");
                scTF.setText("");

registration.outputTextArea.setText("");
                registration.genderGroup.clearSelection();
                registration.strandGroup.clearSelection();
            }
        });
    }
}