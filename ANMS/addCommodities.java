package ANMS;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.LineBorder;

import com.mysql.cj.xdevapi.Result;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class addCommodities extends JFrame implements ActionListener{
    JLabel l1, l2, l3, l4, l5, l6, name, type, aq;
    JButton b1,b2;
    JTextField t1,uq;
    addCommodities(){
        ImageIcon i1 = new ImageIcon(getClass().getResource("\\Icons\\addcomo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(540, 700, Image.SCALE_DEFAULT);
        JLabel bgimg = new JLabel(new ImageIcon(i2));
        bgimg.setBounds(0, 0, 540, 700);
        add(bgimg);


        l1 = new JLabel("Add Commodities");
        l1.setFont(new Font("Tahoma",Font.BOLD,24));
        l1.setBounds(170, 20, 250, 30);
        bgimg.add(l1);

        l2 = new JLabel("ID:");
        l2.setForeground(Color.black);
        l2.setFont(new Font("Tahoma", Font.BOLD, 22));
        l2.setBounds(50, 100, 100, 30);
        bgimg.add(l2);

        t1 = new JTextField();
        t1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        t1.setBorder(null);
        t1.setBounds(370, 100, 60, 30);
        t1.setOpaque(false);
        t1.setEditable(true);
        bgimg.add(t1);

        JSeparator sp1 = new JSeparator();
        sp1.setLocation(365, 132);
        sp1.setSize(60,40);
        sp1.setBackground(Color.ORANGE);
        sp1.setForeground(Color.RED);
        bgimg.add(sp1);

        l3 = new JLabel("Name:");
        l3.setForeground(Color.black);
        l3.setFont(new Font("Tahoma", Font.BOLD, 22));
        l3.setBounds(50, 180, 100, 30);
        bgimg.add(l3);

        name = new JLabel("");
        name.setFont(new Font("Tahoma", Font.PLAIN, 19));
        name.setForeground(Color.black);
        name.setBounds(370, 180, 200, 30);
        bgimg.add(name);

        l4 = new JLabel("Type:");
        l4.setForeground(Color.black);
        l4.setFont(new Font("Tahoma", Font.BOLD, 22));
        l4.setBounds(50, 260, 100, 30);
        bgimg.add(l4);

        type = new JLabel("");
        type.setFont(new Font("Tahoma", Font.PLAIN, 19));
        type.setForeground(Color.black);
        type.setBounds(370, 260, 200, 30);
        bgimg.add(type);

        l5 = new JLabel("Available Quantity");
        l5.setForeground(Color.black);
        l5.setFont(new Font("Tahoma", Font.BOLD, 22));
        l5.setBounds(50, 340, 250, 30);
        bgimg.add(l5);

        JLabel kg = new JLabel("Kg");
        kg.setForeground(Color.black);
        kg.setFont(new Font("Tahoma", Font.PLAIN, 19));
        kg.setBounds(432, 340, 200, 30);
        bgimg.add(kg);

        aq = new JLabel("0");
        aq.setFont(new Font("Tahoma", Font.PLAIN, 19));
        aq.setForeground(Color.black);
        aq.setBounds(370, 340, 200, 30);
        bgimg.add(aq);

        l6 = new JLabel("Update Quantity");
        l6.setForeground(Color.black);
        l6.setFont(new Font("Tahoma", Font.BOLD, 22));
        l6.setBounds(50, 400, 200, 30);
        bgimg.add(l6);

        uq = new JTextField();
        uq.setFont(new Font("Tahoma", Font.PLAIN, 19));
        uq.setBorder(null);
        uq.setBounds(365, 400, 50, 30);
        uq.setOpaque(false);
        uq.setEditable(true);
        bgimg.add(uq);

        JLabel kg1 = new JLabel("Kg");
        kg1.setForeground(Color.black);
        kg1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        kg1.setBounds(412, 400, 200, 30);
        bgimg.add(kg1);

        JSeparator sp2 = new JSeparator();
        sp2.setLocation(365, 435);
        sp2.setSize(47,40);
        sp2.setBackground(Color.ORANGE);
        sp2.setForeground(Color.RED);
        bgimg.add(sp2);

        b1 = new JButton("Add");
        b1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        b1.setForeground(Color.RED);
        b1.setBackground(new Color(255,255,255));
        b1.setBounds(150, 480, 100, 30);
        b1.setBorder(new LineBorder(Color.ORANGE,3));
        b1.addActionListener(this);
        bgimg.add(b1);
        
        b2 = new JButton("Cancel");
        b2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        b2.setForeground(Color.RED);
        b2.setBackground(new Color(255,255,255));
        b2.setBounds(300, 480, 100, 30);
        b2.setBorder(new LineBorder(Color.ORANGE,3));
        b2.addActionListener(ae -> {
            this.setVisible(false);
        });
        bgimg.add(b2);

        t1.addActionListener(ae -> {
            String id = t1.getText();
            try {
                conn c = new conn();
                String qwry = "select crops.cName,crops.variety,commodities.aq from crops, commodities where crops.id = '"+id+"' and commodities.id ='"+id+"'";
                ResultSet rs = c.s.executeQuery(qwry);
                while(rs.next()){
                    name.setText(rs.getString(1));
                    type.setText(rs.getString(2));
                    aq.setText(rs.getString(3));
                }
            } catch (Exception e) {}
        });

        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setBounds(720, 100, 540, 700);
    }
    public static void main(String[] args) {
        new addCommodities().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            String id = t1.getText();
            float av = Float.parseFloat (aq.getText());
            float uqq = Float.parseFloat(uq.getText());
            float updated = uqq + av;
            String newUpdate = String.valueOf(updated);
            try {
                String qwr = "update commodities set aq = '"+newUpdate+"' where id = '"+id+"'";
                conn c = new conn();
                c.s.executeUpdate(qwr);

                t1.setText("");
                name.setText("");
                type.setText("");
                aq.setText("");
                uq.setText("");
            } catch (Exception e) {}
        }
    }
}
