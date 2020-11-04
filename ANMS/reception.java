package ANMS;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class reception extends JFrame implements ActionListener{
    
    JButton emp, farm, customer, commodity, bill;
    
    reception(){

        ImageIcon img2 = new ImageIcon(getClass().getResource("\\Icons\\rDash.jpg"));
        Image img1 = img2.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        JLabel rDash = new JLabel(new ImageIcon(img1));
        rDash.setBounds(200, 0, 800, 700);
        add(rDash);

        emp = new JButton("Employee");
        emp.setBackground(Color.black);
        emp.setForeground(Color.white);
        emp.setBounds(30, 30, 150, 30);
        emp.addActionListener(this);
        add(emp);

        farm = new JButton("Farmer");
        farm.setBackground(Color.black);
        farm.setForeground(Color.white);
        farm.setBounds(30, 100, 150, 30);
        farm.addActionListener(this);
        add(farm);

        commodity = new JButton("Commodities");
        commodity.setBackground(Color.black);
        commodity.setForeground(Color.white);
        commodity.setBounds(30, 170, 150, 30);
        commodity.addActionListener(this);
        add(commodity);

        customer = new JButton("Customer");
        customer.setBackground(Color.black);
        customer.setForeground(Color.white);
        customer.setBounds(30, 240, 150, 30);
        customer.addActionListener(this);
        add(customer);
        
        bill = new JButton("Bills");
        bill.setBackground(Color.black);
        bill.setForeground(Color.white);
        bill.setBounds(30, 310, 150, 30);
        bill.addActionListener(this);
        add(bill);

        getContentPane().setBackground(Color.WHITE);

        setUndecorated(true);
        setLayout(null);
        setBounds(480, 100, 1000, 700);
        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new reception().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == emp){
            new showEmployee().setVisible(true);
        }
        if(ae.getSource() == farm){

        }
        if(ae.getSource() == commodity){

        }
        if(ae.getSource() == customer){

        }
        if(ae.getSource() == bill){

        }
    }
}
