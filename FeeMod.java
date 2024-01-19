package project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class FeeMod extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6 ,l7,l8;
    JComboBox t1;
    JTextField  t2, t3, t4, t5, t6 ,t7 ,t8;
    JButton b1, b2;
    Connection con;
    Statement st;
    ResultSet rs;

    FeeMod() {
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
        t1 = new JComboBox(roll);
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();

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
        t1.setBounds(150, 80, 100, 20);
        add(t1);
        t2.setBounds(150, 130, 100, 20);
        add(t2);
        t3.setBounds(150, 180, 100, 20);
        add(t3);
        t4.setBounds(150, 230, 100, 20);
        add(t4);
        t5.setBounds(150, 280, 100, 20);
        add(t5);
        t6.setBounds(150, 330, 100, 20);
        add(t6);
        t7.setBounds(150, 380, 100, 20);
        add(t7);
        t8.setBounds(150, 430, 100, 20);
        add(t8);
        b1 = new JButton("Modify");
        b1.setBounds(80, 480, 80, 30);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Cancel");
        b2.setBounds(220, 480, 80, 30);
        b2.addActionListener(this);
        add(b2);
        f.getContentPane().setBackground(Color.pink);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b2){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new FeeMod();
    }
}
