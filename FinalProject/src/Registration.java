
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
    private JTextField emailAddTF;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup genderGroup;
    private JComboBox<String> StrandList;
    private JComboBox<String> MonthList;
    private JComboBox<Integer> NumberList;
    private JComboBox<Integer> YearList;

    public Registration() {
    	
    	ImageIcon icon = new ImageIcon("C:\\Users\\lenovo\\eclipse-workspace\\FinalProject\\src\\innovation.png");       	
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0xBCD3F5)); 
        this.setIconImage(icon.getImage());
        this.setTitle("Enrollement form");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.add(panel);
        this.setResizable(false);
        this.setSize(335, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
        JLabel GenderLabel = new JLabel("Select Gender");
        GenderLabel.setBounds(10, 110, 100, 25);
        GenderLabel.setFont(new Font("SansSerif",Font.LAYOUT_LEFT_TO_RIGHT, 13));
        panel.add(GenderLabel);

        maleRadioButton = new JRadioButton("Male");
        maleRadioButton.setBackground(new Color(0xBCD3F5));
        maleRadioButton.setBounds(100, 110, 80, 25);
        maleRadioButton.setFont(new Font("SansSerif",Font.BOLD, 13));
        panel.add(maleRadioButton);

        femaleRadioButton = new JRadioButton("Female");
        femaleRadioButton.setBackground(new Color(0xBCD3F5));
        femaleRadioButton.setBounds(200, 110, 80, 25);
        femaleRadioButton.setFont(new Font("SansSerif",Font.BOLD, 13));
        panel.add(femaleRadioButton);
     
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        JLabel strandLabel = new JLabel("Select Strand");
        strandLabel.setBounds(10, 200, 100, 25);
        strandLabel.setFont(new Font("SansSerif",Font.LAYOUT_LEFT_TO_RIGHT, 13));
        panel.add(strandLabel);
        
        final String strand[] = {"ICT", "ABM", "EIM", "HUMSS", "STEM",  "COOKERY", "HD"};
        StrandList = new JComboBox<>(strand);
        StrandList.setFont(new Font("SansSerif", Font.LAYOUT_LEFT_TO_RIGHT, 13));
        StrandList.setBounds(100, 200, 100, 25);
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

        JLabel citylabel = new JLabel("Address");
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
        
        JLabel emailAdd = new JLabel("Email");
        emailAdd.setBounds(10, 260, 80, 25);
        emailAdd.setFont(new Font("SansSerif",Font.LAYOUT_LEFT_TO_RIGHT, 13));
        panel.add(emailAdd);
        emailAddTF = new JTextField();
        emailAddTF.setBounds(100, 260, 170, 25);
        panel.add(emailAddTF);
                
        JLabel MonthLabel = new JLabel("Birthday");
        MonthLabel.setBounds(10, 230, 60, 25);
        MonthLabel.setFont(new Font("SansSerif", Font.LAYOUT_LEFT_TO_RIGHT, 13));
        panel.add(MonthLabel);
        
        
        final String Month[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", 
        		                "AUG", "SEPT", "OCT", "NOV","DEC"};
        
        MonthList = new JComboBox<>(Month);
        MonthList.setFont(new Font("SansSerif", Font.LAYOUT_LEFT_TO_RIGHT, 13));
        MonthList.setBounds(100, 230, 60, 25);
        panel.add(MonthList);
        
        NumberList = new JComboBox<>();
        for (int Number = 1; Number <= 31; Number++) {
        	NumberList.addItem(Number);
        }
        NumberList.setFont(new Font("SansSerif", Font.LAYOUT_LEFT_TO_RIGHT, 13));
        NumberList.setBounds(165, 230, 45, 25);
        panel.add(NumberList);
        
        YearList = new JComboBox<>();
        for (int Year = 1997; Year <= 2024; Year++) {
            YearList.addItem(Year);
        }
        YearList.setFont(new Font("SansSerif", Font.LAYOUT_LEFT_TO_RIGHT, 13));
        YearList.setBounds(215, 230, 60, 25);
        panel.add(YearList);

        JButton submitBTN = new JButton("SUBMIT");
        submitBTN.setBackground(new Color(0x5BA6E3));
        submitBTN.setBounds(10, 320, 80, 25);
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
                String Month = String.valueOf(MonthList.getSelectedItem());
                String Day = String.valueOf(NumberList.getSelectedItem());
                String Year = String.valueOf(YearList.getSelectedItem());
                String Email = emailAddTF.getText();

                int selectedButtonIndex = -1;

                if (maleRadioButton.isSelected()) {
                    selectedButtonIndex = 0;
                } else if (femaleRadioButton.isSelected()) {
                    selectedButtonIndex = 1;
                }

                switch (selectedButtonIndex) {
                    case 0:
                        Gender = "Male";
                        break;
                    case 1:
                        Gender = "Female";
                        break;
                    default:
                    	Gender = " ";
                        break;
                }
                
                if (firstName.isEmpty() || middleName.isEmpty() || lastName.isEmpty() || City.isEmpty() || School.isEmpty() || strand.isEmpty() || (!maleRadioButton.isSelected() && !femaleRadioButton.isSelected()) || Email.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Fill up the form completely.", "Reminder", JOptionPane.PLAIN_MESSAGE);
                    return;
                }
                
                JOptionPane.showMessageDialog(panel, 
                	    "First Name: " + firstName + "\n" +
                	    "Middle Name: " + middleName + "\n" +
                	    "Last Name: " + lastName + "\n" +
                	    "Gender: " + Gender + "\n" +
                	    "City: " + City + "\n" +
                	    "School: " + School + "\n" +
                	    "Strand: " + strand + "\n" +  
                	    "Birthday: " + Month + "," + Day + "," + Year + "\n" +
                	    "Email : " + Email,
                	    "Student Profile", 
                	    JOptionPane.PLAIN_MESSAGE);

                saveProfileToFile(firstName, middleName, lastName, Gender, City, School, strand, Month, Day, Year, Email);
            }
        });
        
        JButton resetBTN = new JButton("CLEAR");
        resetBTN.setBackground(new Color(0x5BA6E3));
        resetBTN.setBounds(100, 320, 80, 25);
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
        profile.setBackground(new Color(0x5BA6E3));
        profile.setBounds(190, 320, 115, 25);
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
                    JOptionPane.showMessageDialog(panel, "Empty file.", "File not Found.", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    private void saveProfileToFile(String firstName, String middleName, String lastName, String Gender, String city, String school, String strand, String Month, String Day, String Year, String Email) {
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
            printWriter.println("Birthday: " + Month + "," + Day + "," + Year);
            printWriter.println("Email : " + Email);
            printWriter.println();
            printWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
	public void actionPerformed(ActionEvent e) {				
	}
}