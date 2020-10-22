package ANMS;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.*;

public class progressbar extends JFrame implements ActionListener {

    private static final String String = null;
    JProgressBar p;
    int i = 0;
    String usname;
    
    progressbar(String uname) {
        usname = uname;

        ImageIcon i1 = new ImageIcon(getClass().getResource("\\Icons\\progress.jpg"));
        Image i = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i);
        JLabel l = new JLabel(i2);
        l.setBounds(0, 0, 500, 300);
        add(l);

        p = new JProgressBar(0, 100);
        p.setBounds(45, 80, 200, 40);
        p.setValue(0);
        p.setForeground(Color.blue);
        p.setBackground(Color.white);
        p.setStringPainted(true);
        p.setString("Sowing...");
        l.add(p);

        Timer t = new Timer(20, this);
        t.start();        

        setUndecorated(true);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        progressbar p1 = new progressbar(String);
        p1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(i == 100){
                this.setVisible(false);
                new dashboard(usname).setVisible(true);
            }
            i+=1;
            p.setValue(i);
    }
}
