
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Registration extends JFrame implements ActionListener{

    private JPanel panel;
    private JTextField fnTF;
    private JTextField mnTF;
    private JTextField lnTF;
    private JTextField cityTF;
    private JTextField scTF;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup genderGroup;
    private JComboBox StrandList;

    public Registration() {
    	
    	
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY); 
        this.setTitle("ENROLLEMENT FORM");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.add(panel);
        this.setResizable(false);
        this.setSize(450, 330);
        this.setVisible(true);
            
        JLabel GenderLabel = new JLabel("Select Gender");
        GenderLabel.setBounds(10, 110, 100, 25);
        GenderLabel.setFont(new Font("SansSerif",Font.LAYOUT_LEFT_TO_RIGHT, 13));
        panel.add(GenderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBackground(Color.LIGHT_GRAY);
        maleRadioButton.setBounds(100, 110, 80, 25);
        maleRadioButton.setFont(new Font("SansSerif",Font.BOLD, 13));
        panel.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBackground(Color.LIGHT_GRAY);
        femaleRadioButton.setBounds(200, 110, 80, 25);
        femaleRadioButton.setFont(new Font("SansSerif",Font.BOLD, 13));
        panel.add(femaleRadioButton);
     
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JLabel strandLabel = new JLabel("Select Strand");
        strandLabel.setBounds(10, 210, 100, 25);
        strandLabel.setFont(new Font("SansSerif",Font.LAYOUT_LEFT_TO_RIGHT, 13));
        panel.add(strandLabel);
        
        final String strand[] = {"ICT", "ABM", "EIM", "HUMSS", "STEM",  "COOKERY", "HD"};
        StrandList = new JComboBox(strand);
        StrandList.setFont(new Font("SansSerif", Font.LAYOUT_LEFT_TO_RIGHT, 13));
        StrandList.setBounds(100, 210, 100, 25);
        panel.add(StrandList);

        
        JLabel FNlabel = new JLabel("First Name");
        FNlabel.setBounds(10, 20, 80, 25);
        FNlabel.setFont(new Font("SansSerif",Font.LAYOUT_LEFT_TO_RIGHT, 13));
        panel.add(FNlabel);
        fnTF = new JTextField();
        fnTF.setBounds(100, 20, 170, 25);
        panel.add(fnTF);

        JLabel MNlabel = new JLabel("Middle Name");
        MNlabel.setBounds(10, 50, 80, 25);
        MNlabel.setFont(new Font("SansSerif",Font.LAYOUT_LEFT_TO_RIGHT, 13));
        panel.add(MNlabel);
        mnTF = new JTextField();
        mnTF.setBounds(100, 50, 170, 25);
        panel.add(mnTF);

        JLabel LNlabel = new JLabel("Last Name");
        LNlabel.setBounds(10, 80, 80, 25);
        LNlabel.setFont(new Font("SansSerif",Font.LAYOUT_LEFT_TO_RIGHT, 13));
        panel.add(LNlabel);
        lnTF = new JTextField();
        lnTF.setBounds(100, 80, 170, 25);
        panel.add(lnTF);

        JLabel citylabel = new JLabel("City");
        citylabel.setBounds(10, 140, 80, 25);
        citylabel.setFont(new Font("SansSerif",Font.LAYOUT_LEFT_TO_RIGHT, 13));
        panel.add(citylabel);
        cityTF = new JTextField();
        cityTF.setBounds(100, 140, 170, 25);
        panel.add(cityTF);

        JLabel sclabel = new JLabel("School");
        sclabel.setBounds(10, 170, 80, 25);
        sclabel.setFont(new Font("SansSerif",Font.LAYOUT_LEFT_TO_RIGHT, 13));
        panel.add(sclabel);
        scTF = new JTextField();
        scTF.setBounds(100, 170, 170, 25);
        panel.add(scTF);

        JButton submitBTN = new JButton("SUBMIT");
        submitBTN.setBounds(100, 250, 80, 25);
        panel.add(submitBTN);
        
       

        submitBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            			
                String firstName = fnTF.getText();
                String middleName = mnTF.getText();
                String lastName = lnTF.getText();
                String City = cityTF.getText();
                String School = scTF.getText();
                String strand = (String) StrandList.getSelectedItem();
                String Gender = "";
                
                if (maleRadioButton.isSelected()) {
                	Gender = "Male";
                } else if (femaleRadioButton.isSelected()) {
                	Gender = "Female";
                } 
                
                if (firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty() || City.isEmpty() || School.isEmpty() || strand.isEmpty() || (!maleRadioButton.isSelected() && !femaleRadioButton.isSelected())) {
                    JOptionPane.showMessageDialog(panel, "Fill up the form completely.");
                    return;
                }
                
                JOptionPane.showMessageDialog(panel, 
                	    "First Name: " + firstName + "\n" +
                	    "Middle Name: " + middleName + "\n" +
                	    "Last Name: " + lastName + "\n" +
                	    "Gender: " + Gender + "\n" +
                	    "City: " + City + "\n" +
                	    "School: " + School + "\n" +
                	    "Strand: " + strand,
                	    "Student Profile", 
                	    JOptionPane.PLAIN_MESSAGE);

                saveProfileToFile(firstName, middleName, lastName, Gender, City, School, strand);
            }
        });
        
        JButton resetBTN = new JButton("CLEAR");
        resetBTN.setBounds(200, 250, 80, 25);
        panel.add(resetBTN);

        resetBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fnTF.setText("");
                mnTF.setText("");
                lnTF.setText("");
                cityTF.setText("");
                scTF.setText("");
                genderGroup.clearSelection();
            }
        });
        
        JButton profile = new JButton("STUDENT LIST");
        profile.setBounds(300, 250, 115, 25);
        panel.add(profile);
        
        
        profile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String fileName = "student_profile.txt";
                
                try {
                    FileReader fileReader = new FileReader(fileName);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    
                    StringBuilder profileList = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        profileList.append(line).append("\n"); 
                    }
                    
                    JOptionPane.showMessageDialog(panel, profileList.toString(), "Student List", JOptionPane.PLAIN_MESSAGE);
                    
                    bufferedReader.close();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(panel, "File not found: " + fileName);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    private void saveProfileToFile(String firstName, String middleName, String lastName, String Gender, String city, String school, String strand) {
        try {
            FileWriter fileWriter = new FileWriter("student_profile.txt", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("First Name : " + firstName);
            printWriter.println("Middle Name : " + middleName);
            printWriter.println("Last Name : " + lastName);
            printWriter.println("Gender : " + Gender);
            printWriter.println("City : " + city);
            printWriter.println("School : " + school);
            printWriter.println("Strand : " + strand);
            printWriter.println();
            printWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

	public void actionPerformed(ActionEvent e) {

		
	}

}