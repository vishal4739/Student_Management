package project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Addcourse extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton b1, b2;
    // Connection con;
    // Statement st;
    ResultSet rs;
   

    Addcourse() {
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
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();

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
        b1 = new JButton("OK");
        b1.setBounds(40, 380, 80, 30);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Cancel");
        b2.setBounds(140, 380, 80, 30);
        b2.addActionListener(this);
        add(b2);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==b1){
            String course_id = t1.getText();
            String course_name = t2.getText();
            String un_name = t3.getText();
            String dur = t4.getText();
            String fee = t5.getText();
            String elig = t6.getText();
            
            try{
                String query = "insert into course values('"+course_id+"' ,'"+course_name+"' , '"+un_name+"' , '"+dur+"' , '"+fee+"','"+elig+"' )";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Course Details Inserted Successfully");
                setVisible(false);
            }catch(Exception c){
                c.printStackTrace();
            }
       }
       
       
       else if(e.getSource() == b2){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Addcourse();
    }
}
