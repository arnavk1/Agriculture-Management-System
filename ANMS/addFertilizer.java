package ANMS;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class addFertilizer extends JFrame implements ActionListener{
    JLabel l1, l2, l3, l4, l5, type, aq, lowLevel, adequate;
    JButton b1,b2;
    JTextField t1,uq;
    addFertilizer(){
        ImageIcon i1 = new ImageIcon(getClass().getResource("\\Icons\\addFer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,200, Image.SCALE_DEFAULT);
        JLabel img = new JLabel(new ImageIcon(i2));
        img.setBounds(80, 440, 400, 300);
        add(img);
        
        ImageIcon i3 = new ImageIcon(getClass().getResource("\\Icons\\vineFert.png"));
        Image i4 = i3.getImage().getScaledInstance(80,370, Image.SCALE_DEFAULT);
        JLabel vine = new JLabel(new ImageIcon(i4));
        vine.setBounds(260, 50, 80, 370);
        add(vine);


        l1 = new JLabel("Update Fertilizers");
        l1.setFont(new Font("Tahoma",Font.BOLD,24));
        l1.setBounds(170, 20, 300, 30);
        add(l1);

        l2 = new JLabel("ID:");
        l2.setForeground(Color.black);
        l2.setFont(new Font("Tahoma", Font.BOLD, 22));
        l2.setBounds(50, 100, 100, 30);
        add(l2);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        t1.setBorder(null);
        t1.setBounds(370, 100, 60, 30);
        t1.setOpaque(false);
        t1.setEditable(true);
        add(t1);

        JSeparator sp1 = new JSeparator();
        sp1.setLocation(365, 132);
        sp1.setSize(60,40);
        sp1.setBackground(Color.ORANGE);
        sp1.setForeground(Color.RED);
        add(sp1);

        l3 = new JLabel("Type");
        l3.setForeground(Color.black);
        l3.setFont(new Font("Tahoma", Font.BOLD, 22));
        l3.setBounds(50, 180, 200, 30);
        add(l3);

        type = new JLabel("");
        type.setFont(new Font("Tahoma", Font.PLAIN, 19));
        type.setForeground(Color.black);
        type.setBackground(Color.white);
        type.setBounds(370, 180, 130, 30);
        add(type);

        l4 = new JLabel("Available Quantity");
        l4.setForeground(Color.black);
        l4.setFont(new Font("Tahoma", Font.BOLD, 22));
        l4.setBounds(50, 260, 250, 30);
        add(l4);

        JLabel kg = new JLabel("Kg");
        kg.setForeground(Color.black);
        kg.setFont(new Font("Tahoma", Font.PLAIN, 19));
        kg.setBounds(402, 260, 200, 30);
        add(kg);

        aq = new JLabel("0");
        aq.setFont(new Font("Tahoma", Font.PLAIN, 19));
        aq.setForeground(Color.black);
        aq.setBounds(370, 260, 200, 30);
        add(aq);

        l5 = new JLabel("Update Quantity");
        l5.setForeground(Color.black);
        l5.setFont(new Font("Tahoma", Font.BOLD, 22));
        l5.setBounds(50, 340, 200, 30);
        add(l5);

        uq = new JTextField();
        uq.setFont(new Font("Tahoma", Font.PLAIN, 19));
        uq.setBorder(null);
        uq.setBounds(365, 340, 50, 30);
        uq.setOpaque(false);
        uq.setEditable(true);
        add(uq);

        JLabel kg1 = new JLabel("Kg");
        kg1.setForeground(Color.black);
        kg1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        kg1.setBounds(412, 340, 200, 30);
        add(kg1);

        JSeparator sp2 = new JSeparator();
        sp2.setLocation(365, 375);
        sp2.setSize(47,40);
        sp2.setBackground(Color.ORANGE);
        sp2.setForeground(Color.RED);
        add(sp2);

        b1 = new JButton("Update");
        b1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.black);
        b1.setBounds(150, 420, 100, 30);
        b1.setBorder(new LineBorder(Color.ORANGE,3));
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Cancel");
        b2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.black);
        b2.setBounds(300, 420, 100, 30);
        b2.setBorder(new LineBorder(Color.ORANGE,3));
        b2.addActionListener(ae -> {
            this.setVisible(false);
        });
        add(b2);

        ImageIcon i5 = new ImageIcon(getClass().getResource("\\Icons\\adequate.png"));
        Image i6 = i5.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
        adequate = new JLabel(new ImageIcon(i6));
        adequate.setBounds(435, 260, 30, 30);
        add(adequate);

        ImageIcon i7 = new ImageIcon(getClass().getResource("\\Icons\\lowLevel.gif"));
        Image i8 = i7.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT);
        lowLevel = new JLabel(new ImageIcon(i8));
        lowLevel.setBounds(435, 260, 30, 30);
        add(lowLevel);

        lowLevel.setVisible(false);
        adequate.setVisible(false);

        t1.addActionListener(ae -> {
            String id = t1.getText();
            try {
                conn c = new conn();
                String qwry = "select type,availQuant from addFert where id = '"+id+"'";
                ResultSet rs = c.s.executeQuery(qwry);
                while(rs.next()){
                    type.setText(rs.getString(1));
                    aq.setText(rs.getString(2));
                }
                int avq = Integer.parseInt(aq.getText());
                if(avq <= 10){
                    lowLevel.setVisible(true);
                    adequate.setVisible(false);
                } else {
                    adequate.setVisible(true);
                    lowLevel.setVisible(false);
                }
            } catch (Exception e) {}
        });

        getContentPane().setBackground(Color.white);

        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setBounds(720, 100, 540, 700);
    }
    public static void main(String[] args) {
        new addFertilizer().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            String id = t1.getText();
            try {
                String qwr = "update addFert set availQuant = '"+uq.getText()+"' where id = '"+id+"'";
                conn c = new conn();
                c.s.executeUpdate(qwr);
                t1.setText("");
                type.setText("");
                aq.setText("");
                uq.setText("");
                adequate.setVisible(false);
                lowLevel.setVisible(false);
            } catch (Exception e) {}
        }
    }
}
