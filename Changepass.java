package project;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Changepass extends JFrame implements ActionListener {
    JFrame f;
    JLabel l1, l2, l3 ,l4;
    JTextField t1;
    JPasswordField t2 ,t3 ,t4;
    JButton b1, b2;
    Connection c;
    Statement s;
    ResultSet rs;
Changepass(){

setSize(300 ,400);
setLocation(300,100);

setLayout(null);

        f = new JFrame("Change Password");
        l1 = new JLabel("User Name");
        l2 = new JLabel("Old Password");
        l3 = new JLabel("New Password");
        l4 = new JLabel("Confirmation");
        t1 = new JTextField();
        t2 = new JPasswordField();
        t3 = new JPasswordField();
        t4 = new JPasswordField();
        b2 = new JButton("Cancel");
       setLayout(null);
        l1.setBounds(20, 80, 100, 20);
        add(l1);
        l2.setBounds(20, 130, 100, 20);
        add(l2);
        l3.setBounds(20, 180, 200, 20);
        add(l3);
        l4.setBounds(20, 230, 200, 20);
        add(l4);
        t1.setBounds(150, 80, 100, 20);
        add(t1);
        t2.setBounds(150, 130, 100, 20);
        add(t2);
        t3.setBounds(150, 180, 100, 20);
        add(t3);
        t4.setBounds(150, 230, 100, 20);
        add(t4);
        b1 = new JButton("Change");
        b1.setBounds(40, 300, 80, 30);
        b1.addActionListener(this);
        add(b1);
        b2 = new JButton("Cancel");
        b2.setBounds(140, 300, 80, 30);
        b2.addActionListener(this);
        add(b2);
        setVisible(true);

}


public void actionPerformed(ActionEvent e) {

    if(e.getSource() == b1){
        String userName = t1.getText();
        String oldPassword = new String(t2.getPassword());
        String newPassword = new String(t3.getPassword());
        String confirmation = new String(t4.getPassword());

        // Validate if the new password and confirmation match
        if (!newPassword.equals(confirmation)) {
            JOptionPane.showMessageDialog(this, "New Password and Confirmation do not match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try {
            // Check if the old password is correct
            String checkOldPasswordQuery = "SELECT * FROM login WHERE userid='" + userName + "' AND pwd='" + oldPassword + "'";
            Conn con = new Conn();
            ResultSet rs = con.s.executeQuery(checkOldPasswordQuery);
        
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Incorrect Old Password", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Update the password
                String updatePasswordQuery = "UPDATE login SET pwd='" + newPassword + "' WHERE userid='" + userName + "'";
                int rowsAffected = con.s.executeUpdate(updatePasswordQuery);
        
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Password changed successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to change password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    else if(e.getSource() == b2){
        setVisible(false);
    }
}
    public static void main(String[] args) {
        new Changepass();
    }
 
   
}
