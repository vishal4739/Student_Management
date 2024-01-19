package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class Menu implements  ActionListener {
    JFrame f;
    JLabel l1, l2, l3;
    JTextField t1, t2;
    JButton b1, b2;
    JMenuBar mb;
    JMenu mstud, mcou, mfee, maccount, mreport;
    JMenuItem mistad;
    JMenuItem mistmo;
    JMenuItem mistde;
    JMenuItem micoadd;
    JMenuItem micomod;
    JMenuItem micodel;
    JMenuItem mifedep;
    JMenuItem mifemodi;
    JMenuItem mifedele;
    JMenuItem mipwd;
    JMenuItem milogoff;
    JMenuItem miexit;
    JMenuItem mirestu;
    JMenuItem mirecou;
    JMenuItem mirefee;
    ImageIcon icon;
    JLabel piclbl;

    Menu() {


        //main form//

        f = new JFrame("Main Form");
        f.setSize(600, 500);
        icon = new ImageIcon("homeimage.jpg");     
        piclbl=new JLabel(icon);
        mb = new JMenuBar();
        
        //account detail//
        maccount = new JMenu("Account Details");
        mb.add(maccount);
        mipwd = new JMenuItem("Change Password");
        milogoff = new JMenuItem("Log Off");
        miexit = new JMenuItem("Exit");
        maccount.add(mipwd);
        mipwd.addActionListener(this);
        maccount.add(milogoff);
        milogoff.addActionListener(this);
        maccount.add(miexit);
        miexit.addActionListener(this);

        //course detail//
        mcou = new JMenu("Course Details");
        mb.add(mcou);
        micoadd = new JMenuItem("Add New Course");
        micomod = new JMenuItem("Modify A Course Details");
        micodel = new JMenuItem("Deletion Of A Course");
        mcou.add(micoadd);
        micoadd.addActionListener(this);
        mcou.add(micomod);
        micomod.addActionListener(this);
        mcou.add(micodel);
        micodel.addActionListener(this);

        //student detail//
        mstud = new JMenu("Student Details");
        mb.add(mstud);
        mistad = new JMenuItem("New Student Registration");
        mistmo = new JMenuItem("Modification");
        mistde = new JMenuItem("Deletion");
        mstud.add(mistad);
        mistad.addActionListener(this);
        mstud.add(mistmo);
        mistmo.addActionListener(this);
        mstud.add(mistde);
        mistde.addActionListener(this);

        //fees detils//
        mfee = new JMenu("Fee Details");
        mb.add(mfee);
        mifedep = new JMenuItem("Deposit");
        mifemodi = new JMenuItem("Modification");
        mifedele = new JMenuItem("Cancelation");
        mfee.add(mifedep);
        mifedep.addActionListener(this);
        mfee.add(mifemodi);
        mifemodi.addActionListener(this);
        mfee.add(mifedele);
        mifedele.addActionListener(this);
        
        //Reports//
        mreport = new JMenu("Reports");
        mb.add(mreport);
        mirestu = new JMenuItem("Report Of A Student Deatils");
        mirecou = new JMenuItem("Report Of A Course Deatils");
        mirefee = new JMenuItem("Report Of A Fee Deatils");
        mreport.add(mirestu);
        mirestu.addActionListener(this);
        mreport.add(mirecou);
        mirecou.addActionListener(this);
        mreport.add(mirefee);
        mirefee.addActionListener(this);


        //image//
        f.getContentPane().setLayout(null);
        f.setBackground(Color.pink);
        piclbl.setBounds(0, 0, 600, 500);

        //window//
        f.setJMenuBar(mb);
        f.getContentPane().add(piclbl);
        f.getContentPane().setBackground(Color.pink);
        f.setVisible(true);
    }


    //function to open new pages//
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == mipwd) {
            new Changepass();
           
        } 
        else if (ae.getSource() == milogoff) {
            new Login();
            f.setVisible(false);
        }
        else if (ae.getSource() == miexit) {
            f.setVisible(false);
        }
        else if (ae.getSource() == micoadd) {
           new Addcourse();
        }
        else if (ae.getSource() == micomod) {
           new modcourse();
        }
        else if (ae.getSource() == micodel) {
           new Delcourse();
        }
        else if (ae.getSource() == mistad) {
           new Addstudent();
        }
        else if (ae.getSource() == mistmo) {
           new Modstudent();
        }
        else if (ae.getSource() == mistde) {
           new Delstudent();
        }
        else if (ae.getSource() == mifedep) {
           new FeeDep();
        }
        else if (ae.getSource() == mifemodi) {
           new FeeMod();
        }
        else if (ae.getSource() == mifedele) {
           new FeeCancel();
        }
        else if (ae.getSource() == mirestu) {
           new Reportstudent();
        }
        else if (ae.getSource() == mirecou) {
           new Reportcourse();}

        else if (ae.getSource() == mirefee) {
           new Reportfee();
        }
        
    }

public class Project2 {
    public static void main(String[] args) {
        new Menu();
    }
}
}
