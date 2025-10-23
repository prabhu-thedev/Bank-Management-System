package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {
    String pin;
    JTextField textField;
    JButton b1, b2;
    Withdrawal(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1300,650);
        add(l3);

        JLabel label1 = new JLabel("MAX WITHDRAWAL IS RS.10,000/-");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(360,120,400,35);
        l3.add(label1);

        JLabel label2 = new JLabel("PLEASE ENTER YOUR AMOUNT");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("System",Font.BOLD,16));
        label2.setBounds(360,150,700,35);
        l3.add(label2);

        textField = new JTextField("");
        textField.setFont(new Font("Raleway",Font.BOLD,16));
        textField.setBounds(350,190,350,35);
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        l3.add(textField);

        b1 = new JButton("WITHDRAWAL");
        b1.setBounds(590,285,120,25);
        b1.setBackground(new Color(65,125,128));
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(590,325,120,25);
        b2.setBackground(new Color(65,125,128));
        b2.setBorderPainted(false);
        b2.setFocusPainted(false);
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String amountStr = textField.getText().trim();
            if (amountStr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
                return;
            }

            try {
                int amount = Integer.parseInt(amountStr);  // ensure numeric
                Con c1 = new Con();
                PreparedStatement ps = c1.connection.prepareStatement("SELECT type, amount FROM bank WHERE pin = ?");
                ps.setString(1, pin);
                ResultSet rs = ps.executeQuery();

                int balance = 0;
                while (rs.next()) {
                    if ("Deposit".equalsIgnoreCase(rs.getString("type")))
                        balance += rs.getInt("amount");
                    else
                        balance -= rs.getInt("amount");
                }

                if (balance < amount) {
                    JOptionPane.showMessageDialog(null, "INSUFFICIENT BALANCE");
                    return;
                }

                PreparedStatement insert = c1.connection.prepareStatement(
                        "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)");
                insert.setString(1, pin);
                insert.setTimestamp(2, new java.sql.Timestamp(System.currentTimeMillis()));
                insert.setString(3, "Withdrawal");
                insert.setInt(4, amount);
                insert.executeUpdate();

                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited successfully");
                setVisible(false);
                new main_Class(pin);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        } else if (e.getSource() == b2) {
            setVisible(false);
            new main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");
    }
}
