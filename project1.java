package project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class Login implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;
    Connection con;
    Statement st;
    ResultSet rs;

    Login() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vishal", "root", "Shikher@12");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        f = new JFrame("Login");
        f.setSize(300, 300);
        l1 = new JLabel("User Name");
        l2 = new JLabel("Password");
        l3 = new JLabel(" ");
        t1 = new JTextField();
        t2 = new JPasswordField();
        b1 = new JButton("Ok");
        b2 = new JButton("Cancel");
        f.getContentPane().setLayout(null);
        l1.setBounds(20, 80, 100, 20);
        l2.setBounds(20, 130, 100, 20);
        l3.setBounds(100, 220, 200, 20);
        t1.setBounds(150, 80, 100, 20);
        t2.setBounds(150, 130, 100, 20);
        b1.setBounds(40, 180, 80, 30);
        b2.setBounds(140, 180, 80, 30);
        f.getContentPane().add(l1);
        f.getContentPane().add(l2);
        f.getContentPane().add(l3);
        f.getContentPane().add(t1);
        f.getContentPane().add(t2);
        f.getContentPane().add(b1);
        f.getContentPane().add(b2);
        f.getContentPane().setBackground(Color.pink);

        b1.addActionListener(this);
        b2.addActionListener(this);

        // Use setVisible(true) instead of show() - show() is deprecated
        f.setVisible(true);
        f.setLocation(250, 150);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String un, pwd1;
            un = t1.getText();
            pwd1 = new String(t2.getPassword()); // Use getPassword() and convert to String
            try {
                rs = st.executeQuery("select userid,pwd from login where userid='" + un + "' and pwd = '" + pwd1 + "'");
                if (rs.next()) {
                    f.setVisible(false);
                    new Menu();

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or password");

                    l3.setText("Invalid Username/Password");
                }
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        } else {
            f.setVisible(false);}

    }

    
}

class Project1 {
    public static void main(String s[]) {
       
    new Login();

    }
}