package ANMS;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;


public class dashboard extends JFrame implements ActionListener,MouseListener,ComponentListener{
    
    private static final String String = null;
    int flag = 0;
    JMenuBar mb;
    JMenu m1,m2;
    JButton b0,b1,b2,b3,b4,b5,b6,b7;
    JMenuItem i1,i2,i3,i4;
    JLabel l1,l3,l4,l5,l6,l7,l8;

    dashboard(String uname){
        mb = new JMenuBar();
        mb.setBounds(0, 0, 1600, 40);
        add(mb);

        m1 = new JMenu("Nursery Management");
        mb.add(m1);
        m2 = new JMenu("Help");
        mb.add(m2);

        m1.setForeground(Color.red);
        m2.setForeground(Color.BLUE);
        
        i1 = new JMenuItem("Reception");
        i1.addActionListener(this);
        m1.add(i1);
        i2 = new JMenuItem("About");
        i2.addActionListener(this);
        m2.add(i2);

        ImageIcon i1 = new ImageIcon(getClass().getResource("\\Icons\\dashboard.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1560, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1 = new JLabel(i3);
        l1.setBounds(0, 0, 1560, 900);
        add(l1);

        conn c = new conn();
        String name = null;
        String str = "Select name from login where uname = '"+ uname +"'";
        try {
            ResultSet rs = c.s.executeQuery(str);
            while(rs.next()){
                name = rs.getString("name");
            }
        } catch (Exception e) {}

        JLabel l2 = new JLabel("Welcome, "+name);
        l2.setBounds(70, 80, 500, 40);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Tahoma", Font.ITALIC, 36));
        l1.add(l2);
        
        ImageIcon ii = new ImageIcon(getClass().getResource("\\Icons\\list.png"));
        Image img = ii.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);

        b0 = new JButton(new ImageIcon(img));
        b0.setBounds(80, 150, 80, 80);
        b0.setBackground(Color.black);
        b0.setOpaque(false);
        b0.setBorderPainted(false);
        b0.addMouseListener(this);
        l1.add(b0);

        ImageIcon i4 = new ImageIcon(getClass().getResource("\\Icons\\addemployee.png"));
        Image i5 = i4.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);


        b1 = new JButton(new ImageIcon(i5));
        b1.setBounds(80, 250, 80, 80);
        b1.setBackground(Color.white);
        b1.setOpaque(false);
        b1.setBorderPainted(false);
        b1.addComponentListener(this);
        b1.addActionListener(this);
        l1.add(b1);

        l3 = new JLabel("Add Employee");
        l3.setFont(new Font("Tahoma",Font.BOLD,20));
        l3.setForeground(Color.BLUE);
        l3.setBounds(180, 275, 200, 30);
        l3.addComponentListener(this);
        l1.add(l3);

        ImageIcon ii1 = new ImageIcon(getClass().getResource("\\Icons\\farmer.png"));
        Image ii2 = ii1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);

        b2 = new JButton(new ImageIcon(ii2));
        b2.setBounds(80, 350, 80, 80);
        b2.setBackground(Color.white);
        b2.addComponentListener(this);
        b2.addActionListener(this);
        l1.add(b2);

        l4 = new JLabel("Add Farmer");
        l4.setFont(new Font("Tahoma",Font.BOLD,20));
        l4.setForeground(Color.BLUE);
        l4.setBounds(180, 375, 200, 30);
        l4.addComponentListener(this);
        l1.add(l4);

