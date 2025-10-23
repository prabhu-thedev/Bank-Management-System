package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_Class extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;

    String pin;
    main_Class(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1300,650);
        add(l3);

        JLabel label = new JLabel("Please Select Your Transaction");
        label.setBounds(350,130,400,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,24));
        l3.add(label);

        b1 = new JButton("DEPOSIT");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(340,215,160,25);
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("CASH WITHDRAWAL");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(555,215,160,25);
        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("FAST CASH");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(340,250,160,25);
        b3.setBorderPainted(false);
        b3.setFocusPainted(false);
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("MINI STATEMENT");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(555,250,160,25);
        b4.setBorderPainted(false);
        b4.setFocusPainted(false);
        b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        l3.add(b4);

        b5 = new JButton("PIN CHANGE");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(555,285,160,25);
        b5.setBorderPainted(false);
        b5.setFocusPainted(false);
        b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("BALANCE ENQUIRY");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(340,285,160,25);
        b6.setBorderPainted(false);
        b6.setFocusPainted(false);
        b6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("EXIT");
        b7.setForeground(Color.WHITE);
        b7.setBackground(new Color(65,125,128));
        b7.setBounds(555,320,160,25);
        b7.setBorderPainted(false);
        b7.setFocusPainted(false);
        b7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b7.addActionListener(this);
        l3.add(b7);


        setLayout(null);
        setSize(1550,830);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1){
                new Deposit(pin);
                setVisible(false);
            } else if (e.getSource() == b2) {
                setVisible(false);
                new Withdrawal(pin);
            } else if (e.getSource() == b6) {
                setVisible(false);
                new BalanceEnquiry(pin);
            } else if (e.getSource() == b7) {
                System.exit(0);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new main_Class("");
    }
}
