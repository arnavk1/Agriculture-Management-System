package ANMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class billGenerator extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13;
    JButton b1, b2, b3, b4, delete3;
    JTable ta1;
    JScrollPane pane;
    float tPrice;
    float subtotal = 1;
    float aQuant = 0;
    
    Connection consn;
    PreparedStatement ps, ps2;
    int bID;
    DefaultTableModel model;

    billGenerator() {
        ImageIcon i1 = new ImageIcon(getClass().getResource("\\Icons\\billing background.png"));
        Image img3 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        JLabel img = new JLabel(new ImageIcon(img3));
        img.setBounds(0, 0, 1000, 700);
        add(img);

        ImageIcon i2 = new ImageIcon(getClass().getResource("\\Icons\\billicon.png"));
        Image img2 = i2.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        JLabel img4 = new JLabel(new ImageIcon(img2));
        img4.setBounds(50, 20, 90, 90);
        img.add(img4);

        ImageIcon i3 = new ImageIcon(getClass().getResource("\\Icons\\Billing.gif"));
        Image img5 = i3.getImage().getScaledInstance(400, 120, Image.SCALE_DEFAULT);
        JLabel img6 = new JLabel(new ImageIcon(img5));
        img6.setBounds(160, 10, 400, 130);
        img.add(img6);

        l1 = new JLabel("Date:");
        l1.setFont(new Font("Tahoma", Font.BOLD, 18));
        l1.setBounds(700, 30, 60, 40);
        img.add(l1);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        JLabel dt = new JLabel();
        dt.setFont(new Font("Tahoma", Font.BOLD, 18));
        dt.setBounds(780, 31, 120, 40);
        dt.setText(sdf.format(date));
        img.add(dt);

        l2 = new JLabel("Time:");
        l2.setFont(new Font("Tahoma", Font.BOLD, 18));
        l2.setBounds(700, 60, 60, 40);
        img.add(l2);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.now();
        JLabel time = new JLabel();
        time.setFont(new Font("Tahoma", Font.BOLD, 18));
        time.setBounds(780, 61, 120, 40);
        time.setText(dtf.format(ldt));
        img.add(time);

        JSeparator sep1 = new JSeparator();
        sep1.setBounds(0, 140, 1000, 20);
        img.add(sep1);

        l3 = new JLabel("Customer Details:");
        l3.setFont(new Font("Tahoma", Font.BOLD, 25));
        l3.setBounds(20, 150, 260, 40);
        img.add(l3);

        l4 = new JLabel("ID:");
        l4.setFont(new Font("Tahoma", Font.BOLD, 18));
        l4.setBounds(300, 153, 40, 40);
        img.add(l4);

        t1 = new JTextField();
        t1.setBounds(350, 156, 40, 30);
        t1.setEditable(false);
        img.add(t1);

        l5 = new JLabel("Name:");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l5.setBounds(20, 205, 60, 40);
        img.add(l5);

        t2 = new JTextField();
        t2.setBounds(90, 210, 110, 30);
        img.add(t2);

        l6 = new JLabel("Phone No:");
        l6.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l6.setBounds(220, 205, 90, 40);
        img.add(l6);

        t3 = new JTextField();
        t3.setBounds(320, 210, 110, 30);
        img.add(t3);

        l7 = new JLabel("Email:");
        l7.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l7.setBounds(450, 205, 60, 40);
        img.add(l7);

        t4 = new JTextField();
        t4.setBounds(520, 210, 150, 30);
        img.add(t4);

        l8 = new JLabel("Address:");
        l8.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l8.setBounds(690, 205, 80, 40);
        img.add(l8);

        t5 = new JTextField();
        t5.setBounds(780, 210, 180, 30);
        img.add(t5);

        t3.addActionListener(ae -> {
            try {
                conn c = new conn();
                String qwry = "Select * from customer where phone = " + t3.getText();
                ResultSet rs = c.s.executeQuery(qwry);
                while (rs.next()) {
                    t1.setText(rs.getString(1));
                    t2.setText(rs.getString(2));
                    t4.setText(rs.getString(6));
                    t5.setText(rs.getString(7));
                }
            } catch (Exception e) {
            }
        });

        JSeparator sep2 = new JSeparator();
        sep2.setBounds(0, 250, 1000, 20);
        img.add(sep2);

        l9 = new JLabel("Commodities Details:");
        l9.setFont(new Font("Tahoma", Font.BOLD, 25));
        l9.setBounds(20, 260, 300, 40);
        img.add(l9);

        l10 = new JLabel("ID:");
        l10.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l10.setBounds(20, 315, 30, 40);
        img.add(l10);

        t6 = new JTextField();
        t6.setBounds(60, 320, 40, 30);
        img.add(t6);

        l11 = new JLabel("Name:");
        l11.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l11.setBounds(120, 315, 60, 40);
        img.add(l11);

        t7 = new JTextField();
        t7.setBounds(190, 320, 110, 30);
        img.add(t7);

        l12 = new JLabel("Type:");
        l12.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l12.setBounds(320, 315, 60, 40);
        img.add(l12);

        t8 = new JTextField();
        t8.setBounds(390, 320, 150, 30);
        img.add(t8);

        l13 = new JLabel("Rate:  ");
        l13.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l13.setBounds(560, 315, 55, 40);
        img.add(l13);

        ImageIcon ii = new ImageIcon(getClass().getResource("\\Icons\\rs.png"));
        Image ii1 = ii.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        JLabel il = new JLabel(new ImageIcon(ii1));
        il.setBounds(610, 325, 20, 20);
        img.add(il);

        t9 = new JTextField();
        t9.setBounds(635, 320, 150, 30);
        img.add(t9);

        l14 = new JLabel("Quantity:");
        l14.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l14.setBounds(800, 315, 80, 40);
        img.add(l14);

        t10 = new JTextField();
        t10.setBounds(890, 320, 50, 30);
        img.add(t10);

        JLabel kg = new JLabel("Kg");
        kg.setBounds(945, 320, 30, 30);
        img.add(kg);

        t6.addActionListener(ae -> {
            try {
                conn c = new conn();
                String qwrt = "Select * from crops where id = " + t6.getText();
                ResultSet rs = c.s.executeQuery(qwrt);
                while (rs.next()) {
                    t7.setText(rs.getString(6));
                    t8.setText(rs.getString(5));
                    t9.setText(rs.getString(8));
                }
            } catch (Exception e) {
            }
        });

        ImageIcon ii3 = new ImageIcon(getClass().getResource("\\Icons\\add.png"));
        Image ii2 = ii3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        b1 = new JButton("Add", new ImageIcon(ii2));
        b1.setBounds(860, 360, 80, 30);
        img.add(b1);

        JSeparator sep3 = new JSeparator();
        sep3.setBounds(0, 400, 1000, 20);
        img.add(sep3);

        ImageIcon delete1 = new ImageIcon(getClass().getResource("\\Icons\\delete.png"));
        Image delete2 = delete1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        delete3 = new JButton(new ImageIcon(delete2));
        delete3.setBounds(450, 405, 30, 30);
        delete3.setBackground(Color.white);
        img.add(delete3);

        DefaultTableModel d = new DefaultTableModel();
        d.addColumn("Name");
        d.addColumn("Type");
        d.addColumn("Quantity");
        d.addColumn("Rate");
        d.addColumn("SubTotal");
        ta1 = new JTable(d);
        pane = new JScrollPane(ta1);
        pane.setBounds(20, 440, 500, 220);
        img.add(pane);

        l15 = new JLabel("Details:");
        l15.setFont(new Font("Tahoma", Font.BOLD, 25));
        l15.setBounds(540, 440, 200, 40);
        img.add(l15);

        l16 = new JLabel("Total Amount:");
        l16.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l16.setBounds(540, 500, 150, 40);
        img.add(l16);

        t11 = new JTextField();
        t11.setText("0.0");
        t11.setBounds(700, 505, 150, 30);
        img.add(t11);

        l17 = new JLabel("Paid Amount:");
        l17.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l17.setBounds(540, 560, 150, 40);
        img.add(l17);

        t12 = new JTextField();
        t12.setBounds(700, 565, 150, 30);
        img.add(t12);

        l17 = new JLabel("Return Amount:");
        l17.setFont(new Font("Tahoma", Font.PLAIN, 18));
        l17.setBounds(540, 620, 150, 40);
        img.add(l17);

        t13 = new JTextField();
        t13.setBounds(700, 625, 150, 30);
        img.add(t13);

        t12.addActionListener(ae -> {
            float returned = Float.parseFloat(t12.getText()) - Float.parseFloat(t11.getText());
            t13.setText(String.valueOf(returned));
        });

        try {
            String st = "insert into bills(id, name, type, price, quantity, subtotal, date, time, bID) values(?,?,?,?,?,?,?,?,?)";
            String st2 = "delete from bills where id = ? and name = ? and quantity = ? and time = ?";
            Class.forName("com.mysql.jdbc.Driver");
            consn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectanms", "root", "rootroot");
            ps = consn.prepareStatement(st);
            ps2 = consn.prepareStatement(st2);
        } catch (Exception e) {
        }

        b1.addActionListener(ae -> {
            float price = Float.parseFloat(t9.getText());
            float quant = Float.parseFloat(t10.getText());
            subtotal = price * quant;
            String stotal = String.valueOf(subtotal);
            model = (DefaultTableModel) ta1.getModel();
            model.addRow(new Object[] { t7.getText(), t8.getText(), t10.getText(), t9.getText(), subtotal });
            tPrice = Float.parseFloat(t11.getText())+ subtotal;
            String tPrice1 = String.valueOf(tPrice);

            t11.setText(tPrice1);
            try {
                ps.setString(1, t1.getText());
                ps.setString(2, t7.getText());
                ps.setString(3, t8.getText());
                ps.setString(4, t9.getText());
                ps.setString(5, t10.getText());
                ps.setString(6, stotal);
                ps.setString(7, dt.getText());
                ps.setString(8, time.getText());
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select max(bID) from billdetail");
                while (rs.next()) {
                    bID = rs.getInt(1);
                    bID += 1;
                }
                ps.setString(9, String.valueOf(bID));
                ps.addBatch();
            } catch (Exception e) {
                System.out.println(e);
            }
            t6.setText("");
            t7.setText("");
            t8.setText("");
            t9.setText("");
            t10.setText("");
        });

        delete3.addActionListener(ae -> {
            try {
                float totalAmt = Float.parseFloat(t11.getText());
                int row = ta1.getSelectedRow();
                model = (DefaultTableModel) ta1.getModel();
                String a = String.valueOf(model.getValueAt(row, 0));
                String b = String.valueOf(model.getValueAt(row, 2));
                ps2.setString(1, t1.getText());
                ps2.setString(2, a);
                ps2.setString(3, b);
                ps2.setString(4, time.getText());
                ps2.addBatch();
                float newTotal = totalAmt - Float.parseFloat(String.valueOf(model.getValueAt(row, 4)));
                t11.setText(String.valueOf(newTotal));
                model.removeRow(row);
            } catch (Exception e) {
                //TODO: handle exception
            }
        });

        ImageIcon ii4 = new ImageIcon(getClass().getResource("\\Icons\\save.png"));
        b2 = new JButton("Save", ii4);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setBounds(870, 505, 100, 30);
        b2.addActionListener(ae -> {
            try {
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select max(bID) from billdetail");
                while (rs.next()) {
                    bID = rs.getInt(1);
                    bID += 1;
                }
                String qwry1 = "insert into billdetail values('" + bID + "','" + t11.getText() + "','" + t12.getText()
                        + "','" + t13.getText() + "','" + dt.getText() + "')";
                c.s.executeUpdate(qwry1);

                ps.executeBatch();
                ps2.executeBatch();

                String availableq = "";

                String name = t2.getText();
                String Phone = t3.getText();
                String email = t4.getText();
                String address = t5.getText();
                String path = "E:\\java\\Project\\AgricultureNurseryManagement\\billPDF\\bill";
                try {
                    com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
                    PdfWriter.getInstance(doc, new FileOutputStream(path + "" + name + " " + dt.getText() + ".pdf"));
                    doc.open();
                    Paragraph p1 = new Paragraph(
                            "                                           Agriculture Management System\n                                         Contact Number: (+91)8708212700\n\n");
                    doc.add(p1);
                    Paragraph p2 = new Paragraph("Billing ID: " + bID + "\nDate and Time: " + dt.getText() + "   "
                            + time.getText() + "\nBuyer Details:\nName: " + name + "\nContact No.:(+91)" + Phone
                            + "\nEmail: " + email + "\nAddress: " + address + "\n\n");
                    doc.add(p2);
                    PdfPTable tb1 = new PdfPTable(5);
                    tb1.addCell("Name");
                    tb1.addCell("Type");
                    tb1.addCell("Quantity (KG)");
                    tb1.addCell("Rate (Rs.)");
                    tb1.addCell("Subtotal");
                    model = (DefaultTableModel) ta1.getModel();
                    for (int i = 0; i < model.getRowCount(); i++) {
                        String p = model.getValueAt(i, 0).toString();
                        String q = model.getValueAt(i, 1).toString();
                        String r = model.getValueAt(i, 2).toString();
                        String s = model.getValueAt(i, 3).toString();
                        String t = model.getValueAt(i, 4).toString();
                        tb1.addCell(p);
                        tb1.addCell(q);
                        tb1.addCell(r);
                        tb1.addCell(s);
                        tb1.addCell(t);
                        try {
                            String qwry2 = "select co.aq from commodities co,crops c where c.id in(select id from crops where cName = '"+ p +"') and co.id = c.id";
                            ResultSet rs2 = c.s.executeQuery(qwry2);
                            while (rs2.next()) {
                                availableq = rs2.getString(1);
                            }

                            float aQuant = Float.parseFloat(availableq) - Float.parseFloat(r);
                            String avQuant = String.valueOf(aQuant);
                            String qwry3 = "update commodities set aq = '" + avQuant + "' where id in(select id from crops where cName = '"+ p + "')";
                            c.s.executeUpdate(qwry3);
                        } catch (SQLException e) {
                            System.out.println(e);
                        }
                        
                    }
                    doc.add(tb1);
                    Paragraph p3 = new Paragraph("\nTotal: " + t11.getText() + "\nPaid Amount: " + t12.getText()
                            + "\nReturned Amount: " + t13.getText());
                    Paragraph p4 = new Paragraph(
                            "\n\n*******************************Thanks for your Visit.Visit Again*******************************\nHead:\nArnav Kashyap");
                    doc.add(p3);
                    doc.add(p4);
                    doc.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();

                } catch (DocumentException e) {
                    e.printStackTrace();
                }

                model = (DefaultTableModel) ta1.getModel();
                while (model.getRowCount() != 0) {
                    model.removeRow(0);
                }
                ps.clearBatch();

                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t11.setText("");
                t12.setText("");
                t13.setText("");

            } catch (SQLException e) {
                System.out.println(e);
            }
            JOptionPane.showMessageDialog(this, "Bill Generated");
        });
        img.add(b2);

        ImageIcon ii5 = new ImageIcon(getClass().getResource("\\Icons\\reset.png"));
        b3 = new JButton("Reset", ii5);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        b3.setBounds(870, 565, 100, 30);
        b3.addActionListener(ae -> {
            this.setVisible(false);
            new billGenerator().setVisible(true);
        });
        img.add(b3);

        ImageIcon ii6 = new ImageIcon(getClass().getResource("\\Icons\\close.png"));
        b4 = new JButton("Cancel", ii6);
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.white);
        b4.setBounds(870, 625, 100, 30);
        b4.addActionListener(ae -> {
            this.setVisible(false);
            try {
                ps.clearBatch();
            } catch (SQLException e) {}
        });
        img.add(b4);

        setUndecorated(true);
        setLayout(null);
        setBounds(480, 100, 1000, 700);
        setVisible(true);
    }
    public static void main(String[] args) {
        new billGenerator().setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
    }
}