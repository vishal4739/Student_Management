package project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Reportcourse extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6,l8 ,l9,l10,l11,l12;
    JComboBox l7;
    JButton b1;
    Connection con;
    Statement st;
    ResultSet rs;

    Reportcourse() {
        setSize(400, 500);
        setLocation(300, 100);

        setLayout(null);

        f = new JFrame("Addition of a Course");
        l1 = new JLabel("Course Id");
        l2 = new JLabel("Course Name");
        l3 = new JLabel("University Name");
        l4 = new JLabel("Duration");
        l5 = new JLabel("Fee");
        l6 = new JLabel("Elegibility Criteria");
        l7 = new JComboBox<>();
        populateRollNumbers();
        l8 = new JLabel();
        l9 = new JLabel("");
        l10 = new JLabel("");
        l11 = new JLabel("");
        l12= new JLabel(" ");
       

        // Set background color to pink
        

        setLayout(null);
        l1.setBounds(20, 80, 100, 20);
        add(l1);
        l2.setBounds(20, 130, 100, 20);
        add(l2);
        l3.setBounds(20, 180, 200, 20);
        add(l3);
        l4.setBounds(20, 230, 200, 20);
        add(l4);
        l5.setBounds(20, 280, 200, 20);
        add(l5);
        l6.setBounds(20, 330, 200, 20);
        add(l6);

        l7.setBounds(150, 80, 100, 20);
        add(l7);
        l8.setBounds(150, 130, 100, 20);
        add(l8);
        l9.setBounds(150, 180, 100, 20);
        add(l9);
        l10.setBounds(150, 230, 100, 20);
        add(l10);
        l11.setBounds(150, 280, 100, 20);
        add(l11);
        l12.setBounds(150, 330, 100, 20);
        add(l12);
        b1 = new JButton("OK");
        b1.setBounds(150, 380, 80, 30);
        b1.addActionListener(this);
        add(b1);
        
        setVisible(true);
    }

    private void populateRollNumbers() {
        try {
            // Establish database connection
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery("SELECT DISTINCT course_id FROM course");

            // Populate the JComboBox with Roll_No values
            while (rs.next()) {
                l7.addItem(rs.getString("course_id"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent e) {
        
            if (e.getSource() == b1) {
                String selectedcourse = (String) l7.getSelectedItem(); // Assuming Roll_No is stored as a String in the JComboBox
    
                try {
                    // Establish database connection
                    Conn con = new Conn();
                    ResultSet rs = con.s.executeQuery("SELECT * FROM course WHERE course_id = '" + selectedcourse + "'");
    
                    // Display the data in the JLabels
                    if (rs.next()) {
                        l8.setText(rs.getString("course_name"));
                        l9.setText(rs.getString("un_name"));
                        l10.setText(rs.getString("dur"));
                        l11.setText(rs.getString("fee"));
                        l12.setText(rs.getString("elig"));
                       
                    } else {
                        JOptionPane.showMessageDialog(this, "course not found", "Error", JOptionPane.ERROR_MESSAGE);
                    }
    
                    // Close the resources
                    rs.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

    public static void main(String[] args) {
        new Reportcourse();
    }
}
