package bank.management.system;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
 JButton b1,b2,b3,b4,b5,b6,b7;
 String pin ;
    FastCash(String pin){

        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1300,650);
        add(l3);

        JLabel label = new JLabel("PLEASE SELECT WITHDRAWAL AMOUNT");
        label.setBounds(345,130,400,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,18));
        l3.add(label);

        b1 = new JButton("RS. 100");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(65,125,128));
        b1.setBounds(340,215,160,25);
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("RS. 500");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(65,125,128));
        b2.setBounds(555,215,160,25);
        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.addActionListener(this);
        l3.add(b2);

        b3 = new JButton("RS. 1000");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(65,125,128));
        b3.setBounds(340,250,160,25);
        b3.setBorderPainted(false);
        b3.setFocusPainted(false);
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.addActionListener(this);
        l3.add(b3);

        b4 = new JButton("RS. 2000");
        b4.setForeground(Color.WHITE);
        b4.setBackground(new Color(65,125,128));
        b4.setBounds(555,250,160,25);
        b4.setBorderPainted(false);
        b4.setFocusPainted(false);
        b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        l3.add(b4);

        b5 = new JButton("RS. 5000");
        b5.setForeground(Color.WHITE);
        b5.setBackground(new Color(65,125,128));
        b5.setBounds(555,285,160,25);
        b5.setBorderPainted(false);
        b5.setFocusPainted(false);
        b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b5.addActionListener(this);
        l3.add(b5);

        b6 = new JButton("RS. 10000");
        b6.setForeground(Color.WHITE);
        b6.setBackground(new Color(65,125,128));
        b6.setBounds(340,285,160,25);
        b6.setBorderPainted(false);
        b6.setFocusPainted(false);
        b6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b6.addActionListener(this);
        l3.add(b6);

        b7 = new JButton("BACK");
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
       if (e.getSource() == b7){
           setVisible(false);
           new main_Class(pin);
       } else {
           int amount = Integer.parseInt(((JButton)e.getSource()).getText().substring(4));
           try{
               Con c1 = new Con();
               String q = "SELECT * FROM bank WHERE pin = ?";
               PreparedStatement ps = c1.connection.prepareStatement(q);
               ps.setString(1,pin);
               ResultSet rs = ps.executeQuery();

               int bal = 0;
               while(rs.next()){
                   String type = rs.getString("type");
                   int amount1 = rs.getInt("amount");

                   if ("Deposit".equalsIgnoreCase(type)) {
                       bal += amount;
                   } else if ("Withdrawal".equalsIgnoreCase(type)) {
                       bal -= amount;
                   }
               }
               String num = "17";
               if (bal > amount){
                   JOptionPane.showMessageDialog(null,"Insufficient Balance");
                   return;
               }
               PreparedStatement insert = c1.connection.prepareStatement(
                       "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)");
               insert.setString(1, pin);
               insert.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
               insert.setString(3, "Withdrawal");
               insert.setInt(4, amount);
               insert.executeUpdate();

               JOptionPane.showMessageDialog(null,"Rs. "+amount+" Debited Successfully");
               setVisible(false);
               new main_Class(pin);
           } catch (Exception ex) {
               ex.printStackTrace();
               JOptionPane.showMessageDialog(null,"ERROR "+ex.getMessage());
           }
       }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
