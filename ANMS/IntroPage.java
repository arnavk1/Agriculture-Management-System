package ANMS;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class IntroPage extends JWindow implements ActionListener {
    JButton b1;
    JLabel l1, l2, l3, l4;
    Timer t;
    int flag = 0;

    IntroPage() {
        try {
            ImageIcon i1 = new ImageIcon(getClass().getResource("\\Icons\\intro.jpg"));
            l1 = new JLabel(i1);
            l1.setBounds(0, 0, 900, 600);
            add(l1);

            l2 = new JLabel("     Nursery Management System");
            l2.setBounds(30, 30, 1000, 100);
            l2.setForeground(Color.white);
            l2.setFont(new Font("serif", Font.ITALIC, 60));
            l1.add(l2);

            l3 = new JLabel("By: Arnav Kashyap");
            l3.setBounds(30, 300, 1000, 100);
            l3.setForeground(Color.white);
            l3.setFont(new Font("serif", Font.BOLD, 40));
            l1.add(l3);

            l4 = new JLabel("USN: 1RN18IS025");
            l4.setBounds(30, 350, 1000, 100);
            l4.setForeground(Color.white);
            l4.setFont(new Font("serif", Font.BOLD, 40));
            l1.add(l4);

            ImageIcon ii = new ImageIcon(getClass().getResource("\\Icons\\IntroIcon.png"));
            Image i3 = ii.getImage().getScaledInstance(100, 70, Image.SCALE_DEFAULT);
            ImageIcon i4 = new ImageIcon(i3);

            b1 = new JButton(i4);
            b1.setBackground(Color.white);
            b1.setForeground(Color.black);
            b1.setBounds(700, 500, 100, 50);
            b1.addActionListener(this);
            l1.add(b1);

            setLayout(null);
            setBounds(320, 100, 900, 600);
            setVisible(true);

            t = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(flag == 0){
                        l2.setVisible(false);
                        flag = 1;
                    } else {
                        l2.setVisible(true);
                        flag = 0;
                    }
                }
            });
            t.setRepeats(true);
            t.start();
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
       new IntroPage().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            new loginPage().setVisible(true);
            this.setVisible(false);
        }
    }
    
}
