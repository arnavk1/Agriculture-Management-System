package ANMS;

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class loginPage extends JFrame implements ActionListener{
    
    JButton b1, b2;
    JTextField t1;
    JPasswordField t2;
    JCheckBox c1;
    int z = 0;
    loginPage(){
        
        ImageIcon ii1 = new ImageIcon(getClass().getResource("\\Icons\\loginbg.jpg"));
        Image iii = ii1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(iii);
        JLabel bgimg = new JLabel(ii3);
        bgimg.setBounds(0, 0, 400, 500);
        add(bgimg);

        // JPanel pl = new JPanel();
        // pl.setBounds(20, 20, 360, 470);
        // pl.setBackground(Color.white);
        // bgimg.add(pl);

        ImageIcon i1 = new ImageIcon(getClass().getResource("\\Icons\\login.gif"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(50, -40, 300, 300);
        bgimg.add(l1);

        JLabel l2 = new JLabel("User Name");
        l2.setFont(new Font("Tahoma",Font.BOLD,18));
        l2.setForeground(Color.white);
        l2.setBounds(30, 300, 150, 30);
        bgimg.add(l2);

        t1 = new JTextField();
        t1.setBounds(210, 300, 150, 30);
        bgimg.add(t1);

        JLabel l3 = new JLabel("Password");
        l3.setFont(new Font("Tahoma",Font.BOLD,18));
        l3.setForeground(Color.white);
        l3.setBounds(30, 350, 150, 30);
        bgimg.add(l3);

        t2 = new JPasswordField(10);
        t2.setEchoChar('*');
        t2.setBounds(210, 350, 150, 30);
        bgimg.add(t2);

        ImageIcon i4 = new ImageIcon(getClass().getResource("\\Icons\\cancel.jpg"));
        Image i5 = i4.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        
        ImageIcon i6 = new ImageIcon(getClass().getResource("\\Icons\\correct.png"));
        Image i7 = i6.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        
        ImageIcon ii = new ImageIcon(getClass().getResource("\\Icons\\show.png"));
        Image i = ii.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon ii2 = new ImageIcon(i);
        JLabel jl = new JLabel(ii2);
        jl.setBounds(210, 380, 30, 30);
        bgimg.add(jl);
        jl.addMouseListener(new MouseListener() {

			@Override
            public void mouseClicked(MouseEvent e) {
                if(z == 0){
                    t2.setEchoChar((char)0);
                    z = 1;
                }
                else{
                    t2.setEchoChar('*');
                    z = 0;
                }

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });
    

        // c1 = new JCheckBox(ii2);
        // c1.setLocation(210, 380);
        // c1.setBackground(Color.white);
        // c1.addItemListener(new ItemListener() {

        //     @Override
        //     public void itemStateChanged(ItemEvent e) {
        //         if(e.getStateChange() == 1)
        //             t2.setEchoChar((char)0);
        //         else{
        //             t2.setEchoChar('*');
        //         }
        //     }
        // });
        // bgimg.add(c1);


        b1 = new JButton("Login", new ImageIcon(i7));
        b1.setBounds(30, 450, 150, 30);
        b1.addActionListener(this);
        bgimg.add(b1);

        b2 = new JButton("Cancel", new ImageIcon(i5));
        b2.setBounds(210, 450, 150, 30);
        b2.addActionListener(this);
        bgimg.add(b2);

        setUndecorated(true);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new loginPage().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            String uname = t1.getText();
            String pass = t2.getText();

            conn c = new conn();
            String str = "select * from login where uname = '"+uname+"' and password = md5('"+pass+"')";
            try {
                
                ResultSet rs = c.s.executeQuery(str);
                if(rs.next()){
                    new progressbar(uname).setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "User Name or Password is Wrong");
                    this.setVisible(false);
                    System.exit(0);
                }
            } catch (Exception e) {}

        }else if(ae.getSource() == b2) {
            this.setVisible(false);
            System.exit(0);
        }
    }
}
