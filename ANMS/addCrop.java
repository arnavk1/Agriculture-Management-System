package ANMS;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class addCrop extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, tag, tagNo;
    JTextField t1, t2, t3, t4, t5, t6;
    JButton b1, b2;
    JComboBox cb1;
    JCheckBox c1;
    Choice c2,c3;

    addCrop() {

        ImageIcon i = new ImageIcon(getClass().getResource("\\Icons\\addCrops.jpg"));
        Image i1 = i.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        JLabel img = new JLabel(new ImageIcon(i1));
        img.setBounds(0, 0, 1000, 700);
        add(img);

        l1 = new JLabel("Add Crops");
        l1.setBounds(40, 40, 300, 30);
        l1.setFont(new Font("Tahoma", Font.BOLD, 23));
        l1.setForeground(Color.white);
        img.add(l1);

        l2 = new JLabel("ID");
        l2.setBounds(113, 120, 100, 30);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l2.setForeground(Color.white);
        img.add(l2);

        tag = new JLabel("C-");
        tag.setBounds(250, 120, 100, 30);
        tag.setFont(new Font("Tahoma", Font.BOLD, 18));
        tag.setForeground(Color.white);
        img.add(tag);

        tagNo = new JLabel();
        tagNo.setBounds(275, 120, 100, 30);
        tagNo.setFont(new Font("Tahoma", Font.BOLD, 18));
        tagNo.setForeground(Color.white);
        img.add(tagNo);

        try {
            int idNo = 1001;
            String str1 = String.valueOf(idNo);
            tagNo.setText(str1);
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select max(id) from crops");
            while(rs.next()){
                idNo = rs.getInt(1);
                idNo += 1;
                String str = String.valueOf(idNo);
                tagNo.setText(str);
            }
        } catch (Exception e) {}


        l3 = new JLabel("Type");
        l3.setBounds(113, 180, 100, 30);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l3.setForeground(Color.white);
        img.add(l3);

        c2 = new Choice();
        try {
            conn c = new conn();
            String qry = "Select * from croptype";
            ResultSet rs = c.s.executeQuery(qry);
            while (rs.next()) {
                c2.add(rs.getString("type"));
            }
        } catch (Exception e) {
        }
        c2.setBounds(250, 180, 190, 30);
        img.add(c2);

        c1 = new JCheckBox();
        c1.setBounds(430, 180, 20, 20);
        c1.addActionListener(this);
        img.add(c1);

        l4 = new JLabel("Sowed In");
        l4.setBounds(113, 240, 100, 30);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l4.setForeground(Color.white);
        img.add(l4);

        t2 = new JTextField();
        t2.setBounds(250, 240, 150, 30);
        t2.setEditable(false);
        img.add(t2);

        l5 = new JLabel("Harvested In");
        l5.setBounds(113, 300, 120, 30);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l5.setForeground(Color.white);
        img.add(l5);

        t3 = new JTextField();
        t3.setBounds(250, 300, 150, 30);
        t3.setEditable(false);
        img.add(t3);             

        l9 = new JLabel("Crop Variety");
        l9.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l9.setForeground(Color.white);
        l9.setBounds(113, 360, 120, 30);
        img.add(l9);

        cb1 = new JComboBox(new String[] {"Vegetable","Fruits","Crops","Seeds"});
        cb1.setBackground(Color.white);
        cb1.setBounds(250, 360, 150, 30);
        img.add(cb1);

        l6 = new JLabel("Crop Name");
        l6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l6.setForeground(Color.white);
        l6.setBounds(113, 420, 120, 30);
        img.add(l6);

        t4 = new JTextField();
        t4.setBounds(250, 420, 150, 30);
        img.add(t4);

        l7 = new JLabel("Fertilizer Used");
        l7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l7.setForeground(Color.white);
        l7.setBounds(113, 480, 120, 30);
        img.add(l7);

        c3 = new Choice();
        try {
            conn cc = new conn();
            String qry3 = "Select * from addFert";
            ResultSet rs3 = cc.s.executeQuery(qry3);
            while(rs3.next()){
                c3.add(rs3.getString("type"));
            }
        } catch (Exception e) {}
        c3.setBounds(250, 480, 190, 30);
        img.add(c3);

        l8 = new JLabel("Price");
        l8.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l8.setForeground(Color.white);
        l8.setBounds(113, 540, 120, 30);
        img.add(l8);

        t5 = new JTextField();
        t5.setBounds(250, 540, 150, 30);
        img.add(t5);

        b1 = new JButton("ADD");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        b1.setBounds(113, 600, 130, 30);
        img.add(b1);

        b2 = new JButton("CANCEL");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(270, 600, 130, 30);
        b2.addActionListener(this);
        img.add(b2);

        setUndecorated(true);
        setLayout(null);
        setBounds(480, 100, 1000, 700);
        setVisible(true);
    }
    public static void main(String[] args) {
        new addCrop().setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == c1){
            if (c1.isSelected()) {
                String type = c2.getSelectedItem();
                conn c = new conn();
                String qry1 = "Select * from croptype where type = '"+type+"'";
                ResultSet rs1;
                try {
                    rs1 = c.s.executeQuery(qry1);
                    while(rs1.next()){
                        t2.setText(""+rs1.getString(2));
                        t3.setText(""+rs1.getString(3));
                    }
                } catch (SQLException e) {}
            } else{
                t2.setText("");
                t3.setText("");
            }
        } else if(ae.getSource() == b1){
            String id = tagNo.getText();
            String type = (String)c2.getSelectedItem();
            String sIn = t2.getText();
            String hIn = t3.getText();
            String variety = (String) cb1.getSelectedItem();
            String cName = t4.getText();
            String fUsed = (String)c3.getSelectedItem();
            String price = t5.getText();
            String qwry = "insert into crops values('"+id+"','"+type+"','"+sIn+"','"+hIn+"','"+variety+"','"+cName+"','"+fUsed+"','"+price+"')";
            String qwry2 = "insert into commodities values('"+ id + "','" + 0 + "')";
            try {
                conn c = new conn();
                c.s.executeUpdate(qwry);
                c.s.executeUpdate(qwry2);
                JOptionPane.showMessageDialog(this, "New Crop Has been added");
                this.setVisible(false);
            } catch (Exception e) {} 
        } else if(ae.getSource() == b2){
            this.setVisible(false);
        }

    }
    
}
