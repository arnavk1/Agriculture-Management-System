package ANMS;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class reception extends JFrame implements ActionListener{
    
    JButton cust, emp, farm, customer, commodity, bill, cancel;
    
    reception(){

        ImageIcon img2 = new ImageIcon(getClass().getResource("\\Icons\\rDash.jpg"));
        Image img1 = img2.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        JLabel rDash = new JLabel(new ImageIcon(img1));
        rDash.setBounds(200, 0, 800, 700);
        add(rDash);

        cust = new JButton("Customer");
        cust.setBackground(Color.black);
        cust.setForeground(Color.white);
        cust.setBounds(30, 30, 150, 30);
        cust.addActionListener(this);
        add(cust);

        emp = new JButton("Employee");
        emp.setBackground(Color.black);
        emp.setForeground(Color.white);
        emp.setBounds(30, 100, 150, 30);
        emp.addActionListener(this);
        add(emp);

        farm = new JButton("Farmer");
        farm.setBackground(Color.black);
        farm.setForeground(Color.white);
        farm.setBounds(30, 170, 150, 30);
        farm.addActionListener(this);
        add(farm);

        commodity = new JButton("Commodities");
        commodity.setBackground(Color.black);
        commodity.setForeground(Color.white);
        commodity.setBounds(30, 240, 150, 30);
        commodity.addActionListener(this);
        add(commodity);

        customer = new JButton("Customer");
        customer.setBackground(Color.black);
        customer.setForeground(Color.white);
        customer.setBounds(30, 310, 150, 30);
        customer.addActionListener(this);
        add(customer);
        
        bill = new JButton("Bills");
        bill.setBackground(Color.black);
        bill.setForeground(Color.white);
        bill.setBounds(30, 380, 150, 30);
        bill.addActionListener(this);
        add(bill);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(30, 450, 150, 30);
        cancel.addActionListener(ae -> {
            this.setVisible(false);
        });

        ImageIcon im1 = new ImageIcon(getClass().getResource("\\Icons\\recep.jpg"));
        Image im2 = im1.getImage().getScaledInstance(210, 180, Image.SCALE_DEFAULT);
        ImageIcon im3 = new ImageIcon(im2);
        JLabel img3 = new JLabel(im3);
        img3.setBounds(-5, 500, 210, 180);
        add(img3);

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
        if(ae.getSource() == cust){
            new addCustomer().setVisible(true);
        }
        if(ae.getSource() == emp){
            new showEmployee().setVisible(true);
        }
        if(ae.getSource() == farm){
            new showFarmers().setVisible(true);
        }
        if(ae.getSource() == commodity){
	    new showCommodities().setVisible(true);
        }
        if(ae.getSource() == customer){
	    new showCustomers().setVisible(true);
        }
        if(ae.getSource() == bill){
            new showBill().setVisible(true);
        }
    }
}
