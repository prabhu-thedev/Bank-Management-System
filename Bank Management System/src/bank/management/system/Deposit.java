package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pin;
    JTextField textField;
    JButton b1, b2;
    Deposit(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1300,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0,0,1300,650);
        add(l3);

        JLabel label1 = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("System",Font.BOLD,16));
        label1.setBounds(360,120,400,35);
        l3.add(label1);

        textField = new JTextField("");
        textField.setFont(new Font("Raleway",Font.BOLD,16));
        textField.setBounds(350,160,350,35);
        textField.setBackground(new Color(65,125,128));
        textField.setForeground(Color.WHITE);
        l3.add(textField);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(610,285,100,25);
        b1.setBackground(new Color(65,125,128));
        b1.setBorderPainted(false);
        b1.setFocusPainted(false);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(610,325,100,25);
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
        try {
            String amount = textField.getText();
            Date date = new Date();
            if (e.getSource() == b1){
                if (!amount.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid numeric amount");
                } else {
                    Con c1 = new Con();
                    PreparedStatement ps = c1.connection.prepareStatement(
                            "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)"
                    );
                    ps.setString(1, pin);
                    ps.setString(2, date.toString());
                    ps.setString(3, "Deposit");
                    ps.setString(4, amount);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(null,"Rs. " + amount + " Deposit successful");
                    setVisible(false);
                    new main_Class(pin);
                }
            } else if (e.getSource() == b2) {
                setVisible(false);
                new main_Class(pin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error" + ex.getMessage());
        }

    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
