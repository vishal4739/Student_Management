package project;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Addstudent extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3 ,l4 ,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JTextField t1 , t2 ,t3 ,t4 ,t5,t6,t7,t8,t9,t10,t11,t12,t13;
    JButton b1, b2;
    
    Addstudent(){
    
   
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
        t1 = new JTextField(); 
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();
        t10 = new JTextField();
        t11 = new JTextField();
        t12 = new JTextField();
        t13= new JTextField();
        
       setLayout(null);
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

        t1.setBounds(150, 50, 100, 20);
        add(t1);
        t2.setBounds(150, 80, 100, 20);
        add(t2);
        t3.setBounds(150, 110, 100, 20);
        add(t3);
        t4.setBounds(150, 140, 100, 20);
        add(t4);
        t5.setBounds(150, 170, 100, 20);
        add(t5);
        t6.setBounds(150, 200, 100, 20);
        add(t6);
        t7.setBounds(150, 230, 100, 20);
        add(t7);
        t8.setBounds(150, 260, 100, 20);
        add(t8);
        t9.setBounds(150, 290, 100, 20);
        add(t9);
        t10.setBounds(150,320, 100, 20);
        add(t10);
        t11.setBounds(150, 350, 100, 20);
        add(t11);
        t12.setBounds(150, 380, 100, 20);
        add(t12);
        t13.setBounds(150, 410, 100, 20);
        add(t13);
        
        b1 = new JButton("Save");
        b1.setBounds(80, 470, 80, 30);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Cancel");
        b2.setBounds(220, 470, 80, 30);
        b2.addActionListener(this);
        add(b2);
        setVisible(true);

    
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            String roll_no = t1.getText();
            String name = t2.getText();
            String fname = t3.getText();
            String addr = t4.getText();
            String state = t5.getText();
            String cont = t6.getText();
            String age = t7.getText();
            String sem = t8.getText();
            String branch = t9.getText();
            String percent = t10.getText();
            String dob = t11.getText();
            String doj = t12.getText();
            String course = t13.getText();

            try{
                String query = "insert into student values('"+roll_no+"', '"+name+"' ,'"+fname+"' , '"+addr+"' , '"+state+"' , '"+cont+"','"+age+"' , '"+sem+"' ,  '"+branch+"' , '"+percent+"' , '"+dob+"' , '"+doj+"' , '"+course+"')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
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
            new Addstudent();
        }
     
       
    }