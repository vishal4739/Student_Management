package project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Reportstudent extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3 ,l4 ,l5,l6,l7,l8,l9,l10,l11,l12,l13,l15,l16,l17,l18,l19,l20
    ,l21,l22,l23,l24,l25,l26;
    JComboBox l14;
    JButton b1;
    
    ResultSet rs;
    Reportstudent(){
    
   
        setSize(500, 580);
        setLocation(300, 100);

        setLayout(null);
        f = new JFrame("Addition Of Student Details");
        l1 = new JLabel("Roll_No.");
        l2 = new JLabel("Name");
        l3 = new JLabel("Father's Name");
        l4 = new JLabel("Address");
        l5 = new JLabel("State");
        l6 = new JLabel("Contact_No.");
        l7 = new JLabel("Age");
        l8 = new JLabel("Semester");
        l9 = new JLabel("Branch");
        l10 = new JLabel("Percentage");
        l11 = new JLabel("Date_Of_Birth");
        l12 = new JLabel("Date_Of_Joining");
        l13= new JLabel("Course");
        l14 = new JComboBox<>();
        populateRollNumbers(); 
        l15 = new JLabel();
        l16 = new JLabel();
        l17 = new JLabel();
        l18 = new JLabel();
        l19= new JLabel();
        l20 = new JLabel();
        l21 = new JLabel();
        l22 = new JLabel();
        l23 = new JLabel();
        l24 = new JLabel();
        l25 = new JLabel();
        l26= new JLabel();
        
        
      
        l1.setBounds(20, 50, 100, 20);
        add(l1);
        l2.setBounds(20, 80, 100, 20);
        add(l2);
        l3.setBounds(20, 110, 100, 20);
        add(l3);
        l4.setBounds(20, 140, 100, 20);
        add(l4);
        l5.setBounds(20, 170, 100, 20);
        add(l5);
        l6.setBounds(20, 200, 100, 20);
        add(l6);
        l7.setBounds(20, 230, 100, 20);
        add(l7);
        l8.setBounds(20, 260, 100, 20);
        add(l8);
        l9.setBounds(20, 290, 100, 20);
        add(l9);
        l10.setBounds(20,320, 100, 20);
        add(l10);
        l11.setBounds(20, 350, 100, 20);
        add(l11);
        l12.setBounds(20, 380, 100, 20);
        add(l12);
        l13.setBounds(20, 410, 100, 20);
        add(l13);

        l14.setBounds(150, 50, 100, 20);
        add(l14);
        l15.setBounds(150, 80, 100, 20);
        add(l15);
        l16.setBounds(150, 110, 100, 20);
        add(l16);
        l17.setBounds(150, 140, 100, 20);
        add(l17);
        l18.setBounds(150, 170, 100, 20);
        add(l18);
        l19.setBounds(150, 200, 100, 20);
        add(l19);
        l20.setBounds(150, 230, 100, 20);
        add(l20);
        l21.setBounds(150, 260, 100, 20);
        add(l21);
        l22.setBounds(150, 290, 100, 20);
        add(l22);
        l23.setBounds(150,320, 100, 20);
        add(l23);
        l24.setBounds(150, 350, 100, 20);
        add(l24);
        l25.setBounds(150, 380, 100, 20);
        add(l25);
        l26.setBounds(150, 410, 100, 20);
        add(l26);
        
        b1 = new JButton("OK");
        b1.setBounds(200, 470, 80, 30);
        b1.addActionListener(this);
        add(b1);
        setVisible(true);


    
    }
    private void populateRollNumbers() {
        try {
            // Establish database connection
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("SELECT DISTINCT roll_No FROM student");

            // Populate the JComboBox with Roll_No values
            while (rs.next()) {
                l14.addItem(rs.getString("roll_No"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String selectedRoll = (String) l14.getSelectedItem(); // Assuming Roll_No is stored as a String in the JComboBox
        
        try {
            // Establish database connection
            
            // Fetch student details based on the selected Roll_No
            String selectQuery = "SELECT * FROM student WHERE roll_No = '" +selectedRoll+ "'";
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery(selectQuery);

            // Display the data in the JLabels
            if (rs.next()) {
                l15.setText(rs.getString("name"));
                l16.setText(rs.getString("fname"));
                l17.setText(rs.getString("addr"));
                l18.setText(rs.getString("state"));
                l19.setText(rs.getString("cont"));
                l20.setText(rs.getString("age"));
                l21.setText(rs.getString("sem"));
                l22.setText(rs.getString("branch"));
                l23.setText(rs.getString("percent"));
                l24.setText(rs.getString("dob"));
                l25.setText(rs.getString("doj"));
                l26.setText(rs.getString("course"));
            } else {
                JOptionPane.showMessageDialog(this, "Student not found", "Error", JOptionPane.ERROR_MESSAGE);
            }

            // Close the resources
           
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}



    
        public static void main(String[] args) {
            new Reportstudent();
        }
    }
     
       
    
