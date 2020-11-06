package ANMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class showCustomers extends JFrame implements ActionListener{
    JTable ta1;
    DefaultTableModel tm;
    JScrollPane pane;
    JButton show, cancel;
    int count = 0;
    JLabel id;
    JTextField idField;

    showCustomers(){
        id = new JLabel("ID");
        id.setFont(new Font("Tahoma", Font.BOLD, 18));
        id.setBounds(300, 5, 30, 30);
        add(id);

        idField = new JTextField();
        idField.setBounds(360, 5, 40, 30);
        add(idField);

        tm = new DefaultTableModel();
        tm.addColumn("ID");
        tm.addColumn("Name");
        tm.addColumn("Age");
        tm.addColumn("Gender");
        tm.addColumn("Phone No.");
        tm.addColumn("Email");
        tm.addColumn("Address");
        ta1 = new JTable(tm);
        pane = new JScrollPane(ta1);
        ta1.getColumnModel().getColumn(0).setPreferredWidth(20);
        ta1.getColumnModel().getColumn(2).setPreferredWidth(40);
        ta1.getColumnModel().getColumn(3).setPreferredWidth(30);
        ta1.getColumnModel().getColumn(4).setPreferredWidth(40);
        pane.setBounds(30, 40, 740, 580);
        add(pane);

        show = new JButton("Show");
        show.setBackground(Color.black);
        show.setForeground(Color.white);
        show.setBounds(230, 650, 150, 40);
        show.addActionListener(this);
        add(show);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(460, 650, 150, 40);
        cancel.addActionListener(this);
        add(cancel);

        idField.addActionListener(ae -> {
            tm.setRowCount(0);
            conn c = new conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from customer = '"+idField.getText()+"'");
                while(rs.next()){
                    tm.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
                }
            } catch (Exception e) {
                //TODO: handle exception
            }
        });


        getContentPane().setBackground(Color.WHITE);

        setUndecorated(true);
        setLayout(null);
        setBounds(680, 100, 800, 700);
        setVisible(true);
    }
    public static void main(String[] args) {
        new showCustomers();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == show){
            count++;
            conn c = new conn();
            String qwry = "select * from customer";
            tm = (DefaultTableModel) ta1.getModel();
            if(count >= 1){
                tm.setRowCount(0);
                count = 0;
            }
            try {
                ResultSet rs = c.s.executeQuery(qwry);
                while(rs.next()){
                    tm.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)});
                }
            } catch (Exception e) {}
        } else if (ae.getSource() == cancel){
            this.setVisible(false);
        }
    }
}
