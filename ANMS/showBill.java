package ANMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class showBill extends JFrame implements ActionListener{
    JLabel id, idl, ph, name, namel, email, emaill, bills, date, total, paid, returned, totall, paidl, returnedl;
    JTextField pht;
    Choice c1, c2;
    JCheckBox dcb, tcb;
    JButton b1, b2, b3;
    JScrollPane sp;
    JTable ta;
    DefaultTableModel model;

    showBill(){
        JLabel title = new JLabel("Check Your Bills");
        title.setFont(new Font("Tahoma", Font.BOLD, 30));
        title.setBounds(250, 20, 300, 30);
        add(title);

        ph = new JLabel("Phone:");
        ph.setFont(new Font("Tahoma", Font.BOLD, 18));
        ph.setBounds(30, 60, 70, 30);
        add(ph);

        pht = new JTextField();
        pht.setFont(new Font("Tahoma", Font.PLAIN, 15));
        pht.setBounds(100, 60, 90, 30);
        add(pht);

        id = new JLabel("ID:");
        id.setFont(new Font("Tahoma", Font.BOLD, 18));
        id.setBounds(200, 60, 30, 30);
        add(id);

        idl = new JLabel("");
        idl.setFont(new Font("Tahoma", Font.PLAIN, 15));
        idl.setBounds(240, 60, 60, 30);
        add(idl);

        name = new JLabel("Name:");
        name.setFont(new Font("Tahoma", Font.BOLD, 18));
        name.setBounds(300, 60, 80, 30);
        add(name);

        namel = new JLabel("");
        namel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        namel.setBounds(370, 60, 200, 30);
        add(namel);

        date = new JLabel("Date: ");
        date.setFont(new Font("Tahoma", Font.BOLD, 18));
        date.setBounds(580, 60, 60, 30);
        add(date);

        email = new JLabel("Email:");
        email.setFont(new Font("Tahoma", Font.BOLD, 18));
        email.setBounds(30, 100, 70, 30);
        add(email);

        emaill = new JLabel("");
        emaill.setFont(new Font("Tahoma", Font.PLAIN, 15));
        emaill.setBounds(100, 100, 200, 30);
        add(emaill);

        bills = new JLabel("BillID: ");
        bills.setFont(new Font("Tahoma", Font.BOLD, 18));
        bills.setBounds(300, 100, 70, 30);
        add(bills);

        b1 = new JButton("Show");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(30, 180, 100, 30);
        b1.addActionListener(this);
        add(b1);

        model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Type");
        model.addColumn("Rate");
        model.addColumn("Quantity");
        model.addColumn("SubTotal");
        ta = new JTable(model);
        sp = new JScrollPane(ta);
        sp.setBounds(30, 230, 497, 220);
        add(sp);

        total = new JLabel("Total:        Rs.");
        total.setFont(new Font("Tahoma", Font.BOLD, 18));
        total.setBounds(550, 270, 140, 30);
        add(total);

        totall = new JLabel("");
        totall.setFont(new Font("Tahoma", Font.PLAIN, 15));
        totall.setBounds(690, 270, 200, 30);
        add(totall);
        
        paid = new JLabel("Paid:         Rs.");
        paid.setFont(new Font("Tahoma", Font.BOLD, 18));
        paid.setBounds(550, 330, 140, 30);
        add(paid);

        paidl = new JLabel("");
        paidl.setFont(new Font("Tahoma", Font.PLAIN, 15));
        paidl.setBounds(690, 330, 200, 30);
        add(paidl);

        returned =  new JLabel("Returned: Rs.");
        returned.setFont(new Font("Tahoma", Font.BOLD, 18));
        returned.setBounds(550, 390, 130, 30);
        add(returned);

        returnedl = new JLabel("");
        returnedl.setFont(new Font("Tahoma", Font.PLAIN, 15));
        returnedl.setBounds(690, 390, 200, 30);
        add(returnedl);
        
        pht.addActionListener(ae -> {
            try {
                conn c = new conn();
                String qwry = "Select id, name, email from customer where phone = " + pht.getText();
                ResultSet rs = c.s.executeQuery(qwry);
                while (rs.next()) {
                    idl.setText(rs.getString(1));
                    namel.setText(rs.getString(2));
                    emaill.setText(rs.getString(3));
                }
            } catch (Exception e) {
            }
        });

        c1 = new Choice();
        c1.setBounds(650, 65, 100, 30);
        add(c1);

        dcb = new JCheckBox();
        dcb.setBackground(Color.white);
        dcb.setForeground(Color.white);
        dcb.setBounds(750, 60, 100, 30);
        dcb.addActionListener(this);
        add(dcb);

        c2 = new Choice();
        c2.setBounds(370, 105, 100, 30);
        add(c2);
        
        tcb = new JCheckBox();
        tcb.setBackground(Color.white);
        tcb.setForeground(Color.white);
        tcb.setBounds(470, 100, 20, 30);
        tcb.addActionListener(this);
        add(tcb);

        b2 = new JButton("New..");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(570, 530, 100, 30);
        b2.addActionListener(ae ->{
            this.setVisible(false);
            new showBill().setVisible(true);
        });
        add(b2);

        b3 = new JButton("Cancel");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.setBounds(570, 610, 100, 30);
        b3.addActionListener(ae ->{
            this.setVisible(false);
        });
        add(b3);

        ImageIcon img = new ImageIcon(getClass().getResource("\\Icons\\showBill.gif"));
        Image im = img.getImage().getScaledInstance(400, 340, Image.SCALE_DEFAULT);
        ImageIcon img2 = new ImageIcon(im);
        JLabel img3 = new JLabel(img2);
        img3.setBounds(0, 420, 400, 340);
        add(img3);

        getContentPane().setBackground(Color.WHITE);

        setUndecorated(true);
        setLayout(null);
        setBounds(680, 100, 800, 700);
        setVisible(true);
    }
    public static void main(String[] args) {
        new showBill();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == dcb){
            if(dcb.isSelected()){
                
                try {
                    conn c = new conn();
                    String qry = "select distinct date from bills where id = " + idl.getText();
                    ResultSet rs = c.s.executeQuery(qry);
                    while (rs.next()) {
                        c1.add(rs.getString("date"));
                    }
                } catch (Exception e) {}
                
            } else {
                c1.removeAll();
            }
        }
        if(ae.getSource() == tcb){
            if(tcb.isSelected()){
                try {
                    String datel = c1.getSelectedItem();
                    conn c = new conn();
                    String qry = "select distinct bID, id from bills where date = '" + datel +"' and id = '" + idl.getText() + "'";
                    ResultSet rs = c.s.executeQuery(qry);
                    while (rs.next()) {
                        c2.add(rs.getString("bID"));
                    }
                } catch (Exception e) {}
            } else {
                c2.removeAll();
            }
        }
        if(ae.getSource() == b1){
            model.setRowCount(0);
            conn c = new conn();
            try {
                String qwr = "select b.name, b.type, b.price, b.quantity, b.subtotal,c.total, c.paid, c.returned from bills b,billdetail c where c.bID = "+ c2.getSelectedItem() +" and b.bID = " + c2.getSelectedItem();
                ResultSet rs2 = c.s.executeQuery(qwr);
                while(rs2.next()){
                    model.addRow(new Object[] { rs2.getString(1),rs2.getString(2),rs2.getString(3),rs2.getString(4),rs2.getString(5)});
                    totall.setText(rs2.getString(6));
                    paidl.setText(rs2.getString(7));
                    returnedl.setText(rs2.getString(8));
                }
            } catch (Exception e) {}
        }
    }
}
