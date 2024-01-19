package project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Reportfee extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6 ,l7,l8,l10,l11,l12,l13,l14,l15,l16;
    JComboBox l9;
    JButton b1, b2;
    Connection con;
    Statement st;
    ResultSet rs;

    Reportfee() {
        setSize(500, 580);
        setLocation(300, 100);

        setLayout(null);

        f = new JFrame("Fee details");
        l1 = new JLabel("Roll_No.");
        l2 = new JLabel("Name");
        l3 = new JLabel("Branch");
        l4 = new JLabel("Semester");
        l5 = new JLabel("Fee_Deposit");
        l6 = new JLabel("Fee_Default");
        l7 = new JLabel("Course");
        l8 = new JLabel("Date");
        String[] roll = {"01" , "02" , "03", "04" ,"05"};
        l9 = new JComboBox(roll);
        l10 = new JLabel("");
        l11 = new JLabel("");
        l12 = new JLabel("");
        l13 = new JLabel("");
        l14 = new JLabel("");
        l15 = new JLabel("");
        l16 = new JLabel("");
        
        

       

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
        l7.setBounds(20, 380, 200, 20);
        add(l7);
        l8.setBounds(20, 430, 200, 20);
        add(l8);

        l9.setBounds(150, 80, 100, 20);
        add(l9);
        l10.setBounds(150, 130, 100, 20);
        add(l10);
        l11.setBounds(150, 180, 100, 20);
        add(l11);
        l12.setBounds(150, 230, 100, 20);
        add(l12);
        l13.setBounds(150, 280, 100, 20);
        add(l13);
        l14.setBounds(150, 330, 100, 20);
        add(l14);
        l15.setBounds(150, 380, 100, 20);
        add(l15);
        l16.setBounds(150, 430, 100, 20);
        add(l16);

        b1 = new JButton("Ok");
        b1.setBounds(200, 480, 80, 30);
        b1.addActionListener(this);
        add(b1);
        
        f.getContentPane().setBackground(Color.pink);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Reportfee();
    }
}