        ImageIcon i6 = new ImageIcon(getClass().getResource("\\Icons\\addcrop.png"));
        Image i7 = i6.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);

        b3 = new JButton(new ImageIcon(i7));
        b3.setBounds(80, 450, 80, 80);
        b3.setBackground(Color.white);
        b3.addComponentListener(this);
        b3.addActionListener(this);
        l1.add(b3);

        l5 = new JLabel("Add Crop");
        l5.setFont(new Font("Tahoma",Font.BOLD,20));
        l5.setForeground(Color.BLUE);
        l5.setBounds(180, 475, 200, 30);
        l5.addComponentListener(this);
        l1.add(l5);

        ImageIcon i12 = new ImageIcon(getClass().getResource("\\Icons\\addfer.png"));
        Image i13 = i12.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);

        b4 = new JButton(new ImageIcon(i13));
        b4.setBounds(80, 550, 80, 80);
        b4.setBackground(Color.white);
        b4.addComponentListener(this);
        b4.addActionListener(this);
        l1.add(b4);

        l6 = new JLabel("Add Fertilizers");
        l6.setFont(new Font("Tahoma",Font.BOLD,20));
        l6.setForeground(Color.BLUE);
        l6.setBounds(180, 575, 200, 30);
        l6.addComponentListener(this);
        l1.add(l6);

        ImageIcon i8 = new ImageIcon(getClass().getResource("\\Icons\\addcom.png"));
        Image i9 = i8.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);

        b5 = new JButton(new ImageIcon(i9));
        b5.setBounds(80, 650, 80, 80);
        b5.setBackground(Color.white);
        b5.addComponentListener(this);
        b5.addActionListener(this);
        l1.add(b5);

        l7 = new JLabel("Add Commodities");
        l7.setFont(new Font("Tahoma",Font.BOLD,20));
        l7.setForeground(Color.BLUE);
        l7.setBounds(180, 675, 200, 30);
        l7.addComponentListener(this);
        l1.add(l7);

        ImageIcon i10 = new ImageIcon(getClass().getResource("\\Icons\\bill.png"));
        Image i11 = i10.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);        

        b6 = new JButton(new ImageIcon(i11));
        b6.setBounds(80, 750, 80, 80);
        b6.setBackground(Color.white);
        b6.addComponentListener(this);
        b6.addActionListener(this);
        l1.add(b6);

        l8 = new JLabel("Billing");
        l8.setFont(new Font("Tahoma",Font.BOLD,20));
        l8.setForeground(Color.BLUE);
        l8.setBounds(180, 775, 130, 30);
        l8.addComponentListener(this);
        l1.add(l8);

        ImageIcon img1 = new ImageIcon(getClass().getResource("\\Icons\\logout.png"));
        Image img2 = img1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);        

        b7 = new JButton(new ImageIcon(img2));
        b7.setBounds(180, 150, 80, 80);
        b7.setBackground(Color.white);
        b7.setOpaque(false);
        b7.setBorderPainted(false);
        b7.addComponentListener(this);
        b7.addActionListener(this);
        l1.add(b7);


        b1.setVisible(false);
        b2.setVisible(false);
        b3.setVisible(false);
        b4.setVisible(false);
        b5.setVisible(false);
        b6.setVisible(false);
        b7.setVisible(false);

        l3.setVisible(false);
        l4.setVisible(false);
        l5.setVisible(false);
        l6.setVisible(false);
        l7.setVisible(false);
        l8.setVisible(false);

        setUndecorated(true);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    public static void main(String[] args) {
        new dashboard(String).setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1){
            new addEmployee().setVisible(true);
        }else if(ae.getSource() == b2){
            new addFarmer().setVisible(true);
        }else if(ae.getSource() == b3){
            new addCrop().setVisible(true);
        }else if(ae.getSource() == b4){
            new addFertilizer().setVisible(true);
        }else if(ae.getSource() == b5){
            new addCommodities().setVisible(true);
        }else if(ae.getSource() == b6){
            new billGenerator().setVisible(true);
        }else if(ae.getSource() == b7){
           int ans = JOptionPane.showConfirmDialog(null, "Do You Want To Logout", "LogOut", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
            if(ans == 0){
                JOptionPane.showMessageDialog(null, "You Have been logged out successfully");
                this.setVisible(false);
                new loginPage().setVisible(true);
            }
        }else if(ae.getActionCommand().equals("Reception")){
            new reception().setVisible(true);
        }else if(ae.getActionCommand().equals("About")){
            new IntroPage().setVisible(true);
            this.setVisible(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource() == b0){
            if(flag == 0){
                try {
                    Thread.sleep(500);
                } catch (Exception e) {}
                b1.setVisible(true);
                l3.setVisible(true);
            } else {
                b1.setVisible(false);
                b2.setVisible(false);
                b3.setVisible(false);
                b4.setVisible(false);
                b5.setVisible(false);
                b6.setVisible(false);
                b7.setVisible(false);
                
                l3.setVisible(false);
                l4.setVisible(false);
                l5.setVisible(false);
                l6.setVisible(false);
                l7.setVisible(false);
                l8.setVisible(false);
                flag = 0;
            }
        }
    }
    @Override
    public void componentShown(ComponentEvent e) {
        if(flag == 0){
            Timer t1 = new Timer(250,new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    b2.setVisible(true);
                    b2.setOpaque(false);
                    b2.setBorderPainted(false);
                    l4.setVisible(true);
                }
            });
            t1.setRepeats(false);
            t1.start();
            Timer t2 = new Timer(500,new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    b3.setVisible(true);
                    b3.setOpaque(false);
                    b3.setBorderPainted(false);
                    l5.setVisible(true);
                }
            });
            t2.setRepeats(false);
            t2.start();
            Timer t3 = new Timer(750,new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    b4.setVisible(true);
                    b4.setOpaque(false);
                    b4.setBorderPainted(false);
                    l6.setVisible(true);
                }
            });
            t3.setRepeats(false);
            t3.start();
            Timer t4 = new Timer(1000,new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    b5.setVisible(true);
                    b5.setOpaque(false);
                    b5.setBorderPainted(false);
                    l7.setVisible(true);
                }
            });
            t4.setRepeats(false);
            t4.start();
            Timer t5 = new Timer(1250,new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    b6.setVisible(true);
                    b6.setOpaque(false);
                    b6.setBorderPainted(false);
                    l8.setVisible(true);
                }
            });
            t5.setRepeats(false);
            t5.start();
            Timer t6 = new Timer(0,new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    b7.setVisible(true);
                    b7.setOpaque(false);
                    b7.setBorderPainted(false);
                    flag = 1;
                }
            });
            t6.setRepeats(false);
            t6.start();
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
    
        @Override
        public void componentResized(ComponentEvent e) {
            // TODO Auto-generated method stub
    
        }
    
        @Override
        public void componentMoved(ComponentEvent e) {
            // TODO Auto-generated method stub
    
        }
    
    @Override
    public void componentHidden(ComponentEvent e) {
        // TODO Auto-generated method stub

    }

}
