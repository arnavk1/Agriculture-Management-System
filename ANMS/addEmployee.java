package ANMS;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class addEmployee extends JFrame implements ActionListener {

    JButton b1, b2;
    JLabel l1, l2, l3, l4, l5, l6, l7;
    JTextField t1, t2, t3, t5, t4;
    JComboBox cb1, cb2, cb3;

    addEmployee() {

        ImageIcon i1 = new ImageIcon(getClass().getResource("\\Icons\\employee.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 1000, 700);
        add(img);

        l1 = new JLabel("Enter Employee Details");
        l1.setBounds(40, 40, 300, 30);
        l1.setFont(new Font("Tahoma", Font.BOLD, 23));
        l1.setForeground(Color.white);
        img.add(l1);

        l2 = new JLabel("ID");
        l2.setBounds(113, 120, 100, 30);
        l2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l2.setForeground(Color.white);
        img.add(l2);

        cb1 = new JComboBox(new String[] { "Aadhar", "Pan", "Driving Licence" });
        cb1.setBackground(Color.white);
        cb1.setBounds(290, 120, 150, 30);
        img.add(cb1);

        l3 = new JLabel("ID Number");
        l3.setBounds(113, 180, 100, 30);
        l3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l3.setForeground(Color.white);
        img.add(l3);

        t1 = new JTextField();
        t1.setBounds(290, 180, 150, 30);
        img.add(t1);

        l4 = new JLabel("Name");
        l4.setBounds(113, 240, 100, 30);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l4.setForeground(Color.white);
        img.add(l4);

        t2 = new JTextField();
        t2.setBounds(290, 240, 150, 30);
        img.add(t2);

        l4 = new JLabel("Gender");
        l4.setBounds(113, 300, 100, 30);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l4.setForeground(Color.white);
        img.add(l4);

        cb2 = new JComboBox(new String[] { "Male", "Female", "Others" });
        cb2.setBackground(Color.white);
        cb2.setBounds(290, 300, 150, 30);
        img.add(cb2);

        l4 = new JLabel("Position");
        l4.setBounds(113, 360, 100, 30);
        l4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l4.setForeground(Color.white);
        img.add(l4);

        cb3 = new JComboBox(new String[] { "Manager"});
        cb3.setBackground(Color.white);
        cb3.setBounds(290, 360, 150, 30);
        img.add(cb3);

        l5 = new JLabel("Phone No");
        l5.setBounds(113, 420, 100, 30);
        l5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l5.setForeground(Color.white);
        img.add(l5);

        t3 = new JTextField();
        t3.setBounds(290, 420, 150, 30);
        img.add(t3);

        l6 = new JLabel("Salary");
        l6.setBounds(113, 480, 100, 30);
        l6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l6.setForeground(Color.white);
        img.add(l6);

        t5 = new JTextField();
        t5.setBounds(290, 480, 150, 30);
        img.add(t5);

        l7 = new JLabel("Address");
        l7.setBounds(113, 540, 100, 30);
        l7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l7.setForeground(Color.white);
        img.add(l7);

        t4 = new JTextField();
        t4.setBounds(290, 540, 150, 30);
        img.add(t4);

        b1 = new JButton("Submit");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(600, 240, 150, 40);
        b1.addActionListener(this);
        img.add(b1);

        b2 = new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(600, 340, 150, 40);
        b2.addActionListener(this);
        img.add(b2);

        setUndecorated(true);
        setLayout(null);
        setBounds(500, 100, 1000, 700);
        setVisible(true);
    }

    public static void main(String[] args) {
        new addEmployee().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String id = (String) cb1.getSelectedItem();
            String id_num = t1.getText();
            String name = t2.getText();
            String gender = (String) cb2.getSelectedItem();
            String work = (String) cb3.getSelectedItem();
            String phone = t3.getText();
            String salary = t5.getText();
            String address = t4.getText();
            String str = "insert into employee values('" + id + "','" + id_num + "','" + name + "','" + gender + "','"
                    + work + "','" + phone + "','" + salary + "','" + address + "')";
            conn c = new conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from employee");
                while (rs.next()) {
                    System.out.println(rs.getString("id_number"));
                    if (rs.getString("id_number").equals(id_num)) {
                        JOptionPane.showMessageDialog(this, "ID number Already Exist");
                    }
                }
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(this, "Employee Added Successfuly");
                setVisible(false);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }
}
