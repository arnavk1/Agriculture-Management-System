package ANMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class showEmployee extends JFrame implements ActionListener{
    JTable ta1;
    DefaultTableModel tm;
    JScrollPane pane;
    JButton show, cancel;
    int count = 0;

    showEmployee(){

        tm = new DefaultTableModel();
        tm.addColumn("ID Number");
        tm.addColumn("Name");
        tm.addColumn("Gender");
        tm.addColumn("Position");
        tm.addColumn("Phone No.");
        tm.addColumn("Salary");
        tm.addColumn("Address");
        ta1 = new JTable(tm);
        pane = new JScrollPane(ta1);
        ta1.getColumnModel().getColumn(0).setPreferredWidth(60);
        ta1.getColumnModel().getColumn(2).setPreferredWidth(30);
        ta1.getColumnModel().getColumn(3).setPreferredWidth(50);
        ta1.getColumnModel().getColumn(4).setPreferredWidth(30);
        ta1.getColumnModel().getColumn(5).setPreferredWidth(30);
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


        getContentPane().setBackground(Color.WHITE);

        setUndecorated(true);
        setLayout(null);
        setBounds(680, 100, 800, 700);
        setVisible(true);
    }
    public static void main(String[] args) {
        new showEmployee();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == show){
            count++;
            conn c = new conn();
            String qwry = "select * from employee";
            tm = (DefaultTableModel) ta1.getModel();
            if(count >= 1){
                tm.setRowCount(0);
                count = 0;
            }
            try {
                ResultSet rs = c.s.executeQuery(qwry);
                while(rs.next()){
                    tm.addRow(new Object[] { rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)});
                }
            } catch (Exception e) {}
        } else if (ae.getSource() == cancel){
            this.setVisible(false);
        }
    }
}
