package ANMS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class addCustomer extends JFrame implements ActionListener{
    JTable ta1;
    DefaultTableModel tm;
    JScrollPane pane;
    JButton update, cancel;
    JLabel id, idNo, name, age, gender, phone, email, address;
    JTextField nameT, ageT, genderT, phoneT, emailT, addressT;

    addCustomer(){
        ImageIcon img1 = new ImageIcon(getClass().getResource("\\Icons\\addCustomer.jpg"));
        Image img2 = img1.getImage().getScaledInstance(450, 350, Image.SCALE_DEFAULT);
        JLabel bgImg = new JLabel(new ImageIcon(img2));
        bgImg.setBounds(350, 200, 450,350);
        add(bgImg);

        JLabel head = new JLabel("Add Customers");
        head.setFont(new Font("Tahoma", Font.BOLD, 25));
        head.setBounds(300, 5, 200, 30);
        add(head);

        id = new JLabel("ID");
        id.setFont(new Font("Tahoma", Font.BOLD, 18));
        id.setBounds(30, 100, 30, 30);
        add(id);

        idNo = new JLabel("");
        idNo.setFont(new Font("Tahoma", Font.BOLD, 18));
        idNo.setBounds(160, 100, 200, 30);
        try {
            conn c = new conn();
            ResultSet rs = c.s.executeQuery("select max(id) from customer");
            rs.next();
            idNo.setText(String.valueOf(Integer.parseInt(rs.getString(1))+1));
        } catch (Exception e) {
            //TODO: handle exception
        }
        add(idNo);

        name = new JLabel("Name");
        name.setFont(new Font("Tahoma", Font.BOLD, 18));
        name.setBounds(30, 160, 120, 30);
        add(name);

        nameT = new JTextField();
        nameT.setBounds(160, 160, 150, 30);
        add(nameT);

        age = new JLabel("Age");
        age.setFont(new Font("Tahoma", Font.BOLD, 18));
        age.setBounds(30, 220, 120, 30);
        add(age);

        ageT = new JTextField();
        ageT.setBounds(160, 220, 150, 30);
        add(ageT);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Tahoma", Font.BOLD, 18));
        gender.setBounds(30, 280, 120, 30);
        add(gender);

        genderT = new JTextField();
        genderT.setBounds(160, 280, 150, 30);
        add(genderT);

        phone = new JLabel("Phone No.");
        phone.setFont(new Font("Tahoma", Font.BOLD, 18));
        phone.setBounds(30, 340, 120, 30);
        add(phone);

        phoneT = new JTextField();
        phoneT.setBounds(160, 340, 150, 30);
        add(phoneT);

        email = new JLabel("Email");
        email.setFont(new Font("Tahoma", Font.BOLD, 18));
        email.setBounds(30, 400, 120, 30);
        add(email);

        emailT = new JTextField();
        emailT.setBounds(160, 400, 150, 30);
        add(emailT);

        address = new JLabel("Address");
        address.setFont(new Font("Tahoma", Font.BOLD, 18));
        address.setBounds(30, 460, 120, 30);
        add(address);

        addressT = new JTextField();
        addressT.setBounds(160, 460, 150, 30);
        add(addressT);
        

        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(120, 550, 150, 40);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(120, 630, 150, 40);
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(Color.WHITE);

        setUndecorated(true);
        setLayout(null);
        setBounds(680, 100, 800, 700);
        setVisible(true);
    }
    public static void main(String[] args) {
        new addCustomer();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == update){
            conn c = new conn();
            String qwry = "insert into customer values('"+idNo.getText()+"','"+nameT.getText()+"','"+ageT.getText()+"','"+genderT.getText()+"','"+phoneT.getText()+"','"+emailT.getText()+"','"+addressT.getText()+"')";
            try {
                c.s.executeUpdate(qwry);
                JOptionPane.showMessageDialog(this, "Employee Added Successfuly");
                setVisible(false);
            } catch (Exception e) {System.out.println(e);}
        } else if (ae.getSource() == cancel){
            this.setVisible(false);
        }
    }
}
