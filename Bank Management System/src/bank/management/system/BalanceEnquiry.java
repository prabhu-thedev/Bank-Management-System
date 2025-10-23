package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton b1;
    JLabel label2;
    String pin;
    BalanceEnquiry(String pin){
        this.pin = pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1300,650);
        add(l3);

        JLabel label1 = new JLabel("Your Current Balance Is ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(360,140,400,35);
        l3.add(label1);

        label2 = new JLabel();
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,18));
        label2.setBounds(360,170,700,35);
        l3.add(label2);

        b1 = new JButton("Back");
        b1.setBounds(590,325,120,25);
        b1.setBackground(new Color(65,125,128));
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        int bal = 0;
        try {
            Con c = new Con();  // your DB connection class
            String query = "SELECT type, amount FROM bank WHERE pin = ?";
            PreparedStatement ps = c.connection.prepareStatement(query);
            ps.setString(1, pin);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String type = rs.getString("type");
                int amount = rs.getInt("amount");

                if ("Deposit".equalsIgnoreCase(type)) {
                    bal += amount;
                } else if ("Withdrawal".equalsIgnoreCase(type)) {
                    bal -= amount;
                }
            }

            label2.setText(String.valueOf(bal));

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        }


        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            setVisible(false);
            new main_Class(pin);
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"ERROR " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}
